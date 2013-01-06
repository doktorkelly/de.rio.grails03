package de.rio

import grails.plugins.springsecurity.Secured;
import org.springframework.dao.DataIntegrityViolationException;

@Secured(['ROLE_USER'])
class CourseController {
	def scaffold = Course;

	def list(Integer max) {
		params.max = Math.min(max ?: 20, 100)
		List<Course> courseList = null;
		if (! params.sort) {
			courseList = Course.listInDefaultOrder(params);
		}
		else {
			courseList = Course.list(params);
		}
		[courseInstanceList: courseList, courseInstanceTotal: Course.count()]
	}
	
	def copy(Long id) {
		Course course1 = Course.get(id);
		Course course2 = course1.clone();
		if (!course2.save(flush: true)) {
			flash.message = message(
				code: 'default.not.created.message',
				args: [message(code: 'course.label', default: 'Course'), course2.id]);
			redirect(action: "list");
		}
		redirect(action: "list");
	}
	
	
	/**************************************************************************
	 * Register Operations
	 *************************************************************************/
		
	def createStud() {
		render(view: "createStud", 
			model: [
				studentInstance: new Student(params),
				courseId:        params.courseId]);
	}

	def saveStud() {
		def studentInstance = new Student(params)
		if (!studentInstance.save(flush: true)) {
			render(view: "createStud", model: [studentInstance: studentInstance])
			return
		}
		flash.message = message(code: 'default.created.message', args: [message(code: 'student.label', default: 'Student'), studentInstance.id])
		redirect(action: "createReg", params: ['course.id': params.courseId, 'student.id': studentInstance.id]);
		//redirect(action: "edit", id: studentInstance.course.id)
	}
	
	def createReg() {
		render(view: "createReg", model: [registrationInstance: new Registration(params)]);
	}

	def saveReg() {
		def registrationInstance = new Registration(params)
		if (!registrationInstance.save(flush: true)) {
			render(view: "createReg", model: [registrationInstance: registrationInstance])
			return
		}
		flash.message = message(code: 'default.created.message', args: [message(code: 'registration.label', default: 'Registration'), registrationInstance.id])
		redirect(action: "edit", id: registrationInstance.course.id)
	}
	
	def editReg(Long id) {
		def registrationInstance = Registration.get(id)
		if (!registrationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'registration.label', default: 'Registration'), id])
			redirect(action: "list") //check
			return
		}
		render(view: "editReg", model: [registrationInstance: registrationInstance]);
	}

	def updateReg(Long id, Long version) {
		def registrationInstance = Registration.get(id)
		if (!registrationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'registration.label', default: 'Registration'), id])
			redirect(action: "list") //check
			return
		}
		if (version != null) {
			if (registrationInstance.version > version) {
				registrationInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						  [message(code: 'registration.label', default: 'Registration')] as Object[],
						  "Another user has updated this Registration while you were editing")
				render(view: "editReg", model: [registrationInstance: registrationInstance])
				return
			}
		}
		registrationInstance.properties = params
		if (!registrationInstance.save(flush: true)) {
			render(view: "editReg", model: [registrationInstance: registrationInstance])
			return
		}
		flash.message = message(code: 'default.updated.message', args: [message(code: 'registration.label', default: 'Registration'), registrationInstance.id])
		redirect(action: "edit", id: registrationInstance.course.id)
	}
	
	def deleteReg(Long id) {
		def registrationInstance = Registration.get(id)
		if (!registrationInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'registration.label', default: 'Registration'), id])
			redirect(action: "list") //check
			return
		}
		try {
			registrationInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'registration.label', default: 'Registration'), id])
			redirect(action: "edit", id: registrationInstance.course.id)
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'registration.label', default: 'Registration'), id])
			redirect(action: "show", id: id)
		}
	}

	
}
