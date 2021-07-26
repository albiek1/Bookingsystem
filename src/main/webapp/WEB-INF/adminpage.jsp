<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a admin of our wonderful site.
        <div>
            <p>
            <form name="login" action="${pageContext.request.contextPath}/fc/showAllStudentsPage"  method="POST">
                <button class="btn btn-primary" type="submit" value="showAllStudents">View Students</button>
            </form>
            </p>
        </div>
        <div>
            <p>
                <form name="items" action="${pageContext.request.contextPath}/fc/showAllItemsPage" method="post">
            <button class="btn btn-primary" type="submit" value="showAllItems">View items</button>
        </form>
            </p>
        </div>
        <div>
            <p>
                <form name="newStudent" action="${pageContext.request.contextPath}/fc/addNewStudentPage" method="post">
            <button class="btn btn-primary" type="submit" value="addNewStudent">Add new student</button>
        </form>
            </p>
        </div>
        <div>
            <p>
                <form name="bookings" action="${pageContext.request.contextPath}/fc/showCurrentBookings" method="post">
            <button class="btn btn-primary" type="submit" value="showBookings">Show current bookings</button>
        </form>
            </p>
        </div>
    </jsp:body>
</t:genericpage>
