<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 15-07-2021
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
  <jsp:attribute name="header">
    All bookings
  </jsp:attribute>

  <jsp:attribute name="footer">
    <c:set var="addHomeLink" value="${false}" scope="request"/>
  </jsp:attribute>


</t:genericpage>
