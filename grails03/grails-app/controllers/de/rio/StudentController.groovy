package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class StudentController {
	def scaffold = Student;
	
//    def index() { }
}
