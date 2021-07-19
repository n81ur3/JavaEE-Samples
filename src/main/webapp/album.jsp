<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="photo-tags" uri="WEB-INF/photo.tld"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:useBean id="photoAlbum" scope="session" class="com.example.MyWebApp.gallery.PhotoAlbum"/>
<jsp:setProperty name="photoAlbum" property="session" value="<%=session%>"/>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Photo Viewer</title>
</head>
<body>
    <h3 align='center'>Photo</h3>
    <table align='center'>
        <tr>
            <c:forEach var="i" begin="1" end="${photoAlbum.photoCount}">
                <td align="center">
                    <photo-tags:photo width="150" height="120" index="${i-1}"></photo-tags:photo>
                </td>
            </c:forEach>
            <td bgcolor="#cccccc" width="120" height="120">
                <form align="left" action="UploadServlet"
                      method="post" enctype="multipart/form-data">
                    <input value="Choose" name="myFile" type="file" accept="image/jpeg"><br>
                    <input value="Upload" type="submit"><br>
                </form>
            </td>
        </tr>
        <tr>
            <c:forEach var="item" items="${photoAlbum.photoNames}">
                <td align="center">
                    ${item}
                </td>
            </c:forEach>
        </tr>
        <tr>
            <c:forEach var="i" begin="1" end="${photoAlbum.photoCount}">
                <td align="center">
                    <a href="RemoveServlet?photo=${i-1}">remove</a>
                </td>
            </c:forEach>
        </tr>
    </table>
</body>
</html>
