package de.rio



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Registration)
class RegistrationTests {
	
	void testListInDefaultOrder() {
		//setup:
		Registration registration2 = new Registration(
			course: new Course(name: "c2"), 
			student: new Student(lastName: "last02", firstName: "first02"))
			.save(flush: true);
		Registration registration1 = new Registration(
			course: new Course(name: "c1"), 
			student: new Student(lastName: "last01", firstName: "first01"))
			.save(flush: true)
		Map params = [max: 10, offset: 0];
		
		//execute:
		List<Registration> registrationList = Registration.listInDefaultOrder(params);
		
		//verify:
		Registration registrationExp1 = Registration.where {
			course.name == "c1" }
			.find();
		Registration registrationExp2 = Registration.find { course.name == "c2" };
		List<Registration> registrationsExp = [registrationExp1, registrationExp2];
		log.info(""
			+ "\nregistrationList:  " + registrationList
			+ "\nregistrationsExp:  " + registrationsExp ); 
		assertEquals(registrationList.size(), 2);
		assertEquals(registrationList, registrationsExp);
	}
}
