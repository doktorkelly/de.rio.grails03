package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class StudentController {
	def scaffold = Student;
	
	def list(Integer max) {
		params.max = Math.min(max ?: 20, 100);
		if (!params.sort) {
			params.sort = 'lastName';
		}
		List<Student> students = Student.list(params);
		[studentInstanceList: students,
		studentInstanceTotal: Student.count()]
	}
}
