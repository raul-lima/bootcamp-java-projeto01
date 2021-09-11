<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<html>
<head>
    <title>Cadastro de autor</title>
</head>
<body class="container">

<h1 class="text-center bg-info">CADASTRO DE AUTOR</h1>


<form action="<c:url value="/autores"/>" method="post">
    <div class="form-group">
        <label for="nome">Nome</label>
        <input id="nome" class="form-control" name="nome">
    </div>

    <div class="form-group">
        <label for="email">E-mail</label>
        <input id="email" class="form-control" name="email">
    </div>

    <div class="form-group">
        <label for="data-de-nascimento">Data de nascimento</label>
        <input id="data-de-nascimento" class="form-control" name="dataNascimento">
    </div>

    <div class="form-group">
        <label for="mini-curriculo">Mini currículo</label>
        <input id="mini-curriculo" class="form-control" name="miniCurriculo">
    </div>

    <input type="submit" value="Cadastrar" class="mt-2 btn-primary">

</form>

<h1 class="text-center bg-info">LISTA DE AUTORES</h1>

<table class="table table-hover table-striped table-bordered">
    <thead class="table-info">
    <tr>
        <th>NOME</th>
        <th>E-MAIL</th>
        <th>DATA DE NASCIMENTO</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${autores}" var="autor">
        <tr class="table-primary">
            <td>${autor.nome}</td>
            <td>${autor.email}</td>
            <td>
                <fmt:parseDate value="${autor.dataNascimento}" pattern="yyyy-MM-dd" var="formatada" type="date"/>
                <fmt:formatDate value="${formatada}" pattern="dd/MM/yyyy" type="date"/>

            </td>
        </tr>

    </c:forEach>

    </tbody>
</table>

</body>
</html>
