package de.rio

import grails.test.mixin.*
import org.junit.*
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsParameterMap
import java.util.logging.Logger
// import org.apache.commons.logging.LogFactory

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Course)
class CourseTests {
	// private static final log = LogFactory.getLog(this);

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
		//TODO
	}
}
