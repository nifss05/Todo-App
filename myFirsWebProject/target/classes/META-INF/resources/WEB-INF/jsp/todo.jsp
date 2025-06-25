<%@ include file="common/header.jspf" %>
<style>
  /* Datepicker Popup Background */
  .datepicker.dropdown-menu {
      background-color: #343a40;
      border: 1px solid #6c757d;
      color: #fff;
  }

  /* Day numbers */
  .datepicker table tr td,
  .datepicker table tr th {
      color: #fff;
  }

  /* Hover effect */
  .datepicker table tr td.day:hover, 
  .datepicker table tr td.day.focused {
      background: #495057;
      color: #fff;
  }

  /* Active (selected) date */
  .datepicker table tr td.active, 
  .datepicker table tr td.active:hover,
  .datepicker table tr td.active.disabled {
      background-color: #198754;
      color: #fff;
  }

  /* Disabled Dates */
  .datepicker table tr td.disabled, 
  .datepicker table tr td.disabled:hover {
      color: #6c757d;
 }
</style>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<h1>Enter todo Details</h1>
		
	<form:form  method="post" modelAttribute="todo">
		<fieldset class="mb-3 bg-dark text-white">
			<form:label class="bg-dark text-white" path="discription" >Description:</form:label>
			<form:input class="bg-secondary text-white" type="text" path="discription" required ="required"/>
			<form:errors class="bg-secondary text-white" path="discription" cssClass="text-warning"/>
		</fieldset>
		
		<fieldset class="mb-3 ">
			<form:label class="bg-dark text-white" path="targetDate" >Target Date:</form:label>
			<form:input class="bg-secondary text-white" type="text" path="targetDate" required ="required"/>
			<form:errors class="bg-secondary text-white" path="targetDate" cssClass="text-warning"/>
		</fieldset>
					
		<form:input type="hidden" path="id" />
		
		<form:input type="hidden" path="done" />
		
		<input type ="submit"class="btn btn-outline-success border
	 	border-3 border-success"/>
	 	
	</form:form>
</div>

<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>





