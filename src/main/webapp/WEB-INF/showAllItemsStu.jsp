<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 25-07-2021
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
  <jsp:attribute name="header">show items</jsp:attribute>
  <jsp:attribute name="footer">

  </jsp:attribute>
  <jsp:body>
    <h1>Select item</h1>

      <c:forEach var="Item" items="${requestScope.items}">
        <c:if test="${Item.status != 'booked'}">
          <form action="${pageContext.request.contextPath}/fc/createNewBooking" method="post">
            <form>
              <fieldset>
                <legend>Item: ${Item.id}</legend>
                  ${Item.itemType}: ${Item.name}<br>
                Item name: ${Item.itemID} <br>
                Room: ${Item.roomID} ${Item.roomName}<br>
                Status: ${Item.status}
                <input type="submit" class="btn btn-primary" name="itemID" value="${Item.id}" id="${Item.id}"/>
              </fieldset>
            </form>
          </form>
        </c:if>
      </c:forEach>

  </jsp:body>
</t:genericpage>