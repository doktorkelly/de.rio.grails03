package de.rio

import static org.junit.Assert.*
import grails.orm.PagedResultList;

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
    void testListByFilter1() {
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
			courseId: c01.id,
			studentId: 'null',
			max: 10, offset: 0];
		List<Registration> resultList = Registration.listByPropertyFilter(params);
		
		//verify
		log.info(""
			+ "\nparams:      " + params
			+ "\nresultList:  " + resultList
			);
		assertEquals(1, resultList.size());
		assertEquals([r01], resultList);
    }
	
	@Test
	void testListByFilter2() {
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
			courseId: null,
			studentId: 'null',
			max: 2, offset: 0];
		PagedResultList resultList = Registration.listByPropertyFilter(params);
		Integer resultsTotal = resultList?.getTotalCount();
		
		//verify
		log.info(""
			+ "\nparams:       " + params
			+ "\nresultList:   " + resultList
			+ "\nresultsSize:  " + resultList?.size()
			+ "\nresultsTotal: " + resultsTotal
			);
		assertEquals(2, resultList?.size());
		assertEquals(3, resultsTotal);
		assertEquals([r01,r02], resultList);
	}
	

	
	@Test
	void testToString() {
		//setup
		Registration reg = new Registration(
			course: new Course(name: "c01", price: 200),
			student: new Student(lastName: "s01", firstName: "f01"),
			paid: false);
		//execute
		String result = reg.toString();
		//verify
		log.info(""
			+ "\nresult: " + result);
		assertEquals("c01 | s01, f01 | 200", result);
	}
}





