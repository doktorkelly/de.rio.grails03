package de.rio

import java.util.List;

import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap;

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
	
	@Override
	String toString() {
		String dateStr = date.format("yyyy-MM-dd (EE)");
		return "${dateStr} | ${plan}"
	}

	@Override
	Object clone() {
		Lesson clone = new Lesson();
		clone.course = this.course;
		clone.plan = this.plan;
		clone.date = this.date;
		clone.teacher = this.teacher;
		clone.numStudents = this.numStudents;
		clone.state = this.state;
		clone.homework = this.homework;
		return clone;
	}	
	
	static List<Lesson> listInDefaultOrder(GrailsParameterMap params) {
		def c = Lesson.createCriteria();
		List<Lesson> results = c.list(max: params.max, offset: params.offset) {
			order("course", "asc")
			order("date", "asc")
		}
		return results;
	}
	
}
