package de.rio

import grails.orm.PagedResultList
import grails.plugins.springsecurity.Secured;

@Secured(['ROLE_USER'])
class LessonController {
	def scaffold = true;
	
	def copy(Long id) {
		Lesson lesson1 = Lesson.get(id);
		Lesson lesson2 = lesson1.clone();
		if (lesson2.validate() && lesson2.save(flush: true)) {
			redirect(action: "list");
		}
		else {
			log.info(""
				+ "\nlesson1.id:  " + lesson1.id
				+ "\nlesson2.id:  " + lesson2.id
				+ "\nlesson1:     " + lesson1
				+ "\nlesson2:     " + lesson2
				);
			flash.message = message(
				code: 'default.not.created.message',
				args: [message(code: 'lesson.label', default: 'Lesson'), lesson2.id]);
			redirect(action: "listByFilter");
		}
	}
	
	def list(Integer max) {
		params.max = Math.min(max ?: 20, 100)
		List<Lesson> lessonList = null;
		if (! params.sort) {
			lessonList = Lesson.listInDefaultOrder(params);
		}
		else {
			lessonList = Lesson.list(params);
		}
		[lessonInstanceList: lessonList, 
		lessonInstanceTotal: Lesson.count()]
	}
	
	def listByFilter(Integer max) {
		params.max = Math.min(max ?: 20, 100);
		PagedResultList lessons = Lesson.listByPropertyFilter(params);
		Integer lessonsTotal = lessons.getTotalCount();
		render(
			view: "list",
			model: [
				params: params,
				lessonInstanceList: lessons,
				lessonInstanceTotal: lessonsTotal] );
	}
	
}
