<%--
  Created by IntelliJ IDEA.
  User: Toshiba
  Date: 22.12.2022
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart</title>
</head>
<body>
  <%@ page import="model.Cart" %>
  <% Cart cart = (Cart) session.getAttribute("cart"); %>
  <p>
    Наименование: <%= cart.getProduct() %>
  </p>

  <p>
    Количество: <%= cart.getQuantity() %>
  </p>

</body>
</html>
