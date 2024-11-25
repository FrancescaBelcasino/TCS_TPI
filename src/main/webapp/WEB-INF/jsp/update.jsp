<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Películas</title>
    </head>
    <body>
        <h1>Editar Pelicula</h1>

        <form style="margin: 5px 20px" action="${pageContext.request.contextPath}/movies/${movie.id}" method="post">
            <label for="title">Título:</label><br/>
            <input type="text" id="title" name="title" value="${movie.title}" required/><br/>
            <br/>

            <label for="genre">Género:</label><br/>
            <input type="text" id="genre" name="genre" value="${movie.genre}" required/><br/>
            <br/>

            <label for="director">Director:</label><br/>
            <input type="text" id="director" name="director" value="${movie.director}" required/><br/>
            <br/>

            <label for="description">Descripción:</label><br/>
            <input type="text" id="description" name="description" value="${movie.description}" required/><br/>
            <br/>

            <label for="premiere">Año de Estreno:</label><br/>
            <input type="number" id="premiere" name="premiere" value="${movie.premiere}" required/><br/>
            <br/>

            <button type="submit">Guardar</button>
        </form>

        <a href="${pageContext.request.contextPath}/movies">Cancelar</a>
    </body>
</html>