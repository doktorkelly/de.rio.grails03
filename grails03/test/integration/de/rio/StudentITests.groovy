package de.rio

import static org.junit.Assert.*
import org.junit.*

class StudentITests {

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
		Student student3 = new Student(lastName: "test02", firstName: "firsta").save(flush: true);
		Student student2 = new Student(lastName: "test01", firstName: "firstb").save(flush: true);
		Student student1 = new Student(lastName: "test01", firstName: "firsta").save(flush: true);
		Map params = [max: 10, offset: 0];
		
		//execute:
		List<Student> studentList = Student.listInDefaultOrder(params);
		
		//verify:
		log.info(""
			+ "\nstudentList: " + studentList);
		assertEquals(studentList.size(), 3);
		assertEquals(studentList, [student1, student2, student3]);
	}
}
