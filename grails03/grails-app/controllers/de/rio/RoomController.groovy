package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class RoomController {
	def scaffold = true;
	
//    def index() { }
}
