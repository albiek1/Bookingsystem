<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 20-07-2021
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
        Add new student
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <form action="${pageContext.request.contextPath}/fc/addNewStudentPage" method="post">
            Student name: <input id="name" class="form-control" type="text" name="name" value="${param.name}" placeholder="enter student name"><br><br>
            Student email: <input id="email" class="form-control" type="text" name="email" value="${param.email}" placeholder="enter student email"><br><br>
            Student phone: <input id="phone" class="form-control" type="text" name="phone" value="${param.phone}" placeholder="enter student phone number"><br><br>
            Student password: <input id="password" class="form-control" type="text" name="password" value="${param.password}" placeholder="enter student password"><br><br>
            <input class="btn btn-primary" type="submit" value="Submit" name="login">
        </form>

        <c:if test="${requestScope.error != null}">
            <p>
                ${requestScope.error}
            </p>
        </c:if>

    </jsp:body>

</t:genericpage>
