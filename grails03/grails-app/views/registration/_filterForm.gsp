<%@ page import="de.rio.Registration" %>


<g:form action="listByFilter" >
	<fieldset>		
		<div>
			course
			<g:select id="course" name="courseId" from="${de.rio.Course.list()}"  
				optionKey="id" optionValue="${{it.toString(3)}}" 
				noSelection="${['null':'all']}" 
				required="" class="many-to-one"/>
			student
			<g:select id="student" name="studentId" from="${de.rio.Student.list()}" 
				optionKey="id"  
				noSelection="${['null':'all']}" 
				/>
			<g:submitButton name="filter" value="filter" />
		</div>
	</fieldset>
</g:form>


