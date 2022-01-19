<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <style>
             <%@include  file="/css/trangchu.css"%>
        <%@include  file="/css/thanh_toan.css"%>
        </style>
       
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thanh toán</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>
        
        <%@ include file="/View/Customer/header.jsp"%>

        <div class="mainchinh">
            <form method="post" action="<%=request.getContextPath()%>/thanhtoan"></form>
            <div class="maincon">
                <div id="pdanh_muc">
                    <ul>
                        <li><a href=""> Giao hàng</a> Thông tin giao hàng</li>
                    </ul>
                </div>

                <div id="pmain">
                    <div id="ptrai">
                        <div id="p_ttgh">
                            <h3 id="ptieude">THÔNG TIN GIAO HÀNG</h3>
                            <div id="ptt">
                                <ul id="ptentt">
                                    <li>Họ và tên:</li><br>
                                    <li>E-mail:</li><br>
                                    <li>Số điện thoại:</li><br>
                                    <li>Địa chỉ:</li><br>
                                </ul>
                                <ul id="pdientt">
                                    <input type="text" name="name" ><br>
                                    <input type="text" name="sdt" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}" id="pdientt1"><br>
                                    <input type="text" name="dcnh" id="pdientt1"><br>
                                </ul>
                            </div>



                            </form> 
                        </div>
                        <div id="p_ttgh">
                            <h3 id="ptieude">Phương thức vận chuyển</h3>
                            <div id="ptt">
                                <ul id="ptentt">
                                    <li>Chọn phương thức vận chuyển</li>
                                </ul>
                                <ul id="pdientt" name="ptvc">

                                    <input name="pvc" type="radio" value="nhanh" id="pptvc" onclick='document.getElementById("ptongt1").innerHTML = "50.000"' />Chuyển phát nhanh nhanh<br>
                                    <input name="pvc" type="radio" value="buudien" id="pptvc" onclick='document.getElementById("ptongt1").innerHTML = "30.000"' />Giao hàng qua đường bưu điện


                                </ul>		


                            </div>
                        </div>

                        <div id="p_ttgh">
                            <h3 id="ptieude">Phương thức thanh toán</h3>
                            <div name="httt">
                                <input name="cod" type="radio" value="cod" id="pkthanh_toan" />Thanh toán khi giao hàng
                                (COD)<br><br>
                                <input name="cod" type="radio" value="nganhang" id="pkthanh_toan" />Chuyển khoản qua ngân hàng

                            </div>

                        </div>
                    </div>

                    <div id="pphai">

                        <div id="psanpham">
                            <div id="panh">
                                <div id="panhcon">
                                    <img src="Image/sua-colosbaby(nho-1).jpg" alt="">
                                </div>
                            </div>
                            <div id="pten">
                                <span>Sữa Grow Plus FDI Mới 900G (trẻ từ 1 tuổi)</span>
                            </div>

                            <div id="pgia">
                                <span>320.000</span>
                            </div>
                        </div>
                        <div id="ptien">
                            <ul id="ptent">
                                <li>Tạm tính:</li><br>
                                <li>Phí vận chuyển:</li><br>
                            </ul>
                            <ul id="ptongt">
                                <div id="ptamtinh" value ="'+ptamtinh+'">320.000</div>
                                <div id="ptongt1" value ="'+ptongt1+'"> 0
                                    <!-- <p id="ptongt1-1" style="display:none" style.color = "red";>50,000Ä‘</p>
                                    <p id="ptongt1-2" style="display:none">30,000Ä‘</p> -->
                                </div>
                            </ul>

                        </div>
                        <div>==================================================</div>
                        <div id="ptien">
                            <ul id="ptent">
                                <li>Tổng tiền:</li><br>

                            </ul>
                            <ul id="ptongt" >
                                <div id="ptongtien" onload="tinhTong()"></div>
                            </ul>
                        </div>
                        <!-- <button id="ptongtien-thu">tongtien-thu</button> -->
                        <script type="text/javascript">
                            // var index = 0;
                            $(".ptongt1").click(function () {
                                $(".ptongtien").append(
                                        '<div id="ptongtien" onkeyup="tinh();"></div>'

                                        );
                                //index  = index  + 1;
                            });
                            function tinhTong() {
                                var ptamtinh = document.getElementById("ptamtinh");

                                var ptongt1 = document.getElementById("ptongt1");
// var ptongtien = document.getElementById("ptongtien");
// var tong = ptongt1.value + ptamtinh.value;
//function tinhTong(ptongt1, ptamtinh) {
                                document.getElementById("ptongtien").innerHTML = ptongt1 + ptamtinh;
// }

// if (!isNaN(tong))
//      {
//           ptongtien.value = tong;
//      }
//document.write(ptamtinh.value);
                            }
// document.getElementById("ptongtien-thu").addEventListener("click", myFunction);
// if (!isNaN(tong))
//                {
//                     result.value = tong;
//                }

//               function myFunction(ptamtinh, ptongt1) {
//   return ptamtinh + ptongt1;
// }
// document.getElementById("ptongtien").innerHTML = myFunction(ptongt1, ptamtinh);

                        </script>


                        <div id="ptien">
                            <div>
                                <a href=""><input type="submit" id="submit" value="Submit" onclick="checkForm1()" ></a></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!--      footer         -->
        <%@ include file="/View/Customer/footer.jsp"%>

        <!-- =====  end footer  ===== -->
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
}
    </script>
    </body>

</html>