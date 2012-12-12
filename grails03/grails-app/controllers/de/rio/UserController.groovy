package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_ADMIN'])
class UserController {

	static scaffold = true;
	
//    def index() { }
}
