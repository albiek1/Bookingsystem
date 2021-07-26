<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of our wonderful site.
        Role: ${sessionScope.role}
        <form action="${pageContext.request.contextPath}/fc/showAllItemsStu" method="post">
            <input type="submit" class="btn btn-primary" name="new booking" value="new booking"/>
        </form>
        <form action="${pageContext.request.contextPath}/fc/viewStudentProfile" method="post">
            <input type="submit" class="btn btn-primary" name="profile" value="profile"/>
        </form>

        <p>View your bookings</p>
    </jsp:body>

</t:genericpage>

