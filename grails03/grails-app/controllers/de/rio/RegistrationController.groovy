package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class RegistrationController {
	def scaffold = Registration;	
	
	def list(Integer max) {
		params.max = Math.min(max ?: 20, 100)
		List<Registration> registrations = 
			Registration.list(sort: "course.name", max: params.max, offset: params.offset);
		[registrationInstanceList: registrations, 
		registrationInstanceTotal: Registration.count()]
	}
	
}
