
<%@ page import="de.rio.Lesson" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lesson.label', default: 'Lesson')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-lesson" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-lesson" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list lesson">
			
				<g:if test="${lessonInstance?.course}">
				<li class="fieldcontain">
					<span id="course-label" class="property-label"><g:message code="lesson.course.label" default="Course" /></span>
					
						<span class="property-value" aria-labelledby="course-label"><g:link controller="course" action="show" id="${lessonInstance?.course?.id}">${lessonInstance?.course?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${lessonInstance?.plan}">
				<li class="fieldcontain">
					<span id="plan-label" class="property-label"><g:message code="lesson.plan.label" default="Plan" /></span>
					
						<span class="property-value" aria-labelledby="plan-label"><g:fieldValue bean="${lessonInstance}" field="plan"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lessonInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="lesson.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${lessonInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${lessonInstance?.teacher}">
				<li class="fieldcontain">
					<span id="teacher-label" class="property-label"><g:message code="lesson.teacher.label" default="Teacher" /></span>
					
						<span class="property-value" aria-labelledby="teacher-label"><g:link controller="teacher" action="show" id="${lessonInstance?.teacher?.id}">${lessonInstance?.teacher?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${lessonInstance?.numStudents}">
				<li class="fieldcontain">
					<span id="numStudents-label" class="property-label"><g:message code="lesson.numStudents.label" default="Num Students" /></span>
					
						<span class="property-value" aria-labelledby="numStudents-label"><g:fieldValue bean="${lessonInstance}" field="numStudents"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lessonInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="property-label"><g:message code="lesson.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${lessonInstance}" field="state"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lessonInstance?.homework}">
				<li class="fieldcontain">
					<span id="homework-label" class="property-label"><g:message code="lesson.homework.label" default="Homework" /></span>
					
						<span class="property-value" aria-labelledby="homework-label"><g:fieldValue bean="${lessonInstance}" field="homework"/></span>
					
				</li>
				</g:if>
			
			</ol>

			<g:form action="delete">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${lessonInstance?.id}" />
					<g:link class="edit" action="edit" id="${lessonInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:submitButton name="delete" class="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
				</fieldset>
			</g:form>

		</div>
	</body>
</html>
