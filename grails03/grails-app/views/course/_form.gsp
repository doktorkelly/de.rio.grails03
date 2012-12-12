<%@ page import="de.rio.Course" %>



<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="course.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${courseInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'price', 'error')} ">
	<label for="price">
		<g:message code="course.price.label" default="Price" />
		
	</label>
	<g:field name="price" value="${fieldValue(bean: courseInstance, field: 'price')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'room', 'error')} ">
	<label for="room">
		<g:message code="course.room.label" default="Room" />
		
	</label>
	<g:textField name="room" value="${courseInstance?.room}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'scheduleText', 'error')} ">
	<label for="scheduleText">
		<g:message code="course.scheduleText.label" default="Schedule Text" />
		
	</label>
	<g:textField name="scheduleText" value="${courseInstance?.scheduleText}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'teacher', 'error')} ">
	<label for="teacher">
		<g:message code="course.teacher.label" default="Teacher" />
		
	</label>
	<g:select id="teacher" name="teacher.id" from="${de.rio.Teacher.list()}" optionKey="id" value="${courseInstance?.teacher?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'startDate', 'error')} ">
	<label for="startDate">
		<g:message code="course.startDate.label" default="Start Date" />
		
	</label>
	<g:datePicker name="startDate" precision="day"  value="${courseInstance?.startDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'endDate', 'error')} ">
	<label for="endDate">
		<g:message code="course.endDate.label" default="End Date" />
		
	</label>
	<g:datePicker name="endDate" precision="day"  value="${courseInstance?.endDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'lessons', 'error')} ">
	<label for="lessons">
		<g:message code="course.lessons.label" default="Lessons" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${courseInstance?.lessons?}" var="l">
    <li><g:link controller="lesson" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="lesson" action="create" params="['course.id': courseInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'lesson.label', default: 'Lesson')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: courseInstance, field: 'registrations', 'error')} ">
	<label for="registrations">
		<g:message code="course.registrations.label" default="Registrations" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${courseInstance?.registrations?}" var="r">
    <li><g:link controller="registration" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registration" action="create" params="['course.id': courseInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registration.label', default: 'Registration')])}</g:link>
</li>
</ul>

</div>

