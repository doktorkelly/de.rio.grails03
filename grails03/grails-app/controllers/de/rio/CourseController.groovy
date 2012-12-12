package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class CourseController {
	def scaffold = true;
	
//    def index() { }
}
