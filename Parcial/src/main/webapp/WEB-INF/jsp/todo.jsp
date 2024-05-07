<%@ include file="common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/navigation.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 ">
            <div class="panel panel-primary">
                <div class="panel-heading">Agregar Clases</div>
                <div class="panel-body">
                    <form:form method="post" modelAttribute="todo">
                        <fieldset class="form-group">
    <form:label path="name">Nombre de la clase (20 caracteres)</form:label>
    <form:input path="name" type="text" class="form-control" required="required" maxlength="20" />
    <form:errors path="name" cssClass="text-warning" />
</fieldset>

<fieldset class="form-group">
    <form:label path="schedule">Horario de clase</form:label>
    <form:input path="schedule" type="number" class="form-control" required="required" min="0" max="24" />
    <form:errors path="schedule" cssClass="text-warning" />
</fieldset>

<fieldset class="form-group">
    <form:label path="teacher">Docente a cargo (100 caracteres)</form:label>
    <form:input path="teacher" type="text" class="form-control" required="required" maxlength="100" />
    <form:errors path="teacher" cssClass="text-warning" />
</fieldset>

<fieldset class="form-group">
    <form:label path="classroom">Salón de clase</form:label>
    <form:input path="classroom" type="text" class="form-control" pattern="[A-Za-z0-9]+" required="required" />
    <form:errors path="classroom" cssClass="text-warning" />
</fieldset>

<fieldset class="form-group">
    <form:label path="status">Estado de clase</form:label>
    <form:select path="status" class="form-control">
        <form:option value="programada" label="Programada" />
        <form:option value="en curso" label="En Curso" />
        <form:option value="cancelada" label="Cancelada" />
        <form:option value="aplazada" label="Aplazada" />
    </form:select>
</fieldset>

                        <button type="submit" class="btn btn-success">Guardar</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp"%>
