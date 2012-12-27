package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class CourseController {
	def scaffold = Course;

	def list(Integer max) {
		params.max = Math.min(max ?: 20, 100)
		List<Course> courseList = null;
		if (! params.sort) {
			courseList = Course.listInDefaultOrder(params);
		}
		else {
			courseList = Course.list(params);
		}
		[courseInstanceList: courseList, courseInstanceTotal: Course.count()]
	}
	
	def copy(Long id) {
		Course course1 = Course.get(id);
		Course course2 = course1.clone();
		if (!course2.save(flush: true)) {
			flash.message = message(
				code: 'default.not.created.message',
				args: [message(code: 'course.label', default: 'Course'), course2.id]);
			redirect(action: "list");
		}
		redirect(action: "list");
	}
	
}
