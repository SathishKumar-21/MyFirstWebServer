<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class = "container">

	<h1>Enter Todo Details</h1>

	<form:form method="post" modelAttribute="todo">

	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >

	<fieldset class="mb-3">
		<form:label path="description">Description</form:label>
		<form:input type="text" path="description" required="required"/>
		<form:errors path="description" cssClass="text-warning"/>
	</fieldset>

	<fieldset class="mb-3">
		<form:label path="targetDate">Target Date</form:label>
		<form:input type="text" path="targetDate" required="required"/>
		<form:errors path="targetDate" cssClass="text-warning"/>
	</fieldset>

	<fieldset class="mb-3">
	<label for="done" required="required">Task completed:</label>
	  <input type="radio" id="done" name="done" value="true" >
      <label for="done">Yes</label>
      <input type="radio" id="done" name="done" value="false" required="required">
      <label for="done">No</label>
     </fieldset>

	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format: 'yyyy-mm-dd'
		});
	</script>

	<input type="submit" class="btn btn-success"/>

	</form:form>
<%@ include file="common/footer.jspf" %>