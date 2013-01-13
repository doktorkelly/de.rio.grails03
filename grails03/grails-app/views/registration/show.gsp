
<%@ page import="de.rio.Registration" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'registration.label', default: 'Registration')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-registration" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-registration" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list registration">
			
				<g:if test="${registrationInstance?.course}">
				<li class="fieldcontain">
					<span id="course-label" class="property-label"><g:message code="registration.course.label" default="Course" /></span>
					
						<span class="property-value" aria-labelledby="course-label"><g:link controller="course" action="show" id="${registrationInstance?.course?.id}">${registrationInstance?.course?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.student}">
				<li class="fieldcontain">
					<span id="student-label" class="property-label"><g:message code="registration.student.label" default="Student" /></span>
					
						<span class="property-value" aria-labelledby="student-label"><g:link controller="student" action="show" id="${registrationInstance?.student?.id}">${registrationInstance?.student?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.paid}">
				<li class="fieldcontain">
					<span id="paid-label" class="property-label"><g:message code="registration.paid.label" default="Paid" /></span>
					
						<span class="property-value" aria-labelledby="paid-label"><g:formatBoolean boolean="${registrationInstance?.paid}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.specialPrice}">
				<li class="fieldcontain">
					<span id="specialPrice-label" class="property-label"><g:message code="registration.specialPrice.label" default="Special Price" /></span>
					
						<span class="property-value" aria-labelledby="specialPrice-label"><g:fieldValue bean="${registrationInstance}" field="specialPrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${registrationInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="registration.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${registrationInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
			</ol>

			<g:form action="delete">
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${registrationInstance?.id}" />
					<g:link class="edit" action="edit" id="${registrationInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:submitButton name="delete" class="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
				</fieldset>
			</g:form>

		</div>
	</body>
</html>
