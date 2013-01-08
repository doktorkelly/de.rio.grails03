package de.rio

import static org.junit.Assert.*
import java.util.logging.Logger;
import org.junit.*

class RegistrationITests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testListByFilter() {
		//setup
		Course c01 = new Course(name: "c01").save(flush: true);
		Course c02 = new Course(name: "c02").save(flush: true);
		Course c03 = new Course(name: "c03").save(flush: true);
		Student s01 = new Student(lastName: "s01", firstName: "f01").save(flush: true);
		Student s02 = new Student(lastName: "s02", firstName: "f02").save(flush: true);
		Student s03 = new Student(lastName: "s03", firstName: "f03").save(flush: true);
		Registration r01 = new Registration(course: c01, student: s01, paid: false).save(flush: true);
		Registration r02 = new Registration(course: c02, student: s02, paid: true).save(flush: true);
		Registration r03 = new Registration(course: c03, student: s03).save(flush: true);
		
		//execute
		Map params = [
			courseName: null,
			studentLastName: 's01', studentFirstName: 'f01',
			max: 10, offset: 0];
		List<Registration> resultList = Registration.listByPropertyFilter(params);
		
		//verify
		log.info(""
			+ "\nparams:      " + params
			+ "\nresultList:  " + resultList
			);
		assertEquals(resultList.size(), 1);
		assertEquals(resultList, [r01]);
    }
}
