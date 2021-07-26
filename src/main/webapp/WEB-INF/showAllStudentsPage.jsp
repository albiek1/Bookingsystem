<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 16-07-2021
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<t:genericpage>
    <jsp:attribute name="header">
        View all students
    </jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>
    <jsp:body>
        <h1>Students go here</h1>

        <c:forEach var="User" items="${requestScope.users}">
            <form>
                <fieldset>
                    <legend>Student: ${User.id}</legend>
                    <label>Name: ${User.name} </label><br/>
                    <label>Email: ${User.email} </label><br/>
                    <c:if test="${User.phone == 0}">
                        <label>Phone: n/a</label><br/>
                    </c:if>
                    <c:if test="${User.phone != 0}">
                        <label>Phone: ${User.phone} </label><br/>
                    </c:if>
                </fieldset>
            </form>
        </c:forEach>
    </jsp:body>
</t:genericpage>