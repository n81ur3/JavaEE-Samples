<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="WEB-INF/mytags.tld"%>
<html>
<head>
    <title>Title</title>
    <h2>The Time is: <%=new Date()%> </h2>
</head>
<body>
    <%@include file="subsection.html" %>
    It's been
    <jsp:useBean id="myBean" class="com.example.MyWebApp.ClockBean"/>
    <jsp:getProperty name="myBean" property="currentTimeSinceEpoch"/>
    milliseconds since midnight, January 1st 1970.
    <br/><br/>
    In other words, it’s
    <jsp:setProperty name="myBean" property="dateFormat" value="MMMMMMMM-YYYYYY"/>
    <jsp:getProperty name="myBean" property="readableDate"/>
    .
    <br/><br/>
    <jsp:useBean id="myWallet" class="com.example.MyWebApp.MyWallet"/>
    <c:forEach var="note" items="${myWallet.notes}">
        ${note}&nbsp;
    </c:forEach>
    <br/><br/>
    <hr/>
    <jsp:setProperty name="myBean" property="dateFormat" value="a"/>
    <c:if test="${myBean.readableDate=='AM'}">
        Drink a tea
    </c:if>
    <c:if test="${myBean.readableDate=='PM'}">
        Drink a coffee
    </c:if>

    <div align="center">
        <br/>
        Hello there!
        <br/><br/>
        It's been <custom:time-since-epoch/> milliseconds
        since midnight, January 1, 1970
        <br/><br/>
        In other words, it's
        <custom:date dateFormat="h:mm a, zzzz"/>.
    </div>

    <hr/>

    <jsp:useBean id="weekBean" class="com.example.MyWebApp.MyWeek"/>
    <jsp:setProperty name="weekBean" property="name" value="Danny"/>
    <div align="center">
        <h2>${weekBean.description}</h2>
        There are <jsp:getProperty name="weekBean" property="numberDays"/>
        days in a week<p>
        <jsp:getProperty name="weekBean" property="name" /> works on
        <c:forEach var="day" items="${weekBean.workingDays}">
            ${day}
        </c:forEach>
        leaving ${weekBean.numberDays - weekBean.numberWorkingDays} days
        to enjoy other things in life.<p>
        <c:set var="numberDaysOff" scope="session" value="${weekBean.numberDays - weekBean.numberWorkingDays}"/>
        That means ${weekBean.name} is working ${100 * weekBean.numberWorkingDays / weekBean.numberDays}% of the time.
        <p>
        <c:if test="${weekBean.numberWorkingDays > (weekBean.numberDays - weekBean.numberWorkingDays)}">
            This is far from ideal :(
            <p>
        </c:if>
        <c:if test="${weekBean.weekendOff && !((weekBean.numberDays - weekBean.numberWorkingDays) == 0)}">
            But a least ${weekBean.name} gets some time off at the weekend.
        </c:if>
    </p>
    </div>
</body>
</html>