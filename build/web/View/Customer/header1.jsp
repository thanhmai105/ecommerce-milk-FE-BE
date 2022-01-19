<%-- 
    Document   : header
    Created on : Dec 29, 2020, 5:29:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="header">
      <div class="headercon">
        <div class="header1">
          <div class="tbao_hotro">
            <ul class="tbao">
              <li><a href=""><i class="far fa-bell"></i> Thông báo</a></li>
              <li><a href=""><i class="far fa-question-circle"></i> Hỗ trợ</a></li>
              <li><a href="<%=request.getContextPath()%>/trangdangnhap"><i class="fas fa-user-circle"></i> Tài khoản</a></li>
            </ul>
          </div>
        </div>
        <div class="header2">
          <div class="search">
            <div class="searchcon">
              <a href="<%=request.getContextPath()%>/trangchu">
                <div class="logo">
                  <img src="Image/logo6.PNG" alt="">
                </div>
                <div class="tenshop"><span class="tshop">MilkShop</span></div>
              </a>

              <div class="formsearch">
                <div class="formsearchcon">
                  <form action="" class="timkiem">
                    <input type="text" class="tkiem">
                    <button type="submit" class="btn-search"> <i class="fa fa-search" aria-hidden="true"></i></button>
                  </form>
                </div>
              </div>
              <div class="cartmenu">
                <a href="">
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
        <div class="header3">
          <div class="header3con">
            <div class="danhmuc">
              <ul class="danhmucchinh">
                <li><a href="<%=request.getContextPath()%>/trangchu"><span>TRANG CHỦ</span></a></li>
                <li class="mega-dropdown">
                  <a href="" class="dropdown-toggle">
                    <span>DANH MỤC</span></a>
                  <div class="dropdown-menu rown">
                    <div class="col-md-4">
                      <div class="while">
                        <span class="dropdown-header">Sữa bột</span>
                        <a href="">Sữa Vinamilk</a>
                        <a href="">Sữa Nutifood </a>
                        <a href="">Sữa Abbott</a>
                        <a href="">Sữa Anlene</a>
                        <a href="">Sữa Physiolac</a>
                        <a href="">Sữa Milo Úc</a>
                        <a href="">Sữa Nestle</a>
                      </div>
                    </div>
                    <div class="col-md-4">
                      <div class="while">
                        <span class="dropdown-header">Sữa đặc trị</span>
                        <a href="">Sữa tăng cân cho người gầy</a>
                        <a href="">Sữa cho người cao tuổi</a>
                        <a href="">Sữa cho người tiểu đường</a>
                        <a href="">Sữa cho người bệnh thận</a>
                        <a href="">Sữa cho bệnh nhân ung thư</a>
                        <a href="">Sữa cho người xương khớp</a>
                        <a href="">Sữa cho người bệnh dạ dày</a>
                      </div>
                    </div>
                    <div class="col-md-4">
                      <div class="while">
                        <span class="dropdown-header">Sữa non</span>
                        <a href="">Sữa non ILDONG</a>
                        <a href="">Sữa Colosbaby</a>
                        <a href="">Sữa non Goodhealth</a>
                        <a href="">Sữa non ColossCare</a>
                        <a href="#">Sữa non ColossCare</a>
                        <a href="#">Sữa non ColossCare</a>
                        <a href="#">Sữa non ColossCare</a>
                      </div>
                    </div>
                  </div>

                </li>
                <li><a href=""><span>KHUYẾN MÃI</span></a></li>
                <li><a href="gioithieu.html"><span>GIỚI THIỆU</span></a></li>
                <li><a href="contact.html"><span>LIÊN HỆ</span></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
