package de.rio

import grails.orm.PagedResultList;

import java.util.List;

class Registration {
	Date dateCreated;
	Boolean paid;
	BigDecimal specialPrice;
	
	static belongsTo = [course: Course, student: Student];
	
	static mapping = {
		course sort: 'name', order: 'asc'
		student sort: 'lastName', order: 'asc'
	}
	
    static constraints = {
		course()
		student()
		paid(nullable:true)
		specialPrice(nullable:true)
		dateCreated(nullable:true)
    }
	
	BigDecimal getRealPrice() {
		BigDecimal realPrice = 0;
		if (specialPrice) {
			realPrice = specialPrice;
		}
		else if (course?.price) {
			realPrice = course.price;
		} 		
		if (realPrice == null) {
			realPrice = 0;
		}
		return realPrice;
	}
	
	static BigDecimal getTotalPrice(List<Registration> registrationList) {
		if (registrationList == null || registrationList.size() == 0) {
			return 0;
		}
		BigDecimal total = registrationList*.getRealPrice().sum();
		if (total == null) {
			total = 0;
		}
		return total;
	}
	
	static BigDecimal getTotalPaid(List<Registration> registrationList) {
		if (registrationList == null || registrationList.size() == 0) {
			return 0;
		}
		BigDecimal total = 0;
		registrationList = registrationList.findAll{ x -> x.paid };
		total = registrationList*.getRealPrice().sum();
		if (total == null) {
			total = 0;
		}
		return total;
	}
	
	/**
	 * TODO: order by course.name + student.lastName
	 * @param params
	 * @return
	 * @deprecated use listByPropertyFiler()
	 */
	static List<Registration> listInDefaultOrder(Map params) {
		def c = Registration.createCriteria();
		List<Registration> results = c.list(max: params.max, offset: params.offset) {
			order("course", "asc")
			order("student", "asc")
		}
		return results;
	}
	
	/**
	 * return all registration that match params
	 * params is a field,value map, filtering registration properties
	 * params keys:
	 * courseId,
	 * studentId
	 * paid
	 * @param params
	 * @return
	 */
	static PagedResultList listByPropertyFilter(Map params) {
		def c = Registration.createCriteria();
		PagedResultList registrations = c.list(max: params.max, offset: params.offset) {
			and {
				if (params.courseId && params.courseId != 'null') {
					course {
						eq('id', params.courseId.toLong());
					}
				}
				if (params.studentId && params.studentId != 'null') {
					student {
						eq('id', params.studentId.toLong());
					}
				}
				if (params.hasPaid && params.hasPaid != 'null') {
					eq('paid', params.hasPaid.toBoolean());
				}
			}
			course {
				order('name', 'asc')
			}
			student {
				order('lastName', 'asc')
				order('firstName', 'asc')
			}
		}
		return registrations;
	}
	
	@Override
	String toString() {
		return toString(4);
	}
	
	String toString(int numFields) {
		switch(numFields) {
			case 1: return "${course.name}";
			case 2: return "${course.name} | ${student.lastName}";
			case 3: return "${course.name} | ${student.lastName}, ${student.firstName}";
			case 4: return "${course.name} | ${student.lastName}, ${student.firstName} | ${getRealPrice()}";
			default: return "${course.name} | ${student.lastName}, ${student.firstName} | ${getRealPrice()}";
		}
	}
}






