package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_ADMIN'])
class RoleController {

	static scaffold = true;
	
    //def index() { }
}
