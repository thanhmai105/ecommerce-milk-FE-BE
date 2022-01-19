
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Milkshopvn.com</title>

  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
  <style>
      <%@include file="/css/style_home.css" %>
      <%@include  file="/css/trangchu.css"%>
      <%@include  file="/css/trangcanhan.css"%>
       
  </style>
</head>

<body>
  <div class="page">
        <!-- =====  HEADER START  ===== -->
        <%@ include file="/View/Customer/header.jsp"%>
        
        <main class="main">
            <div class="container">
            <h1 class="text-center">Thông tin khách hàng </h1>
            <div class="container">
                <div class="row profile">
                    <div class="col-md-3">
                        <div class="profile-sidebar">
                            <div class="profile-userpic"> <img
                                    src="https://hocwebgiare.com/thiet_ke_web_chuan_demo/bootstrap_user_profile/images/profile_user.jpg"
                                    class="img-responsive" alt="Thông tin cá nhân">
                            </div>
                            <div class="profile-usertitle">
                                <div class="profile-usertitle-name">${user.id}</div>
                                <div class="profile-usertitle-job"> Lập trình website </div>
                            </div>
                           
                            <div class="profile-userbuttons">
                                <button style="outline: none;" type="button" class="btn btn-success btn-sm">Trang chủ</button>
                                <button style="outline: none;" type="button" class="btn btn-danger btn-sm">Đăng xuất</button>
                            </div>
                            <div class="profile-usermenu">
                                <ul class="nav">

<!--                                    <li class="active"> <button onclick="ttcanhan()"> <i class="glyphicon glyphicon-info-sign"></i> Thông tin cá nhân </button>
                                    </li>-->
                                    <br>
                                    <li class="active"> <button  onclick="updatett()"> <i class="glyphicon glyphicon-heart"></i> Cập nhât thông tin </button>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <!--                            show info-->

                    <div class="col-md-9">
                        <div class="profile-content2" id="info1">

                            <div class="Dang_ky">
                                <h2> Your information</h2>
                                <label>Tên người dùng: ${user.hoten}</label>
                                <br>
                                <label>userName: ${user.username}</label>
                                <br>
                                <label>Email: ${user.email}</label>
                                <br>
                                
                                <label>Số điện thoại:${user.sdt}</label>
                                
                                
<!--                                <input id="name" type="text" placeholder="Tên người dùng">
                                <input id="pass" type="password" placeholder="Mật khẩu">
                                <input id="repass" type="password" placeholder="Nhập lại mật khẩu">
                                <input id="email" type="text" placeholder="Email của bạn">
                                <input id="phone" type="text" placeholder="Số điện thoại của bạn">-->
                                <br>
                                <br>
                                <div class="click"><button onclick="check()">Cập Nhập</div>
                                <br>
                                <br>
                                <div class="container" style="background-color:#f1f1f1"></div>
                                <!-- <a href="" class="button">Quay lại</a> -->
                            </div>
                        </div>
                    </div>
                  
                    <!--                            update info-->
                    <div class="col-md-9">
                        <div class="profile-content" id="info2">
                            <div class="Dang_ky">
                                <h2>Thay đổi thông tin</h2>
                                <input id="name" type="text" placeholder="Tên người dùng" value="${user.hoten}">
                                <input id="pass" type="password" placeholder="Mật khẩu" value="${user.password}">
                                <input id="repass" type="password" placeholder="Nhập lại mật khẩu" value="${user.password}">
                                <input id="email" type="text" placeholder="Email của bạn" value="${user.email}">
                                <input id="phone" type="text" placeholder="Số điện thoại của bạn" value="${user.sdt}">
                                <br>
                                <br>
                                <div class="click"><button onclick="check()">Lưu</div>
                                <br>
                                <br>
                                <div class="container" style="background-color:#f1f1f1"></div>
                                <!-- <a href="" class="button">Quay lại</a> -->
                            </div>
                        </div>
                    </div>
        </main>
        <!--  footer -->
        <%@ include file="/View/Customer/footer.jsp"%>
    </div>
  
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
//        function ttcanhan() {
//                            document.getElementById("info1").style.display = "block";
//                            document.getElementById("info2").style.display = "none";
//                        }
//                        function updatett() {
//                            document.getElementById("info1").style.display = "none";
//                            document.getElementById("info2").style.display = "block";
//                        }
    </script>
</body>

</html>
