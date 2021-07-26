<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 21-07-2021
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">editBookingPage</jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>
    <jsp:body>
        <form action="${pageContext.request.contextPath}/fc/editBookingPageAdm" method="post">
            <h1>current booking: ${requestScope.booking.bookingID}</h1>
            Date: ${requestScope.startDate} - ${requestScope.endDate}<br><br>
            Booking length: ${requestScope.length}<br><br>
            Item type: ${requestScope.itemType}, ${requestScope.itemName}; ${requestScope.itemID}<br><br>
            Current status: ${requestScope.status}

            <h2>New booking: ${requestScope.booking.bookingID}</h2>
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="newDate">Start date: </label>
                <div class="col-sm-4">
                    <input type="text" name="newDate" id="newDate" value="${param.newDate}" placeholder="yyyy-mm-dd">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="newLength">New length: </label>
                <div class="col-sm-4">
                    <input type="text" name="newLength" id="newLength" value="${param.newLength}">
                </div>
            </div>
            <div class="row mb-3">
                <label class="col-sm-1 col-form-label" for="newID">New itemID: </label>
                <div class="col-sm-4">
                    <input type="text" name="newID" id="newID" value="${param.newID}">
                </div>
            </div>
            Status: <input type="checkbox" name="status" value="status" <c:if test="${requestScope.status=='active'}">checked="checked"</c:if>><br><br>
            <input class="btn btn-primary" type="submit" value="Submit" name="login">
        </form>

    </jsp:body>
</t:genericpage>