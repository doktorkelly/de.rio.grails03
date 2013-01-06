<%@ page import="de.rio.Student" %>



<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="student.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${studentInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="student.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${studentInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="student.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${studentInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'request', 'error')} ">
	<label for="request">
		<g:message code="student.request.label" default="Request" />
		
	</label>
	<g:textArea name="request" cols="40" rows="5" maxlength="1024" value="${studentInstance?.request}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'phone', 'error')} ">
	<label for="phone">
		<g:message code="student.phone.label" default="Phone" />
		
	</label>
	<g:textField name="phone" value="${studentInstance?.phone}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'phone2', 'error')} ">
	<label for="phone2">
		<g:message code="student.phone2.label" default="Phone2" />
		
	</label>
	<g:textField name="phone2" value="${studentInstance?.phone2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="student.address.label" default="Address" />
		
	</label>
	<g:textField name="address" value="${studentInstance?.address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'zipcode', 'error')} ">
	<label for="zipcode">
		<g:message code="student.zipcode.label" default="Zipcode" />
		
	</label>
	<g:textField name="zipcode" value="${studentInstance?.zipcode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="student.city.label" default="City" />
		
	</label>
	<g:textField name="city" value="${studentInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'gender', 'error')} ">
	<label for="gender">
		<g:message code="student.gender.label" default="Gender" />
		
	</label>
	<g:select name="gender" from="${studentInstance.constraints.gender.inList}" value="${studentInstance?.gender}" valueMessagePrefix="student.gender" noSelection="['': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'dateOfBirth', 'error')} ">
	<label for="dateOfBirth">
		<g:message code="student.dateOfBirth.label" default="Date Of Birth" />
		
	</label>
	<g:datePicker name="dateOfBirth" precision="day"  value="${studentInstance?.dateOfBirth}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: studentInstance, field: 'registrations', 'error')} ">
	<label for="registrations">
		<g:message code="student.registrations.label" default="Registrations" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${studentInstance?.registrations?}" var="r">
    <li><g:link controller="registration" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="registration" action="create" params="['student.id': studentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'registration.label', default: 'Registration')])}</g:link>
</li>
</ul>

</div>

