package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_ADMIN'])
class UserRoleController {

	static scaffold = true;

//	def index() { }
}
