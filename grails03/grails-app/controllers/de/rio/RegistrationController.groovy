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
		Integer priceTotal = Registration.getTotalPrice(registrations);
		Integer pricePaid = Registration.getTotalPaid(registrations);
		render(
			view: "list", 
			model: [
				params: params,
				priceTotal: priceTotal,
				pricePaid: pricePaid,
				registrationInstanceList: registrations,
				registrationInstanceTotal: registrationsTotal] );
	}
		
	def print(Integer max) {
		//TODO: user filter
		params.max = Math.min(max ?: 20, 100)
		List<Registration> registrations =
			Registration.list(sort: "course.name", max: params.max, offset: params.offset);
		[registrationInstanceList: registrations,
		registrationInstanceTotal: Registration.count()]
	}
	
}
