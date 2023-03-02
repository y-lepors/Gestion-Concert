<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css.css" type="text/css">
    <title>Sportifs et pratiques</title>
</head>
<body>

<h3>Liste des groupes et de ce qu'ils font</h3>
<c:forEach items="${requestScope.groupes}" var="gp">
    <h4>${gp.nom}</h4>
    <c:choose>
        <c:when test="${empty gp.artisteSet}">
            <p>
                <i>N'a pas d'artiste</i>
            </p>
        </c:when>
        <c:otherwise>
            <p>
                <b>Liste des artiste : </b>
            </p>
            <ul>
                <c:forEach items="${gp.artisteSet}" var="artistes">
                    <li>${artistes.nom} (du sport ${artistes.prenom})</li>
                </c:forEach>
            </ul>
        </c:otherwise>
    </c:choose>
</c:forEach>

</body>
</html>