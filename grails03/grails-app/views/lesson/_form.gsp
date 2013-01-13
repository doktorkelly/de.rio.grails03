<%@ page import="de.rio.Lesson" %>



<div class="fieldcontain ${hasErrors(bean: lessonInstance, field: 'course', 'error')} required">
	<label for="course">
		<g:message code="lesson.course.label" default="Course" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="course" name="course.id" from="${de.rio.Course.list()}" optionKey="id" required="" value="${lessonInstance?.course?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lessonInstance, field: 'plan', 'error')} ">
	<label for="plan">
		<g:message code="lesson.plan.label" default="Plan" />
		
	</label>
	<g:textField name="plan" value="${lessonInstance?.plan}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lessonInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="lesson.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${lessonInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: lessonInstance, field: 'teacher', 'error')} ">
	<label for="teacher">
		<g:message code="lesson.teacher.label" default="Teacher" />
		
	</label>
	<g:select id="teacher" name="teacher.id" from="${de.rio.Teacher.list()}" optionKey="id" value="${lessonInstance?.teacher?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lessonInstance, field: 'numStudents', 'error')} ">
	<label for="numStudents">
		<g:message code="lesson.numStudents.label" default="Num Students" />
		
	</label>
	<g:field name="numStudents" type="number" value="${lessonInstance.numStudents}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lessonInstance, field: 'state', 'error')} ">
	<label for="state">
		<g:message code="lesson.state.label" default="State" />
		
	</label>
	<g:textField name="state" value="${lessonInstance?.state}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lessonInstance, field: 'homework', 'error')} ">
	<label for="homework">
		<g:message code="lesson.homework.label" default="Homework" />
		
	</label>
	<g:textField name="homework" value="${lessonInstance?.homework}"/>
</div>

