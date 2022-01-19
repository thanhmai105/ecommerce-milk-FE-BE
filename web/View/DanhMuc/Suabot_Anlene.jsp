
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
  </style>
</head>

<body>
  <div class="page">
        <!-- =====  HEADER START  ===== -->
        <%@ include file="/View/Customer/header.jsp"%>
        
        <main class="main">
            <div class="container">
                <div class="product-tab">
                        <c:forEach var="sanpham" items="${dssp}">
                          
                            <div class="product-contant">
                                <div class="peoduc-grid">
                                    <div class="product-imageblock">
                                        <a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}&iduser=${user.id}">
                                            <img src="${sanpham.hinhanh}">
                                        </a>
                                    </div>
                                    <div class="caption">
                                        <div class="rating">
                                            <span class="fa fa-stack">
                                                <i class="fa fa-star-o fa-stack-1x"></i><i class="fa fa-star fa-stack-1x"></i>
                                            </span>
                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i
                                                class="fa fa-star fa-stack-1x"></i></span>
                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i
                                                class="fa fa-star fa-stack-1x"></i></span>
                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i
                                                class="fa fa-star fa-stack-1x"></i></span>
                                            <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i><i
                                                class="fa fa-star fa-stack-x"></i> </span>
                                        </div>
                                        <h6 class="product-name"><a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}&iduser=${user.id}">${sanpham.tensp}</a></h6>
                                        <span class="price"><span class="amount">${sanpham.gia} VND</span>    
                                        </span>
                                        <h6 class="daban">Đã bán: ${sanpham.daban}</h6>
                                    </div>
                                </div>
                            </div>
                              
                        </c:forEach>
                </div>
           </div>      
        </main>
        <!--  footer -->
        <%@ include file="/View/Customer/footer.jsp"%>
    </div>
    <!-- =====  page END  ===== -->
    </div>
    <a id="scrollup"><i class="arrow up"></i></a>
    </div>
    <script src="js/homejs.js"></script>
</body>

</html>