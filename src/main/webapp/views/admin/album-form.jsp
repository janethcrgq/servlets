<%-- 
    Document   : album-form.jsp
    Created on : 23 mar 2026, 02:54:05
    Author     : janethcristinagalvanquinonez
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Mis Albums</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>

    <body>
        <%@include file="/WEB-INF/jsp/fragments/header.jspf" %>
        <header class="about-header">
            <img src="${pageContext.request.contextPath}/assets/img/header2.jpg" />
            <h1>Acerca de nosotros</h1>
        </header>

        <main class="about-main">
            <c:if test="${album == null}"> 
                Nuevo album
            </c:if>   
            <c:if test="${album != null}"> 
                Editar album
            </c:if>   

            <c:if test="${error != null}">
                <p style="color: red"> ${error} </p>
            </c:if>

            <form action="album" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${album.id}">

                <label>Titulo</label>
                <br>
                <input type="text" name="titulo" value="${album.titulo}" required>
                <br><br>

                <label>Descripcion</label>
                <br>
                <textarea name="descripcion" required>${album.descripcion}</textarea>
                <br><br>

                <label>Portada</label>
                <br>
                <input type="file" name="imagen" accept="image/png" required>
                <br><br>

                <button type="submit">Guardar</button>
            </form>

            <a href="album">Volver</a>



        </main>
        <%@include file="/WEB-INF/jsp/fragments/footer.jspf" %>
    </body>

</html>