<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Shop Sữa</title>
        <style>
            body {
                line-height: 1.5;
                margin: 0;
                padding: 0;
                /*                height: 100%;*/
                font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
            }
            a{
                text-decoration: none;
            }

            .display-container {
                display: flex;

            }

            .size-header {
                width: 100%;
            }

            .sidebar {
                background-color: #101e4c;
                width: 18%;
                min-height: calc(100vh - 40px);
                display: flex;
                flex-direction: column;
                padding-left: 0;
                margin-bottom: 0;
                height: auto;
            }

            .title-header {
                height: 60px;
                width: 30%;
                justify-content: flex-start;
                background-color:  #09184a;
            }

            .detail-header {
                width: 70%;
                background-color: #09184a;
                justify-content: flex-end;

            }

            .content {
                width: 75%;
                margin-left: 20px;

            }

            li {
                display: list-item;
                text-align: -webkit-match-parent;
                padding: 15px;

            }

            li>a,
            .detail-header>div>a {
                text-decoration: none;
                color: #fff;
                cursor: pointer;
            }

            .detail-header>div,
            .title-header>div,
            .title-header>span {
                margin-top: 10px;
                margin-left: 10px;
                margin-right: 4px;
            }

            li>a:hover {
                opacity: 0.6;

            }

            ul {
                list-style: none;
                padding: 0;
            }

            i {
                color: #fff;
                margin-right: 10px;

            }
        </style>
    </head>
    <body>
        <div class="display-container size-header">
            <div class="display-container title-header">
                <a href="<%=request.getContextPath()%>/trangchu" style="color: #fff;text-decoration: none">
                    Về trang chủ shop
                </a>

            </div>

            <div class="display-container detail-header">

            </div>
        </div>
        <div class="display-container">
            <div class="sidebar display-container">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/TrangQLKH">
                           Quản lý khách hàng
                        </a></li>
                    <li><a href="<%=request.getContextPath()%>/TrangQLSP">
                            Quản lý sản phẩm
                        </a></li>

                </ul>
            </div>
            <div>
                <center>
                    <h1>Shop Admin</h1>
                    <h2>
                        <a href="<%=request.getContextPath()%>/newSP">Thêm sản phẩm</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/listSP">Danh sách sản phẩm</a>

                    </h2>
                        <hr>
                </center>
                <table border="1" cellpadding="5" style="border-collapse:collapse; width: 1102px;">
                    <caption><h2>Danh sách sản phẩm</h2></caption>
                    <tr>
                        <th>ID</th>
                        <th>Hình ảnh</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Loại</th>
                        <th>Hãng</th>
                        <th>Đối tượng</th>
                        <th>Giá</th>
                        <th>Giới thiệu</th>
                        <th>Số lượng</th>
                        <th>Đã bán</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="sanpham" items="${dssp}"  >
                        <tr>
                            <td><c:out value="${sanpham.id}" /></td>
                            <td><c:out value="${sanpham.hinhanh}" /></td>
                            <td><c:out value="${sanpham.tensp}" /></td>

                            <td><c:out value="${sanpham.loaisp}" /></td>
                            <td><c:out value="${sanpham.hangsp}" /></td>
                            <td><c:out value="${sanpham.doituongsp}" /></td>
                            <td><c:out value="${sanpham.gia}" /></td>
                            <td><c:out value="${sanpham.gioithieusp}" /></td>
                            <td><c:out value="${sanpham.soluong}" /></td>
                            <td><c:out value="${sanpham.daban}" /></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/edit?id=<c:out value='${sanpham.id}' />">Sửa</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="<%=request.getContextPath()%>/delete?id=<c:out value='${sanpham.id}' />">Xóa</a>                     
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div> 
        </div>
    </body>
</html>