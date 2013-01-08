package de.rio

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
		return (specialPrice ? specialPrice : course.price);
	}
	
	/**
	 * TODO: order by course.name + student.lastName
	 * @param params
	 * @return
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
	 * courseName,
	 * studentLastName,
	 * studentFirstName,
	 * paid
	 * @param params
	 * @return
	 */
	static List<Registration> listByPropertyFilter(Map params) {
		List<String> regProps = Registration.metaClass.properties*.name;
		def c = Registration.createCriteria();
		List<Registration> registrations = c.list(max: params.max, offset: params.offset) {
			and {
				if (params.courseName != null) {
					course {
						ilike('name', params.courseName);
					}
				}
				if (params.studentLastName != null) {
					student {
						ilike('lastName', params.studentLastName);
					}
				}
				if (params.studentFirstName != null) {
					student {
						ilike('firstName', params.studentFirstName);
					}
				}
				if (params.paid != null) {
					eq('paid', params.paid);
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
	
	String toString() {
		return "${course.name} | ${student.lastName}, ${student.firstName} | ${getRealPrice()}";
	}
}
