package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class RegistrationController {
	def scaffold = Registration;
	
//    def index() { }
	
	def list(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		List<Registration> registrations = Registration.list(sort: "course.name");
		[registrationInstanceList: registrations, 
		registrationInstanceTotal: Registration.count()]
	}
	
}
