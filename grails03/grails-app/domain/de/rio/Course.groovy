package de.rio

class Course {
	String name;
	String group;
	String quartal;
	Date   startDate;
	Date   endDate;
	BigDecimal price;
	String scheduleText;

	Room    room;
	Teacher teacher;
	
	static hasMany = [registrations: Registration, lessons: Lesson];
	
    static constraints = {
		name(blank:false)
		group(nullable:true)
		quartal(nullable:true)
		price(nullable:true)
		room(nullable:true)
		scheduleText(nullable:true)
		teacher(nullable:true)
		startDate(nullable:true)
		endDate(nullable:true)
    }
	
	static mapping = {
		group column: 'group_name'
	}
	
	String toString() {
		return "${name} | ${group} | ${quartal} | ${scheduleText}";
	}
	
}
