package de.rio

import static org.junit.Assert.*
import org.junit.*

class CourseITests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }
	
	@Test
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
