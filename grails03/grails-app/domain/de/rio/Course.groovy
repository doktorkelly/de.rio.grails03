package de.rio

class Course {
	String name;
	Date   startDate;
	Date   endDate;
	BigDecimal price;
	String scheduleText;

	Room    room;
	Teacher teacher;
	
	static hasMany = [registrations: Registration, lessons: Lesson];
	
    static constraints = {
		name(blank:false)
		price(nullable:true)
		room(nullable:true)
		scheduleText(nullable:true)
		teacher(nullable:true)
		startDate(nullable:true)
		endDate(nullable:true)
    }
	
	String toString() {
		return "${name} | ${scheduleText}";
	}
}
