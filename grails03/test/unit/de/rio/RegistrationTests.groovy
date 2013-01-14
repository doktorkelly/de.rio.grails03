package de.rio

import grails.test.mixin.*
import org.junit.*
import org.apache.log4j.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Registration)
class RegistrationTests {
	
	def log;
	
	@Override
	protected void setUp() {
		initLogger();
	}
	
	private void initLogger() {
		BasicConfigurator.configure();
		LogManager.rootLogger.level = Level.INFO;
		log = LogManager.getLogger("de.rio.RegistrationTest");
	}
	
	@Test
	void testToString() {
		//setup
		initLogger();  //TODO: remove!
		Registration reg = new Registration(
			course: new Course(name: "c01", price: 200),
			student: new Student(lastName: "s01", firstName: "f01"),
			paid: false);
		
		//execute
		String result = reg.toString();
		
		//verify
		log.info(""
			+ "\nresult: " + result);
		assertEquals('c01 | s01, f01 | 200', result);
	}
	
	@Test
	void testGetTotalPrice1() {
		//setup
		initLogger(); //TODO: remove
		List<Registration> registrations = null;
		
		//execute
		Integer priceTotal = Registration.getTotalPrice(registrations);
		
		//verify
		log.info("priceTotal: " + priceTotal);
		assertEquals(0, priceTotal);
	}
	
	@Test
	void testGetTotalPrice2() {
		//setup
		initLogger(); //TODO: remove
		List<Registration> registrations = new ArrayList<Registration>();
		registrations.add(new Registration(
			course:  new Course(name: 'c01', price: 200),
			student: new Student(lastName: 's01', firstName: 'f01')));
		
		//execute
		Integer priceTotal = Registration.getTotalPrice(registrations);
		
		//verify
		log.info("priceTotal: " + priceTotal);
		assertEquals(200, priceTotal);
	}
	

	
}




