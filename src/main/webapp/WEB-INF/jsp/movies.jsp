<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Películas</title>
    </head>
    <body>
        <h1>Cartelera</h1>

        <c:if test="${not empty success}">
            <p style="color: green;">${success}</p>
        </c:if>
        <c:if test="${not empty error}">
            <p style="color: red;">${error}</p>
        </c:if>

        <a style="margin: 5px 20px" href="${pageContext.request.contextPath}/movies/register">Agregar Película</a>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Género</th>
                <th>Director</th>
                <th>Description</th>
                <th>Estreno</th>
            </tr>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.id}</td>
                    <td>${movie.title}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.director}</td>
                    <td>${movie.description}</td>
                    <td>${movie.premiere}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/movies/${movie.id}/update" onclick="return confirm('¿Editar?');">Editar</a> |
                        <a href="${pageContext.request.contextPath}/movies/${movie.id}/delete" onclick="return confirm('¿Eliminar?');">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>