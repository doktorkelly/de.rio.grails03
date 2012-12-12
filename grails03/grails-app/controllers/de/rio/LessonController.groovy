package de.rio

import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class LessonController {
	def scaffold = true;
	
//    def index() { }
}
