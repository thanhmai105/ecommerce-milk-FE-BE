
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Milkshopvn.com</title>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
  <style>
      <%@include  file="/css/trangchu.css"%>
     
    .Dangnhap{
    padding: 10px;
    height: 300px;
    text-align: center;
    }
    .Dangnhap input[type="text"], .Dangnhap input[type="password"]{
        border: 0;
        background: none;
        display: block;
        margin: 20px auto;
        text-align: center;
        border: 2px solid #3333ff;
        padding: 14px 10px;
        width: 200px;
        outline: none;
        color:black;
        border-radius: 30px;
        transition: 0.25s;
    }
    .Dangnhap h1{
        color: black;
        text-transform: uppercase;
    }
    .Dangnhap input[type="submit"]{
        border: 0;
        background: none;
        display: block;
        margin: 20px auto;
        text-align: center;
        border: 2px solid #3333ff;
        padding: 14px 10px;
        width: 200px;
        outline: none;
        color: black;
        border-radius: 30px;
        transition: 0.25s;
    }
    .Dangnhap input[type="text"]:focus, .Dangnhap input[type="password"]:focus{
        width: 200px;
        border-color: green;
    }
    .Dangnhap input[type="submit"]:hover{
        background:  green;
    }
  </style>
</head>

<body>
  <div class="page">
        <!-- =====  HEADER START  ===== -->
        <%@ include file="/View/Customer/header.jsp"%>
        
        <main class="main">
            <form class="Dangnhap" method="POST" action="<%=request.getContextPath()%>/dangnhap">
            <h1>Đăng nhập</h1>
            <input type="text" id="ten" name="username" placeholder="Tên">
            <input type="password" id="matkhau" name="password" placeholder="Mật khẩu">
            <input type="submit"  value="Submit" onclick="checkForm()"/>
            <span>Bạn chưa có tài khoản?<a href="<%=request.getContextPath()%>/trangdangky">ĐĂNG KÝ</a></span>
        </form>
        </main>
        <!--  footer -->
        <%@ include file="/View/Customer/footer.jsp"%>
    </div>
    <!-- =====  page END  ===== -->
    <script type="text/javascript">
        function checkForm(){
            var u = document.getElementById("ten").value;
            var p1 = document.getElementById("matkhau").value;
            if(u== "") {
                alert("Vui lòng nhập tên!");
                return false;
            }
            else
            if(p1 == "") {
                alert("Vui lòng nhập mật khẩu!");
                return false;
            }
        }
    </script>
</body>

</html>