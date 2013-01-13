package de.rio

import grails.orm.PagedResultList;
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
	
	def listByFilter(Integer max) {
		params.max = Math.min(max ?: 20, 100);
		PagedResultList registrations = Registration.listByPropertyFilter(params);
		Integer registrationsTotal = registrations.getTotalCount();
		render(
			view: "list", 
			model: [
				params: params,
				registrationInstanceList: registrations,
				registrationInstanceTotal: registrationsTotal] );
	}
	
}
