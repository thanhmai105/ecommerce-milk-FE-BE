
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

    .timkiemsp ul li{
        list-style: none ;
        text-align: center;
        margin-left: 50px ;
        margin-right: 50px;
        display: inline-block;
    }
    .timkiemsp{
        align-content: center;
        margin-left: 10%;
        margin-top: 50px;
        margin-bottom: 20px;
    }
    .timkiemsp option{
        font-size: 18px;
        font-family: 'Times New Roman', Times, serif;
        color: blue;
    }
    .timkiemsp select{
        font-size: 18px;
        font-family: 'Times New Roman', Times, serif;
        color: blue;
        width: 200px;
        height: 32px;
    }
    .timkiemsp span{
        color: blue;
        font-weight: 500;
    }
    .texttk{
        color: blue;
        font-weight: 700;
        font-size: 20px;
        margin-left: 5%;
        margin-bottom: 30px;
        background-color: cornsilk;
    }

  </style>
</head>

<body>
  <div class="page">
        <!-- =====  HEADER START  ===== -->
        <%@ include file="/View/Customer/header.jsp"%>
      
        <main class="main">
           <div class="timkiemsp">
               <form method="post" action="<%=request.getContextPath()%>/timkiemdm?iduser=${user.id}" style="border:none;">
                <ul>
                    <li>
                        <span>Hãng sản phẩm: </span>
                        <select id="hang" name="hang">
                            <option value="tat ca">tat ca</option>
                            <option value="Vinamilk">Vinamilk</option>
                            <option value="Abbott">Abbott</option>
                            <option value="Anlene">Anlene</option>
                            <option value="Milo">Milo</option>
                            <option value="Nestle">Nestle</option>
                            <option value="Nutifood">Nutifood</option>
                            <option value="Physiolac">Physiolac</option>
                            <option value="Vitadairy">Vitadairy</option>
                            <option value="Nutricare">Nutricare</option>
                            <option value="Goodhealth – NewZealand">Goodhealth – NewZealand</option>
                            <option value="ILDONG FOODIS Korea">ILDONG FOODIS Korea</option>
                          </select>
                    </li>
                    <li>
                        <span>Đối tượng sử dụng:</span>
                        <select id="doituong" name="doituong">
                            <option value="tat ca">tat ca</option>
                            <option value="tre duoi 1 tuoi">tre duoi 1 tuoi</option>
                            <option value="tre duoi 2 tuoi">tre duoi 2 tuoi</option>
                            <option value="tre em">tre em</option>
                            <option value="benh than">benh than</option>
                            <option value="da day">da day</option>
                            <option value="cao tuoi">cao tuoi</option>
                            <option value="tang can">tang can</option>
                          </select>
                    </li>
                    <li><input type="submit" value="Tim kiem" style="height:32px;"></li>
                </ul>  
              </form>
        </div>
    <div class="texttk">
        <span>Tìm kiếm :${tk} </span>
    </div>
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
                                        <h6 class="product-name"><a href="<%=request.getContextPath()%>/chitietsp?id=${sanpham.id}&iduser=${user.id}">${sanpham.tensp}
                                            
                                            </a></h6>
                                        <span class="price"><span class="amount">${sanpham.gia} VND</span>  
                                            <form method="post" action="<%=request.getContextPath()%>/themvaogiohang?id=${sanpham.id}&iduser=${user.id}" style="border:none;display: inline-block;">
                                                <input type="submit" value="add" style="margin-left: 10px;">
                                            </form>
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
</body>

</html>