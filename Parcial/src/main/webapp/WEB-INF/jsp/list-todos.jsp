<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container">
    <div> 
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>Lista de clases</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th width="20%">Número de clase</th>
                        <th width="15%">Nombre de la clase</th>
                        <th width="15%">Horario de la clase</th>
                        <th width="15%">Docente a cargo</th>
                        <th width="20%">Salón de clase</th>
                        <th width="15%">Estado de la clase</th>
                        <th width="20%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${todo.name}</td>
                            <td>${todo.schedule}</td>
                            <td>${todo.teacher}</td>
                            <td>${todo.classroom}</td>
                            <td>${todo.status}</td>
                            <td>
                                <c:if test="${isAdmin}">
                                    <a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Actualizar</a>
                                    <a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Eliminar</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
    </div>
    <c:if test="${isAdmin}">
        <form action="/add-todo">
            <button type="submit" class="btn btn-primary">AÑADIR CLASES</button>
        </form>
    </c:if>
</div>

<%@ include file="common/footer.jsp"%>

