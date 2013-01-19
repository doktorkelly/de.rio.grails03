
<%@ page import="de.rio.Lesson" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lesson.label', default: 'Lesson')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-lesson" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<!-- <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li> -->
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:render template="filterForm"/></li>				
			</ul>
		</div>
		<div id="list-lesson" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /> 
				(${lessonInstanceTotal})
			</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<th></th>
						<th></th>
					
						<th><g:message code="lesson.course.label" default="Course" /></th>
					
						<g:sortableColumn property="plan" title="${message(code: 'lesson.plan.label', default: 'Plan')}" />
					
						<g:sortableColumn property="date" title="${message(code: 'lesson.date.label', default: 'Date')}" />
					
						<th><g:message code="lesson.teacher.label" default="Teacher" /></th>
					
						<g:sortableColumn property="numStudents" title="${message(code: 'lesson.numStudents.label', default: 'Num Students')}" />
					
						<g:sortableColumn property="state" title="${message(code: 'lesson.state.label', default: 'State')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${lessonInstanceList}" status="i" var="lessonInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td class="extra"><g:link action="edit" id="${lessonInstance.id}">edit</g:link></td>
						<td class="extra"><g:link action="copy" id="${lessonInstance.id}">copy</g:link></td>
					
						<td><g:link action="show" id="${lessonInstance.id}">${fieldValue(bean: lessonInstance, field: "course")}</g:link></td>
					
						<td>${fieldValue(bean: lessonInstance, field: "plan")}</td>
					
						<td><g:formatDate date="${lessonInstance.date}" /></td>
					
						<td>${fieldValue(bean: lessonInstance, field: "teacher")}</td>
					
						<td>${fieldValue(bean: lessonInstance, field: "numStudents")}</td>
					
						<td>${fieldValue(bean: lessonInstance, field: "state")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${lessonInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
