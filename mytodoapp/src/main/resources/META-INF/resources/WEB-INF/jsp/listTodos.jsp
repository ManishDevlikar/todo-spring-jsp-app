
<%@ include file="common/header.jspf" %>
  <body>
    <%@ include file="common/navigation.jspf" %>

    <div class="container">
      <h3>welcome ${name}</h3>
      <hr />
      <h1>Your Todos</h1>
      <table class="table">
        <thead>
          <tr>
            
            <th>Description</th>
            <th>Target Date</th>
            <th>is Done?</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${todoList}" var="todo">
            <tr>
           
              <td>${todo.description}</td>
              <td>${todo.targetDate}</td>
              <td>${todo.done}</td>
              <td>
                <a href="delete-todo?id=${todo.id}" class="btn btn-danger"
                  >Delete</a
                >
              </td>
              <td>
                <a href="update-todo?id=${todo.id}" class="btn btn-warning"
                  >Update</a
                >
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a class="btn btn-primary" href="add-todo">Add Todo</a>
    </div>
    <%@ include file="common/footer.jspf" %>
  </body>
</html>
