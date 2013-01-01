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
	
	String toString() {
		return "${course.name} | ${student.lastName}, ${student.firstName} | ${getRealPrice()}";
	}
}
