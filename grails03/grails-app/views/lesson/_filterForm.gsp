<%@ page import="de.rio.Lesson" %>


<g:form action="listByFilter" >
	<fieldset class="filtercontain">		
		<div>
			course
			<g:select id="course" name="courseId" from="${de.rio.Course.listInDefaultOrder(params)}"  
				optionKey="id" optionValue="${{it.toString(3)}}" 
				value="${params.courseId}"
				noSelection="${['null':'all']}" 
				required="" class="many-to-one"/>
			<g:submitButton name="filter" value="filter" />
		</div>
	</fieldset>
</g:form>


