<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 17-07-2021
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
        showAllItemsPage
    </jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
        <h1>Current status of all items</h1>
        <c:forEach var="Item" items="${requestScope.items}">
            <form>
                <fieldset>
                    <legend>Item: ${Item.id}</legend>
                    ${Item.itemType}: ${Item.name}<br>
                    Item name: ${Item.itemID} <br>
                    Room: ${Item.roomID} ${Item.roomName}<br>
                    Status: ${Item.status}
                </fieldset>
            </form>
        </c:forEach>
    </jsp:body>
</t:genericpage>
