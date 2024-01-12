
<%@ include file="common/header.jspf" %>
  <body>
    <%@ include file="common/navigation.jspf" %>
    <div class="container">
      <h3>welcome ${name}</h3>
      <hr />
      <h1>Add New Todo</h1>
      <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-2">
          <form:label path="description">Description</form:label>
          <form:input
            id="description"
            type="text"
            path="description"
            required="required"
          />
          <form:errors path="description" cssClass="text-warning"></form:errors>
        </fieldset>

        <fieldset>
          <form:label path="targetDate">TargetDate</form:label>
          <form:input
            id="targetDate"
            type="text"
            path="targetDate"
            required="required"
          />
          <form:errors path="targetDate" cssClass="text-warning"></form:errors>
        </fieldset>

        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="done" />
        <input type="submit" class="btn btn-primary" />
      </form:form>
    </div>
   <%@ include file="common/footer.jspf" %>
    <script type="text/javascript">
      $("#targetDate").datepicker({
        format: "yyyy-mm-dd",
      });
    </script>
  </body>
</html>
