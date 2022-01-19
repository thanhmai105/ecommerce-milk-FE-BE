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
                height: 100%;
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
            th{
                text-align: left;
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
        <div class="display-container" >
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
            <div style="width:1100px;">
                <div style="margin:auto;">
                    <center>
                        <h1>Shop Admin</h1>
                        <h2>
                            <a href="<%=request.getContextPath()%>/newSP">Thêm sản phẩm</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%=request.getContextPath()%>/listSP">Danh sách sản phẩm</a>

                        </h2>
                            <hr>
                    </center>
                    <c:if test="${sanpham != null}">
                        <form action="update" method="post" >
                        </c:if>
                        <c:if test="${sanpham == null}">
                            <form action="insert" method="post" >
                            </c:if>
                            <table cellpadding="5" style="margin:auto;">
                                <caption>
                                    <h2>
                                        <c:if test="${sanpham != null}">
                                            Sửa sản phẩm
                                        </c:if>
                                        <c:if test="${sanpham == null}">
                                            Thêm sản phẩm mới
                                        </c:if>
                                    </h2>
                                </caption>
                                <c:if test="${sanpham != null}">
                                    <input type="hidden" name="id" value="<c:out value='${sanpham.id}' />" />
                                </c:if>  
                                <tr>
                                    <th style="height:125px; ">Hình Ảnh: </th>
                                    <td>
                                        <input type="text" name="price" size="45" style="height:125px;"
                                               value="<c:out value='${sanpham.hinhanh}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Tên sản phẩm: </th>
                                    <td>
                                        <input type="text" name="title" size="45"
                                               value="<c:out value='${sanpham.tensp}' />"
                                               />
                                    </td>
                                </tr>

                                <tr>
                                    <th>Loại: </th>
                                    <td>
                                        <input type="text" name="price" size="45"
                                               value="<c:out value='${sanpham.loaisp}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Hãng: </th>
                                    <td>
                                        <input type="text" name="price" size="45"
                                               value="<c:out value='${sanpham.hangsp}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Đối tượng: </th>
                                    <td>
                                        <input type="text" name="price" size="45"
                                               value="<c:out value='${sanpham.doituongsp}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Giá: </th>
                                    <td>
                                        <input type="text" name="author" size="45"
                                               value="<c:out value='${sanpham.gia}' />"
                                               />
                                    </td>
                                </tr>

                                <tr>
                                    <th>Giới thiệu: </th>
                                    <td>
                                        <input type="text" name="price" size="45"
                                               value="<c:out value='${sanpham.gioithieusp}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Số lượng: </th>
                                    <td>
                                        <input type="text" name="price" size="45"
                                               value="<c:out value='${sanpham.soluong}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Đã bán: </th>
                                    <td>
                                        <input type="text" name="price" size="45"
                                               value="<c:out value='${sanpham.daban}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="submit" value="Save" />
                                    </td>
                                </tr>
                            </table>
                            </form>
                        </form>
                </div>  
            </div>
        </div> 
    </body>
</html>