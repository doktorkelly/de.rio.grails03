package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class TeacherController {
	def scaffold = true;

//    def index() { }
}
