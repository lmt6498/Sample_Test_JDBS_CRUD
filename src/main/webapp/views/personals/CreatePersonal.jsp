<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Create</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Create</h2>
  <form action="/nhanvien?action=create" method="post">
    <table class="table">
      <tbody>
      <tr>
        <td>ID:</td>
        <td><input placeholder="nhập id" name="id"></td>
        <td>Name:</td>
        <td><input placeholder="nhập name" name="name"></td>
      <tr>
        <td>Date of Birth:</td>
        <td> <input placeholder="nhập date" name="date"></td>
        <td>Address:</td>
        <td> <input placeholder="nhập address" name="address"></td>
      </tr>
        <td>Phone:</td>
        <td> <input placeholder="nhập phone" name="phone"></td>
        <td>Email:</td>
        <td> <input placeholder="nhập email" name="email"></td>
      </tr>
      <tr>
        <td>Department</td>
        <td colspan="2">
          <select name="id_dp">
            <c:forEach items="${listDepartment}" var="dp">
              <option value="${dp.id_dp}">
                  ${dp.name}
              </option>
            </c:forEach>
          </select>
        </td>
      </tr>

      </tbody>
    </table>
    <button type="submit" class="btn btn-success">Create</button>

  </form>
</div>

</body>
</html>

