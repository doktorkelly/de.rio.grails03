package de.rio

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
	
	String toString() {
		return "${course.name} | ${student.lastName}, ${student.firstName} | ${getRealPrice()}";
	}
}
