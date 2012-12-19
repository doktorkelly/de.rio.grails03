package de.rio

class Lesson {
	String plan;
	Date date;
	Teacher teacher;
	BigInteger numStudents;
	String state;
	String homework;
	
	static belongsTo = [course: Course];

    static constraints = {
		course(nullable:false)
		plan(nullable:true)
		date(blank:false)
		teacher(nullable:true)
		numStudents(nullable:true)
		state(nullable:true)
		homework(nullable:true)
    }
	
	String toString() {
		String dateStr = date.format("yyyy-MM-dd (EE)");
		return "${dateStr} | ${plan}"
	}
	
}
