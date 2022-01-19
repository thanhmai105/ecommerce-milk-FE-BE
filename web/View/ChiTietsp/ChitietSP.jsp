
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Milkshopvn.com</title>
   
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
    <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
  <style>
      <%@include file="/css/ProductDetail.css" %>
      <%@include  file="/css/trangchu.css"%>
  </style>
  <script type="text/javascript">
        var i = 0
        function cong() {
            if (i < 10) {
                i++;
            } else if (i = 10) {
                i = 0;
            }
            document.getElementById("so").value = i;
        }

        function tru() {
            if (i > 0) {
                --i;
            } else if (i = 0) {
                i = 10;
            }
            document.getElementById("so").value = i;
        }
        var masp = document.getElementsByClassName("ma");
        function Duavaogiohang(masp) {
            alert("Sản phẩm đã được đưa vào giỏ hàng");
        }

    </script>
</head>

<body>
  <div class="page">
        <!-- =====  HEADER START  ===== -->
        <%@ include file="/View/Customer/header.jsp"%>
              <div class="main1">
            <div class="container">
                <div class="row1">
                    <div class="left">
                        <div class="leftcon">
                            <div class="imgProduct"><img src="${sanpham.hinhanh}" alt="">
                            </div>
                            <div class="listProduct">
                                <div class="listProductcon">
                                    <ul>
                                        <li><img src="${sanpham.hinhanh}" alt="" style="width:85px;height: 85px"></li>
                                        <li><img src="${chitietsp.hinhanh1}" alt="" style="width:85px;height: 85px"></li>
                                        <li><img src="${chitietsp.hinhanh2}" alt="" style="width:85px;height: 85px"></li>
                                        <li><img src="${chitietsp.hinhanh3}" alt="" style="width:85px;height: 85px"></li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="midle">
                        <div class="midlecon">
                            <div class="name">
                                <h3>${sanpham.tensp}</h3>
                            </div>
                            <div class="ma-ttrang">
                                <span class="ma">loai: ${sanpham.loaisp}</span>
                                Tình trạng:
                                <span class="tinhtrang">Còn hàng</span>
                            </div>

                            <div class="danhgia">
                                <ul>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li>5.0</li>
                                    <li><span class="sldanhgia"><a href="">0 đánh giá của khách hàng</a></span></li>
                                    <li class="_101">Đã bán: ${sanpham.daban} </li>
                                </ul>
                            </div>
                            <div class="price">
                                <p class="gia">Giá: ${sanpham.gia} VND</p>
                            </div>
                            <div class="mota">
                                <ul>
                                    <li><i class="fa fa-check" aria-hidden="true"></i>Thương hiệu: ${sanpham.hangsp}</li>
<!--                                    <li><i class="fa fa-check" aria-hidden="true"></i>Nguyên liệu sữa non nhập khẩu từ
                                        Mỹt
                                    </li>
                                    <li><i class="fa fa-check" aria-hidden="true"></i>Miễn dịch khỏe – tiêu hóa tốt cho
                                        trẻ
                                        từ 0-12 tháng</li>-->
                                </ul>
                            </div>
                            <div class="khMai">
                                <p class="p_khmai">KHUYẾN MÃI 50%/HỘP + FREESHIP KHI GỌI: 09876543</p>
                            </div>
                            <div class="SLchia">
                                <div class="sltrai">
                                    <h4>Số lượng: </h4>
                                </div>
                                <div class="slphai">
                                    <ul>
                                        <li><button class="tru" type="button" onclick="cong()">+</button></li>
                                        <li><input type="text" id="so" value="1"></li>
                                        <li><button class="cong" type="button" onclick="tru()">-</button></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="dathang">
                                <div class="giohang"><a href="cart.html"><button class="gio" onclick="Duavaogiohang()">
                                            Thêm giỏ hàng</button></a>
                                </div>
                                <div class="muangay"><a href="thanhtoan.html"><button class="mua">Mua ngay</button></a>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="right">
                        <div class="camket">
                            <div class="camketcon">
                                <div class="chudeCK"><span>CAM KẾT KHÁCH HÀNG</span></div>
                                <div class="list">
                                    <ul>
                                        <li><i class="fa fa-shield" aria-hidden="true"></i>Cam kết 100% hàng chính hãng
                                        </li>
                                        <li><i class="fa fa-lightbulb-o" aria-hidden="true"></i>Ship Toàn Quốc, Miễn Phí
                                            Hà
                                            Nội</li>
                                        <li><i class="fa fa-clock-o" aria-hidden="true"></i>Đổi trả Miễn Phí trong 7
                                            ngày
                                        </li>
                                        <li><i class="fa fa-bookmark" aria-hidden="true"></i>Dịch vụ khách hàng tốt nhất
                                        </li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="hotro">
                            <div class="hotrocon">
                                <div class="chudeHT"><span>HỖ TRỢ KHÁCH HÀNG</span></div>
                                <div class="listSDT">
                                    <ul>
                                        <li><i class="fa fa-phone" aria-hidden="true"></i><a
                                                href="">09876542345</a>(Hotline/Zalo)</li>
                                        <li><i class="fa fa-phone" aria-hidden="true"></i><a
                                                href="">09876542345</a>(Hotline/Zalo)</li>
                                        <li><i class="fa fa-phone" aria-hidden="true"></i><a
                                                href="">09876542345</a>(Hotline/Zalo)</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row2">
                    <div class="rowcon1">
                        <div class="rowcon2">
                            <div class="thongtin">
                                <a href="">
                                    <i class="fa fa-align-left" aria-hidden="true"></i>
                                    Thông tin sản phẩm
                                </a>

                            </div>
                            <div class="video">
                                <a href="">
                                    <i class="fa fa-youtube-play" aria-hidden="true"></i>
                                    Video sản phẩm
                                </a>

                            </div>
                            <div class="dgia">
                                <a href="">
                                    <i class="fa fa-heart-o" aria-hidden="true"></i>
                                    Đánh giá sản phẩm
                                </a>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="chitietSP">

                    <p class="modau">
                        Giới thiệu sản phẩm ${sanpham.tensp}
                    </p>

                   ${sanpham.gioithieusp}
                    <img src="${chitietsp.hinhanh1}" alt="">
                    <br>
                    <p class="mucdam">
                        Công dụng của sữa Colosbaby BIO số 0
                    </p>
                    ${chitietsp.congdung}
                    <img src="${chitietsp.hinhanh2}" alt="">
                <br>

                <p class=" mucdam">Hướng dẫn sử dụng sữa Colosbaby BIO số 0</p>
                   ${chitietsp.hdsd}
                    <img src="${chitietsp.hinhanh3}" alt="">
                    <br>
                    ${chitietsp.hdsd2}
                </div>
                <div class="videoSP">
                    <div class="videoten">
                        <!-- <p class="tenvideo">VIDEO</p>

                    <iframe width="800" height="500" src="https://www.youtube.com/embed/gVrz0ewJKNs" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe> -->

                        <p>Gọi mua hàng:<span class="goi"> 0961.922.556</span> - (Tư vấn 24/7)</p>
                        <div class="themgio">
                            <a href="">
                                <button class="thgio">
                                    Thêm giỏ hàng</button>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="NDdanhgia">
                    <div class="SLdanhgia">
                        <h2>
                            KHÁCH HÀNG ĐÁNH GIÁ SẢN PHẨM
                        </h2>
                    </div>
                </div>
            </div>
        </div>
       
        <!--  footer -->
        <%@ include file="/View/Customer/footer.jsp"%>
    </div>
    <!-- =====  page END  ===== -->
</body>

</html>