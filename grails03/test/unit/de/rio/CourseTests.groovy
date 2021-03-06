package de.rio

import grails.test.mixin.*
import org.junit.*


/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Course)
class CourseTests {

	void testClone() {
		//setup:
		Course course1 = new Course(name: "test01");
		Course course2 = course1.clone();
		
		//execute:
		course2.save(flush: true);
		
		//verify:
		log.info(""
			+ "\ncourse1: " + course1
			+ "\ncourse2: " + course2);
		assertNotSame(course1, course2);
		assertEquals(course1.name, course2.name);
	}
	
	void testListInDefaultOrder() {
		//setup:
		Course course2 = new Course(name: "test02").save(flush: true);
		Course course1 = new Course(name: "test01").save(flush: true);
		Map params = [max: 10, offset: 0];
		
		//execute:
		List<Course> courseList = Course.listInDefaultOrder(params);
		
		//verify:
		log.info(""
			+ "\ncourseList: " + courseList);
		Course courseExp1 = Course.findByName("test01");
		Course courseExp2 = Course.findByName("test02");
		assertEquals(courseList.size(), 2);
		assertEquals(courseList, [courseExp1, courseExp2]);
	}
}
