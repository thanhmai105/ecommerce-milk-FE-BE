function checkForm1() {
    var u = document.getElementById("ten").value;
    var p1 = document.getElementById("matkhau").value;
    var reg_p1 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    var p2 = document.getElementById("matkhau1").value;
    var d = document.getElementById("diachi").value;
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
    return true;
}
function checkForm(){
    var u = document.getElementById("ten").value;
    var p1 = document.getElementById("matkhau").value;
    if(u== "") {
    alert("Vui lòng nhập tên!");
        return false;
    }
    else
    if(p1 == "") {
        alert("Vui lòng nhập mật khẩu!");
        return false;
    }
    
}