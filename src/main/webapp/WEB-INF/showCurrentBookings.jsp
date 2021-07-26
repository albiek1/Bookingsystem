<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 02-07-2021
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
        Current bookings
    </jsp:attribute>
    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div>
            <h2>View your current bookings</h2>
        </div>
        <c:forEach var="Booking" items="${requestScope.bookingList}">
            <fieldset>
                <legend>Booking: ${Booking.bookingID}</legend>
                Item booked: ${Booking.itemType}, ${Booking.itemName}<br><br>
                Booking date: ${Booking.date} - ${Booking.bookingEnd}<br><br>
                Booking length: ${Booking.length}<br><br>
                Booking status: ${Booking.status}
                <form action="${pageContext.request.contextPath}/fc/editBookingPageAdm" method="post">
                    <input type="submit" class="btn btn-primary" name="submit" value="${Booking.bookingID}" id="${Booking.bookingID}"><br><br>
                </form>
            </fieldset><br><br>
        </c:forEach>
    </jsp:body>
</t:genericpage>