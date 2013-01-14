package de.rio

import grails.orm.HibernateCriteriaBuilder
import grails.orm.PagedResultList;

import java.util.List;
import java.util.Map;

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
	
	static String DATEFORMAT = "yyyy-MM-dd (EE)";
	
	@Override
	String toString() {
		String dateStr = date.format(DATEFORMAT);
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
	
	static PagedResultList listByPropertyFilter(Map params) {
		if (params == null) {
			params = new HashMap();
		}
		HibernateCriteriaBuilder c = Lesson.createCriteria();
		PagedResultList lessons = c.list(max: params.max, offset: params.offset) {
			and {
				if (params.courseId && params.courseId != 'null') {
					course {
						eq('id', params.courseId.toLong());
					}
				}
			}
			if (params.sort) {
				order(params.sort, 'asc')
			}
			else {
				course {
					order('name', 'asc')
				}
				order('date', 'asc')
			}
		}
		return lessons;
	}
	
}
