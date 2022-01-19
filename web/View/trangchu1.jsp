
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
        <%@ include file="/View/Customer/header1.jsp"%>
        
        <main class="main">
          <!-- =====  banner ===== -->
            <div class="banner">
                <div class="container1">
                  <div class="main-banner">
                    <img style="display: none;" src="https://img.websosanh.vn/v10/users/review/images/fn62tvz51hvss/1565063877285_5528619.jpg?compress=85" alt="Main Banner" class="img_banner" />
                    <img style="display: block;" src="Image/main_banner2.jpg" alt="Main Banner" class="img_banner" />
                    <img style="display: none;" src="Image/main_baner3.jpg" alt="Main Banner" class="img_banner" />
                    <img style="display: none;" src="Image/main_baner4.jpg" alt="Main Banner" class="img_banner" />
                    <button class="button_arrow_l" onclick="plusDivs(-1);"><i class="arrow left"></i></button>
                    <button class="button_arrow_r" onclick="plusDivs(1);"><i class="arrow right"></i></button>
                  </div>
                </div>
              </div>
              <!-- =====  end banner ===== -->
              <!-- quang cao -->
              <div class="gioithieu">
                <div class="gioithieu1">
                    <p class="dong1">NHỮNG SẢN PHẨM</p>
                    <p class="dong2">TUYỆT VỜI</p>
                    <p class="dong3">Chúng tôi tự hào mang đến những sản phẩm chất lượng nhất, ngon nhất vì sức khỏe người dùng</p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron2"><i class="fa fa-circle" aria-hidden="true"></i></p>

                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRzt8gJ8RpbQrF9BQHC6pfY9FO7TXIDMmXgQg&usqp=CAU" alt="">
                </div>
                <div class="gioithieu1">
                    <p class="dong1">HỆ THỐNG PHÂN PHỐI</p>
                    <p class="dong2">RỘNG KHẮP</p>
                    <p class="dong3">Sản phẩm của chúng tôi có mặt trên 40 quốc gia khác nhau trên thế giới</p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <p class="icon_tron2"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <img src="http://nuocdua.giaodienwebmau.com/wp-content/uploads/2018/07/h22.jpg" alt="">
                </div>
                <div class="gioithieu1">
                    <p class="dong1">VÙNG NGUYÊN LIỆU</p>
                    <p class="dong2">CHẤT LƯỢNG</p>
                    <p class="dong3">Từ những vườn dừa uy tín xứ Việt tươi tốt, cho năng suất cao và chất lượng
                        <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                        <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                        <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                        <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                        <p class="icon_tron1"><i class="fa fa-circle" aria-hidden="true"></i></p>
                        <p class="icon_tron2"><i class="fa fa-circle" aria-hidden="true"></i></p>
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRNeKTNpce4yj8y4p_cK1lw2_tYj1et1PT5Rw&usqp=CAU" alt="">
                </div>
            </div>
        <!-- het quang cao -->
        
            <div class="container">
                <div class="product-tab">
                    <div class="product-title">
                        <h2>Bán chạy nhất</h2><hr>
                    </div>
                        
                        <c:forEach var="sanpham" items="${dssp1}" begin="0" end="3">
                          
                            <div class="product-contant">
                                <div class="peoduc-grid">
                                    <div class="product-imageblock">
                                        <a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}">
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
                                        <h6 class="product-name"><a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}">${sanpham.tensp}</a></h6>
                                        <span class="price"><span class="amount">${sanpham.gia} VND</span>    
                                        </span>
                                        <h6 class="daban">Đã bán: ${sanpham.daban}</h6>
                                    </div>
                                </div>
                            </div>
                              
                        </c:forEach>
                </div>
                 <div class="product-tab">
                    <div class="product-title">
                        <h2>Sản phẩm mới nhất</h2><hr>
                    </div>
                        <c:forEach var="sanpham" items="${dssp2}" begin="0" end="3">
                          
                            <div class="product-contant">
                                <div class="peoduc-grid">
                                    <div class="product-imageblock">
                                        <a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}">
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
                                        <h6 class="product-name"><a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}">${sanpham.tensp}</a></h6>
                                        <span class="price"><span class="amount">${sanpham.gia} VND</span>    
                                        </span>
                                        <h6 class="daban" >Đã bán: ${sanpham.daban}</h6>
                                    </div>
                                </div>
                            </div>  
                        </c:forEach> 
                </div>
                <div class="product-tab">
                    <div class="product-title">
                        <h2>Sữa bột</h2><hr>
                    </div>
                        
                        <c:forEach var="sanpham" items="${dssp3}" begin="2" end="5">
                          
                            <div class="product-contant">
                                <div class="peoduc-grid">
                                    <div class="product-imageblock">
                                        <a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}">
                                            <img src="${sanpham.hinhanh}" >
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
                                        <h6 class="product-name"><a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}">${sanpham.tensp}</a></h6>
                                        <span class="price"><span class="amount">${sanpham.gia} VND</span>    
                                        </span>
                                        <h6 class="daban">Đã bán: ${sanpham.daban}</h6>
                                    </div>
                                </div>
                            </div>
                              
                        </c:forEach>
                </div>
                <div class="product-tab">
                    <div class="product-title">
                        <h2>Sữa non</h2><hr>
                    </div>
                        <c:forEach var="sanpham" items="${dssp4}" begin="1" end="4">
                          
                            <div class="product-contant">
                                <div class="peoduc-grid">
                                    <div class="product-imageblock">
                                        <a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}">
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
                                        <h6 class="product-name"><a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}">${sanpham.tensp}</a></h6>
                                        <span class="price"><span class="amount">${sanpham.gia} VND</span>    
                                        </span>
                                        <h6 class="daban" >Đã bán: ${sanpham.daban}</h6>
                                    </div>
                                </div>
                            </div>   
                        </c:forEach>
                </div>
                <div class="product-tab">
                    <div class="product-title">
                        <h2>Sữa đặc trị</h2><hr>
                    </div>
                        
                        <c:forEach var="sanpham" items="${dssp5}" begin="1" end="4">
                          
                            <div class="product-contant">
                                <div class="peoduc-grid">
                                    <div class="product-imageblock">
                                        <a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}">
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
                                        <h6 class="product-name"><a href="<%=request.getContextPath()%>/chitietsp?id=<c:out value='${sanpham.id}'/>"> ${sanpham.tensp}</a></h6>
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
    <a id="scrollup"><i class="arrow up"></i></a>
    </div>
    <script src="js/homejs.js"></script>
</body>

</html>