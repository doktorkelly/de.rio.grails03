package de.rio



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Lesson)
class LessonTests {

	@Test
	void testToString() {
		Course course = new Course(name: "course01");
		Date date = new Date(113,00,01); // = 2013-01-01 !
		String plan = "plan01";
		Lesson lesson = new Lesson(date: date, course: course, plan: plan);
		String lessonStr = lesson.toString();
		log.info("lessonStr: " + lessonStr);
		assertEquals("2013-01-01 (Di) | plan01", lessonStr);
	}


}
