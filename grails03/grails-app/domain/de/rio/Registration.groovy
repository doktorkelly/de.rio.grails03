package de.rio

class Registration {
	Date dateCreated;
	Boolean paid;
	
	static belongsTo = [course: Course, student: Student];
	
    static constraints = {
		course()
		student()
		paid(nullable:true)
		dateCreated(nullable:true)
    }
	
	String toString() {
		return "${course.name} | ${student.lastName}, ${student.firstName}";
	}
}
