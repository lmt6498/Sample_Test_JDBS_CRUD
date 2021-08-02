<%--
  Created by IntelliJ IDEA.
  User: Akitoshi
  Date: 02-Aug-21
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select name="depa">
  <c:forEach items="${listDepartment}" var="dp">
    <option value="${dp.id_dp}">
        ${dp.name}
    </option>
  </c:forEach>
</select>
</body>
</html>
