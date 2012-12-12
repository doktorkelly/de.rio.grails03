<!-- before: 
<div id="grailsLogo" role="navigation">
	<a href="http://grails.org">
		<img src="${resource(dir: 'images', file: 'grails_logo.png')}" alt="Grails"/>
	</a>
</div>
-->

<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: '/')}">Home</a></li>
		<li><g:link class="login" controller="login">Login</g:link></li>
		<li><g:link class="logout" controller="logout ">Logout </g:link></li>
		<li><g:link class="list" controller="course">Courses</g:link></li>
		<li><g:link class="list" controller="teacher">Teachers</g:link></li>
		<li><g:link class="list" controller="student">Students</g:link></li>
		<li><g:link class="list" controller="registration">Registrations</g:link></li>
		<li><g:link class="list" controller="lesson">Lessons</g:link></li>
	</ul>
</div>

