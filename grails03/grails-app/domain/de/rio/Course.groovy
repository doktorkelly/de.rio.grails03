package de.rio

// import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap;

class Course {
	String name;
	String group;
	String quartal;
	Date   startDate;
	Date   endDate;
	BigDecimal price;
	BigDecimal units;
	String scheduleText;

	Room    room;
	Teacher teacher;
	
	static hasMany = [registrations: Registration, lessons: Lesson];
	
    static constraints = {
		name(blank:false)
		group(nullable:true)
		scheduleText(nullable:true)
		units(nullable:true)
		price(nullable:true)
		teacher(nullable:true)
		room(nullable:true)
		quartal(nullable:true)
		startDate(nullable:true)
		endDate(nullable:true)
    }
	
	static mapping = {
		group column: 'group_name'
		registrations sort:'student', order: 'asc'
		lessons       sort:'date', order: 'asc'
	}
	
	@Override
	String toString() {
		return toString(4);
	}
	
	String toString(int numFields) {
		switch(numFields) {
			case 1: return "${name}";
			case 2: return "${name} | ${group}";
			case 3: return "${name} | ${group} | ${quartal}";
			case 4: return "${name} | ${group} | ${quartal} | ${scheduleText}";
			default: return "${name} | ${group} | ${quartal} | ${scheduleText}";
		}
	}
	
	@Override
	Object clone() {
		Course clone = new Course();
		clone.name = this.name;
		clone.group = this.group;
		clone.quartal = this.quartal;
		clone.price = this.price;
		clone.units = this.units;
		clone.room = this.room;
		clone.scheduleText = this.scheduleText;
		clone.teacher = this.teacher;
		clone.startDate = this.startDate;
		clone.endDate = this.endDate;
		return clone;
	}
	
	static List<Course> listInDefaultOrder(Map params) {
		def c = Course.createCriteria();
		List<Course> results = c.list(max: params.max, offset: params.offset) {
			order("name", "asc")
			order("group", "asc")
			order("quartal", "asc")
		}
		return results;
	}
	
}






