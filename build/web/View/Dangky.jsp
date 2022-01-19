
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
      .Dangki{
    padding: 10px;
    height: 450px;
    text-align: center;
    }
    .Dangki input[type="text"], .Dangki input[type="password"]{
        border: 0;
        background: none;
        display: block;
        margin: 10px auto;
        text-align: center;
        border: 2px solid #3333ff;
        padding: 14px 10px;
        width: 400px;
        outline: none;
        color: black;
        border-radius: 30px;
        transition: 0.25s;
    }
    h1{
        color: black;
        text-transform: uppercase;
    }
    .Dangki input[type="submit"]{
        border: 0;
        background: none;
        display: block;
        margin: 10px auto;
        text-align: center;
        border: 2px solid black;
        padding: 14px 10px;
        width: 100px;
        outline: none;
        color: black;
        border-radius: 30px;
        transition: 0.25s;
    }
    .Dangki input[type="text"]:focus, .Dangki input[type="password"]:focus{
        width: 400px;
        border-color: green;
    }
    .Dangki input[type="submit"]:hover{
        background:  green;
    }
  </style>
</head>

<body>
  <div class="page">
        <!-- =====  HEADER START  ===== -->
        <%@ include file="/View/Customer/header.jsp"%>
        
        <main class="main">
        <form class="Dangki" action="<%=request.getContextPath()%>/dangky" method="POST">
            <h1>Đăng kí</h1>
            <input type="text" id="hoten" name="hoten" placeholder="ho ten">
            <input type="text" id="email" name="email" placeholder="Nhập Email">
            <input type="text" id="sdt" name="sdt" placeholder="Nhập Số điện thoại">
            <input type="text" id="ten" name="username" placeholder="username">
            <input type="password" id="matkhau" name="password" placeholder="Nhập Mật khẩu">
            <input type="password" id="matkhau1" name="matkhau1" placeholder="Nhập lại Mật khẩu">
            <input type="submit" id="submit" value="Submit" onclick="checkForm1()" >
            <span>Bạn đã có tài khoản?<a href="<%=request.getContextPath()%>/trangdangnhap">ĐĂNG NHẬP</a></span>
        </form>
        </main>
        <!--  footer -->
        <%@ include file="/View/Customer/footer.jsp"%>
    </div>
    <!-- =====  page END  ===== -->
   
    <script >
        function checkForm1() {
            var d = document.getElementById("hoten").value;
        var u = document.getElementById("ten").value;
        var p1 = document.getElementById("matkhau").value;
        var reg_p1 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        var p2 = document.getElementById("matkhau1").value;

        var email = document.getElementById("email").value  ;       
        var reg_email = /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;
        var phone = document.getElementById("sdt").value;
        var reg_phone = /0+[0-9]{9,}$/;

        if(u== "") {
        alert("Vui lòng nhập tên!");
        return false;
        }
        if(p1 == "") {
            alert("Vui lòng nhập mật khẩu!");
            return false;
        }
        if(p2 == "") {
            alert("Vui lòng xác minh mật khẩu!");
            return false;
        }
        else{
            if(reg_p1.test(p1)==false){
                alert("Mật khẩu tối thiểu tám ký tự, ít nhất một chữ cái viết hoa, một chữ cái viết thường, một số và một ký tự đặc biệt:")
                return false;
            }
        }
        if (p2!="" && p2!=p1){
                alert("Mật khẩu không đúng!")
                return false;
        }
        if(d== "") {
            alert("Vui lòng nhập địa chỉ!");
            return false;
        }
        if (email==""){
            alert("Email Không được để trống!")
            return false;
        }
        else{
            if(reg_email.test(email)==false){
                alert("Email Không hợp lệ")
                return false;
            }
        }
        if (phone==""){
            alert("Nhập số điện thoại!")
            return false;
        }
        else {
            if( reg_phone.test(phone)==false){
                alert("Sai định dạng số điện thoại!");
                return false;
            }
        }
}
    </script>
</body>

</html>