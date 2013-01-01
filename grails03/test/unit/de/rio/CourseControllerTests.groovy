package de.rio



import grails.test.mixin.*
import org.junit.*
import grails.test.mixin.domain.DomainClassUnitTestMixin

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(CourseController)
@TestMixin(DomainClassUnitTestMixin)
class CourseControllerTests {

	void testList() {
		//setup:
		// params.sort = "name";
		// params.max = 20;
		// params.offset = 0;
		mockDomain(Course, [
			[name: 'last02', group: 'A', quartal: 'Q1/2013'],
			[name: 'last01', group: 'A', quartal: 'Q1/2013'],
			]);
		
		//execute:
		def model = controller.list();
		
		//verify:
		// assert view == "/course/list";
		Course course1 = Course.findByName('last01');
		Course course2 = Course.findByName('last02');
		assert model.courseInstanceTotal == 2;
		assert model.courseInstanceList == [course2, course1];
	}
}
