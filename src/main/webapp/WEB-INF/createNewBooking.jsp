<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 15-07-2021
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
        Create new booking
    </jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>
    <jsp:body>

        <h1>Create new booking</h1>
        <form action="${pageContext.request.contextPath}/fc/createNewBooking" method="post">
            Date: <input type="text" name="date" value="${param.date}" placeholder="yyyy-mm-dd"/><br/>
            Length: <input type="number" name="length" value="${param.length}"/><br/>
            <input type="hidden" name="itemID" value="${param.itemID}">
            <input type="submit" class="btn btn-primary" name="submit">
        </form>
    </jsp:body>
</t:genericpage>
