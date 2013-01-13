<%@ page import="de.rio.Registration" %>



<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'course', 'error')} required">
	<label for="course">
		<g:message code="registration.course.label" default="Course" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="course" name="course.id" from="${de.rio.Course.list()}" optionKey="id" required="" value="${registrationInstance?.course?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'student', 'error')} required">
	<label for="student">
		<g:message code="registration.student.label" default="Student" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="student" name="student.id" from="${de.rio.Student.list()}" optionKey="id" required="" value="${registrationInstance?.student?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'paid', 'error')} ">
	<label for="paid">
		<g:message code="registration.paid.label" default="Paid" />
		
	</label>
	<g:checkBox name="paid" value="${registrationInstance?.paid}" />
</div>

<div class="fieldcontain ${hasErrors(bean: registrationInstance, field: 'specialPrice', 'error')} ">
	<label for="specialPrice">
		<g:message code="registration.specialPrice.label" default="Special Price" />
		
	</label>
	<g:field name="specialPrice" value="${fieldValue(bean: registrationInstance, field: 'specialPrice')}"/>
</div>

