package de.rio

import static org.junit.Assert.*

import java.sql.Date;

import org.junit.*

class LessonITests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }
	
	private Map<String,Object> createData() {
		Map<String,Object> dataMap = new HashMap<String, Object>();
		dataMap["c01"] = new Course(name: "c01").save(flush: true);
		dataMap["c02"] = new Course(name: "c02").save(flush: true);
		dataMap["c03"] = new Course(name: "c03").save(flush: true);
		dataMap["l01"] = new Lesson(course: dataMap['c01'], date: new Date(113,0,1)).save(flush: true);
		dataMap["l02"] = new Lesson(course: dataMap['c02'], date: new Date(113,0,1)).save(flush: true);
		dataMap["l03"] = new Lesson(course: dataMap['c03'], date: new Date(113,0,1)).save(flush: true);
		return dataMap;
	}	

	@Test
	void testListByFilter1() {
		//setup
		Map<String,Object> data = createData();
		
		//execute
		Map params = [
			courseId: data['c01'].id,
			max: 10, offset: 0];
		List<Lesson> resultList = Lesson.listByPropertyFilter(params);
		
		//verify
		log.info(""
			+ "\nparams:      " + params
			+ "\nresultList:  " + resultList
			);
		assertEquals(1, resultList.size());
		assertEquals([data['l01']], resultList);
	}
	
	@Test
	void testListByFilter2() {
		//setup
		Map<String,Object> data = createData();
		
		//execute
		Map params = null;
		List<Lesson> resultList = Lesson.listByPropertyFilter(params);
		
		//verify
		log.info(""
			+ "\nparams:      " + params
			+ "\nresultList:  " + resultList
			);
		assertEquals(3, resultList.size());
		assertEquals([data['l01'], data['l02'], data['l03']], resultList);
	}
	
}




