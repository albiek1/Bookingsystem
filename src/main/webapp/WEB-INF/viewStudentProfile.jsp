<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 26-07-2021
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:genericpage>
    <jsp:attribute name="header">
        view profile
    </jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>
    <jsp:body>
        <h1>${requestScope.name}</h1>
        Email: ${requestScope.email} <br/>
        Phone: ${requestScope.phone} <br/>
        Points: ${requestScope.points}
    </jsp:body>
</t:genericpage>
