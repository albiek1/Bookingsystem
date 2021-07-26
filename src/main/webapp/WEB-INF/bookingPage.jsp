<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: albie
  Date: 29-06-2021
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
        Booking Page
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div>
            <h2>Create a new booking</h2>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/fc/CreateNewBookingCommand">
            <select id="itemType" name="itemType">
                <option value="Oculus Quest 2">Oculus Quest 2</option>
                <option value="Oculus Rift S">Oculus Rift S</option>
                <option value="PC">Arbejdscomputer</option>
                <option value="Printer">Plakatprinter</option>
                <option value="3D printer">3D printer</option>
                <option value="Canon EOS 90D">Canon EOS 90D</option>
                <option value="Panasonic 4K">Panasonic 4K</option>
                <option value="Fotostudio">Fotostudio</option>
            </select>
            <c:if test="itemType=Oculus Quest 2">
                <select id="itemID" name="itemID">
                    <option value="0">vr-1</option>
                    <option value="1">vr-2</option>
                    <option value="2">vr-3</option>
                    <option value="3">vr-4</option>
                    <option value="4">vr-5</option>
                    <option value="5">vr-6</option>
                </select>
            </c:if>
            <c:if test="itemType=Oculus Rift S">
                <select id="itemID" name="itemID">
                    <option value="6">vr-7</option>
                    <option value="7">vr-8</option>
                </select>
            </c:if>
            <c:if test="itemType=PC">
                <select id="itemID" name="itemID">
                    <option value="8">pc-1</option>
                </select>
            </c:if>
            <c:if test="itemType=Printer">
                <select id="itemID" name="itemID">
                    <option value="9">print-1</option>
                </select>
            </c:if>
            <c:if test="itemType=3D printer">
                <select id="itemID" name="itemID">
                    <option value="10">3d-print-1</option>
                    <option value="11">3d-print-2</option>
                    <option value="12">3d-print-3</option>
                    <option value="13">3d-print-4</option>
                    <option value="14">3d-print-5</option>
                    <option value="15">3d-print-6</option>
                    <option value="16">3d-print-7</option>
                    <option value="17">3d-print-8</option>
                </select>
            </c:if>
            <c:if test="itemType=Canon EOS 90D">
                <select id="itemID" name="itemID">
                    <option value="18">camera-1</option>
                    <option value="19">camera-2</option>
                    <option value="20">camera-3</option>
                </select>
            </c:if>
            <c:if test="itemType=Panasonic 4K">
                <select>
                    <option value="21">camera-4</option>
                </select>
            </c:if>
            <c:if test="itemType=Fotostudio">
                <select>
                    <option value="22">Fotostudio</option>
                </select>
            </c:if>
            <div class="form-group">
                <label for="startDate">Start date:</label>
                <input id="startDate" name="startDate" type="text" class="form-control" placeholder="yyyy-mm-dd"/><br/>
            </div>
            <div class="form-group">
                <label for="bookingLength">End date:</label>
                <input id="bookingLength" name="bookingLength" type="text" class="form-control" placeholder="yyyy-mm-dd"><br/>
            </div>
            <button type="submit">Enter</button>
        </form>
    </jsp:body>
</t:genericpage>
