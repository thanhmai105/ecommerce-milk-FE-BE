
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Milkshopvn.com</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
        <style>
            <%@include file="/css/cart.css" %>
            <%@include  file="/css/trangchu.css"%>

        </style>
    </head>

    <body>
        <div class="page">
            <!-- =====  HEADER START  ===== -->
            <div class="headercon">
                <div class="header1">
                    <div class="tbao_hotro">
                        <ul class="tbao">
                            <li><a href=""><i class="far fa-bell"></i> Thông báo</a></li>
                            <li><a href=""><i class="far fa-question-circle"></i> Hỗ trợ</a></li>
                            <li><a href="<%=request.getContextPath()%>/trangcanhan"><i class="fas fa-user-circle"></i>${user.username}
                                </a>

                            </li>
                        </ul>
                    </div>
                </div>
                <div class="header2">
                    <div class="search">
                        <div class="searchcon">
                            <a href="<%=request.getContextPath()%>/trangchu?id=${user.id}">
                                <div class="logo">
                                    <img src="Image/logo6.PNG" alt="">
                                </div>
                                <div class="tenshop"><span class="tshop">MilkShop</span></div>
                            </a>

                            <div class="formsearch">
                                <div class="formsearchcon">
                                    <form action="<%=request.getContextPath()%>/Timkiem?iduser=${user.id}" class="timkiem">
                                        <input type="text" class="tkiem" name="timkiem">
                                        <button type="submit" class="btn-search"> <i class="fa fa-search" aria-hidden="true"></i></button>
                                    </form>
                                </div>
                            </div>
                            <div class="cartmenu">
                                <a href="<%=request.getContextPath()%>/loadgiohang?iduser=${user.id}">
                                    <div class="cartmenucon">
                                        <div class="anhgiohang"><i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                        </div>
                                        <div class="chugiohang"><span>Giỏ hàng</span></div>
                                    </div>
                                </a>
                            </div>
                        </div>

                    </div>

                </div>
                                
                <div class="ddan" style="display: grid; margin-bottom: 70px;background-color: dodgerblue;padding-bottom: 10px;padding-top: 10px;">
                    <div class="ddancon" style="width: 1000px; margin: auto; ">
                        <a style="color: white; font-weight: bold;" href="<%=request.getContextPath()%>/trangchu?id=${user.id}">TRANG CHỦ</a> > 
                        <span >GIỎ HÀNG</span>
                    </div>

                </div>
            </div>
            <div class="container1">
                
                <div class="main">
                    <table border="1" cellpadding="5" style="border-collapse:collapse; width: 1000px;">
                        <tr>
                            <th><a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}&iduser=${user.id}">Hình ảnh</a></th>
                            <th><a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}&iduser=${user.id}">Tên Sản Phẩm</a></th>
                            <th>Loại sản phẩm</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Số tiền</th>
                            <th style="text-align: center;">Action</th>

                        </tr>

                        <c:forEach var="item" items="${listgiohang}"  >
                            <tr>
                                <td name="hinhanh"><img src="${item.hinhanh}" style="width:50px;height: 50px;margin-left: 10px;"/></td>
                                <td name="tensp"><c:out value="${item.tensp}" /></td>
                                <td name="loaisp" style="text-align: center;"><c:out value="${item.loaisp}" /></td>
                                <td name="giasp" style="text-align: center;"><c:out value="${item.gia}" /></td>
                                <td name="soluongsp" style="text-align: center;">
                                    <a href="<%=request.getContextPath()%>/giamsl?idsp=${item.idsp}&iduser=${item.idUser}" 
                                       style="margin-left: 10px;margin-right: 10px;">-</a>
                                       ${item.soluong}
                                    <a href="<%=request.getContextPath()%>/tangsl?idsp=${item.idsp}&iduser=${item.idUser}" 
                                       style="margin-left: 10px;">+</a>
                                </td>
                                <td name="gia2" style="text-align: center;">${item.gia1}</td>

                                <td style="text-align: center;"> 
                                    <a href="<%=request.getContextPath()%>/xoagh?idsp=${item.idsp}&iduser=${item.idUser}">Xóa</a>                     
                                </td>
                            </tr>

                        </c:forEach>
                    </table>
                </div>
                <div class="thanhtoan">
                    <div class="tinhtien">
                        <div class="tien">
                            <div class="tinh">
                                <p class="tongtien">Tổng tiền: <span><c:out value="${tonggia}"/>s</span></p>
                            </div>
                        </div>

                        <a href="<%=request.getContextPath()%>/thanhtoan?iduser=${item.idUser}"> <button type="submit" id="submit">Thanh toán</button></a> 
                    </div>
                </div>
            </div>
            <!--  footer -->
            <%@ include file="/View/Customer/footer.jsp"%>
        </div>
        <!-- =====  page END  ===== -->
    </body>

</html>