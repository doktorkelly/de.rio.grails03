
<%@ page import="de.rio.Course" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'course.label', default: 'Course')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-course" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-course" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list course">
			
				<g:if test="${courseInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="course.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${courseInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="property-label"><g:message code="course.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${courseInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.room}">
				<li class="fieldcontain">
					<span id="room-label" class="property-label"><g:message code="course.room.label" default="Room" /></span>
					
						<span class="property-value" aria-labelledby="room-label"><g:fieldValue bean="${courseInstance}" field="room"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.scheduleText}">
				<li class="fieldcontain">
					<span id="scheduleText-label" class="property-label"><g:message code="course.scheduleText.label" default="Schedule Text" /></span>
					
						<span class="property-value" aria-labelledby="scheduleText-label"><g:fieldValue bean="${courseInstance}" field="scheduleText"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.teacher}">
				<li class="fieldcontain">
					<span id="teacher-label" class="property-label"><g:message code="course.teacher.label" default="Teacher" /></span>
					
						<span class="property-value" aria-labelledby="teacher-label"><g:link controller="teacher" action="show" id="${courseInstance?.teacher?.id}">${courseInstance?.teacher?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.startDate}">
				<li class="fieldcontain">
					<span id="startDate-label" class="property-label"><g:message code="course.startDate.label" default="Start Date" /></span>
					
						<span class="property-value" aria-labelledby="startDate-label"><g:formatDate date="${courseInstance?.startDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.endDate}">
				<li class="fieldcontain">
					<span id="endDate-label" class="property-label"><g:message code="course.endDate.label" default="End Date" /></span>
					
						<span class="property-value" aria-labelledby="endDate-label"><g:formatDate date="${courseInstance?.endDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.lessons}">
				<li class="fieldcontain">
					<span id="lessons-label" class="property-label"><g:message code="course.lessons.label" default="Lessons" /></span>
					
						<g:each in="${courseInstance.lessons}" var="l">
						<span class="property-value" aria-labelledby="lessons-label"><g:link controller="lesson" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${courseInstance?.registrations}">
				<li class="fieldcontain">
					<span id="registrations-label" class="property-label"><g:message code="course.registrations.label" default="Registrations" /></span>
					
						<g:each in="${courseInstance.registrations}" var="r">
						<span class="property-value" aria-labelledby="registrations-label"><g:link controller="registration" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${courseInstance?.id}" />
					<g:link class="edit" action="edit" id="${courseInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
