<%--
  Created by IntelliJ IDEA.
  User: Johann Escobar
  Date: 13/08/2021
  Time: 09:18 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
<head>
    <title>Listado de Pokemones</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">

</head>
<body>
<a href="${context}/views/user/register.jsp" class="btn btn-outline-success"><i class="fas fa-plus"></i> Agregar usuario</a>
<table class="table">
    <thead class="table-dark">
    <tr>
        <th>Nombre</th>
        <th>Apellidos</th>
        <th>Pokémon Favorito</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${  listPokemon}" var="pokemon" varStatus="status">
        <tr>
            <td>${ pokemon.nombre }</td>
            <td>${ pokemon.primer_apellido } ${ pokemon.segundo_apellido }</td>
            <td>${ pokemon.pokemon_favorito }</td>

            <td>
                <c:if test="${ pokemon == 1 }">
                    <form action="${context}/findAll" method="POST" style="display: inline;">
                        <input type="hidden" name="action" value="getUserById">
                        <input type="hidden" name="id" value="${ pokemon.nombre }">
                        <button type="submit" class="btn btn-outline-primary"><i class="fas fa-edit"></i> Modificar</button>
                    </form>
                    <button id="btn-delete-${ status.count }" data-text="${ pokemon.nombre } ${ pokemon.primer_apellido} ${pokemon.segundo_apellido } ${pokemon.pokemon_favorito}" type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#delete"><i class="fas fa-trash"></i> Eliminar</button>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<%-- MODAL --%>
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="${context}/call sp_delete" method="POST">
                <input type="hidden" name="action" value="delete">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Eliminar Pokemon</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                    <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i> Eliminar</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="details" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">Detalles de Pokemon</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h5>Nombre(s):</h5>
                <label id="lbl_nombre"></label>
                <br>
                <h5>Primer Apellido:</h5>
                <label id="primer_apellido"></label>
                <br>
                <h5>Segundo Apellido:</h5>
                <label id="segundo_apellido"></label>
                <br>
                <h5>Pokemon Favorito:</h5>
                <label id="lbl_pokemon_favorito"></label>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
            </div>
        </div>
    </div>
</div>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/main.js"></script>


</body>
</html>
