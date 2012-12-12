
<%@ page import="de.rio.Course" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'course.label', default: 'Course')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-course" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-course" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'course.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'course.price.label', default: 'Price')}" />
					
						<g:sortableColumn property="room" title="${message(code: 'course.room.label', default: 'Room')}" />
					
						<g:sortableColumn property="scheduleText" title="${message(code: 'course.scheduleText.label', default: 'Schedule Text')}" />
					
						<th><g:message code="course.teacher.label" default="Teacher" /></th>
					
						<g:sortableColumn property="startDate" title="${message(code: 'course.startDate.label', default: 'Start Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${courseInstanceList}" status="i" var="courseInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${courseInstance.id}">${fieldValue(bean: courseInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: courseInstance, field: "price")}</td>
					
						<td>${fieldValue(bean: courseInstance, field: "room")}</td>
					
						<td>${fieldValue(bean: courseInstance, field: "scheduleText")}</td>
					
						<td>${fieldValue(bean: courseInstance, field: "teacher")}</td>
					
						<td><g:formatDate date="${courseInstance.startDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${courseInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
