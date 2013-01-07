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
	 * @param params
	 * @return
	 */
	static List<Registration> listByPropertyFilter(Map params) {
		List<String> regProps = Registration.metaClass.properties*.name;
		def c = Registration.createCriteria();
		List<Registration> registrations = c.list(max: params.max, offset: params.offset) {
			and {
				course {
					ilike('name', params.courseName);
				}
				student {
					and {
						ilike('lastName', params.studentLastName);
						ilike('firstName', params.studentFirstName);
					}
				}
			}
		}
//		List<Registration> registrations = c.list(max: params.max, offset: params.offset) {
//			and {
//				params.each { field, value ->
//					if (regProps.grep(field) && value) {
//						ilike(field, value);
//					}
//				}
//			}
//		}
		return registrations;
	}
	
	String toString() {
		return "${course.name} | ${student.lastName}, ${student.firstName} | ${getRealPrice()}";
	}
}
