<%@ page import="de.rio.Registration" %>


<g:form action="listByFilter" >
	<fieldset>		
		<div>
			course
			<g:select id="course" name="courseId" from="${de.rio.Course.listInDefaultOrder(params)}"  
				optionKey="id" optionValue="${{it.toString(3)}}" 
				value="${params.courseId}"
				noSelection="${['null':'all']}" 
				required="" class="many-to-one"/>
			student
			<g:select id="student" name="studentId" from="${de.rio.Student.listInDefaultOrder(params)}" 
				optionKey="id"  
				value="${params.studentId}"
				noSelection="${['null':'all']}" 
				/>
				paid
				<g:select id="paid" name="hasPaid" from="${[true, false]}"
				value="${params.hasPaid}"
				noSelection="${['null':'all']}"
				/>
			<g:submitButton name="filter" value="filter" />
		</div>
	</fieldset>
</g:form>


