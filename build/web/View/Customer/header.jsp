<%-- 
    Document   : header
    Created on : Dec 29, 2020, 5:29:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- =====  HEADER START  ===== -->
    <div class="header">
      <div class="headercon">
        <div class="header1">
          <div class="tbao_hotro">
            <ul class="tbao">
              <li><a href=""><i class="far fa-bell"></i> Thông báo</a></li>
              <li><a href=""><i class="far fa-question-circle"></i> Hỗ trợ</a></li>
              <li><a href="<%=request.getContextPath()%>/trangcanhan"><i class="fas fa-user-circle"></i>${user.username}
                      <input type="hidden" name="iduser" value="${user.id}" /></a>
                  
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
        <div class="header3">
          <div class="header3con">
            <div class="danhmuc">
              <ul class="danhmucchinh">
                <li><a href="<%=request.getContextPath()%>/trangchu?id=${user.id}"><span>TRANG CHỦ</span></a></li>
                <li class="mega-dropdown">
                  <a href="" class="dropdown-toggle">
                    <span>DANH MỤC</span></a>
                  <div class="dropdown-menu rown">
                    <div class="col-md-4">
                      <div class="while">
                        <span class="dropdown-header">Sữa bột</span>
                        <a href="<%=request.getContextPath()%>/DM_Vinamilk?id=${user.id}">Sữa Vinamilk</a>
                        <a href="<%=request.getContextPath()%>/DM_Nutifood?id=${user.id}">Sữa Nutifood </a>
                        <a href="<%=request.getContextPath()%>/DM_Abbott?id=${user.id}">Sữa Abbott</a>
                        <a href="<%=request.getContextPath()%>/DM_Anlene?id=${user.id}">Sữa Anlene</a>
                        <a href="<%=request.getContextPath()%>/DM_Physiolac?id=${user.id}">Sữa Physiolac</a>
                        <a href="<%=request.getContextPath()%>/DM_Milo?id=${user.id}">Sữa Milo Úc</a>
                        <a href="<%=request.getContextPath()%>/DM_Nestle?id=${user.id}">Sữa Nestle</a>
                      </div>
                    </div>
                    <div class="col-md-4">
                      <div class="while">
                        <span class="dropdown-header">Sữa đặc trị</span>
                        <a href="<%=request.getContextPath()%>/DM_NguoiGay?id=${user.id}">Sữa tăng cân cho người gầy</a>
                        <a href="<%=request.getContextPath()%>/DM_CaoTuoi?id=${user.id}">Sữa cho người cao tuổi</a>
                        <a href="<%=request.getContextPath()%>/DM_TieuDuong?id=${user.id}">Sữa cho người tiểu đường</a>
                        <a href="<%=request.getContextPath()%>/DM_BenhThan?id=${user.id}">Sữa cho người bệnh thận</a>
                        <a href="<%=request.getContextPath()%>/DM_UngThu?id=${user.id}">Sữa cho bệnh nhân ung thư</a>
                        <a href="<%=request.getContextPath()%>/DM_XuongKhop?id=${user.id}">Sữa cho người xương khớp</a>
                        <a href="<%=request.getContextPath()%>/DM_DaDay?id=${user.id}">Sữa cho người bệnh dạ dày</a>
                      </div>
                    </div>
                    <div class="col-md-4">
                      <div class="while">
                        <span class="dropdown-header">Sữa non</span>
                        <a href="<%=request.getContextPath()%>/DM_Ildong?id=${user.id}">Sữa non ILDONG</a>
                        <a href="<%=request.getContextPath()%>/DM_ColosBaby?id=${user.id}">Sữa Colosbaby</a>
                        <a href="<%=request.getContextPath()%>/DM_Goodheald?id=${user.id}">Sữa non Goodhealth</a>
                        <a href="<%=request.getContextPath()%>/DM_Coloscare?id=${user.id}">Sữa non ColossCare</a>
                        <a href="#">Sữa non ColossCare</a>
                        <a href="#">Sữa non ColossCare</a>
                        <a href="#">Sữa non ColossCare</a>
                      </div>
                    </div>
                  </div>

                </li>
                <li><a href=""><span>KHUYẾN MÃI</span></a></li>
                <li><a href="<%=request.getContextPath()%>/gioithieu"><span>GIỚI THIỆU</span></a></li>
                <li><a href="<%=request.getContextPath()%>/contact"><span>LIÊN HỆ</span></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- =====  end header  ===== -->
