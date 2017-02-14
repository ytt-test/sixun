function checkPass(){
   var  password  = document.getElementById("pwd").value;
   if(password.length>0){
       var reg = /^\w{6}$/;
       var passSPan = document.getElementById("passId");
       if(reg.test(password)){
          //符合规则
          passSPan.innerHTML="正确".fontcolor("green");
          return true;
       }else{
          //不符合规则
          passSPan.innerHTML="请输入六位数密码".fontcolor("red");
          return false;
       }
   }
}
//检验密码是否正确
function ensurepass(){
   var  password1 = document.getElementById("pwd").value; //第一次输入的密码
   var password2 = document.getElementById("ensurepwd").value;
   if(password2.length>0){
       var enSpan  = document.getElementById("ensure");
       if(password1.valueOf()==password2.valueOf()){
          enSpan.innerHTML="正确".fontcolor("green");
          return true;
       }else{
          enSpan.innerHTML="错误".fontcolor("red");
          return false;
       }
   }
}
// function checkEmail(){
//       var  email  = document.getElementById("email ").value;
//       var reg = /^[a-z0-9]\w+@[a-z0-9]{2,3}(\.[a-z]{2,3}){1,2}$/i;  // .com .com.cn
//       var emailspan = document.getElementById("emailspan");
//     //  alert(reg.test(email));
//       if(reg.test(email)){
//           //符合规则
//           emailspan.innerHTML="正确".fontcolor("green");
//           return true;
//       }else{
//           //不符合规则
//           emailspan.innerHTML="格式错误".fontcolor("red");
//           return false;
//       }
//    }
   function checkHoby(){
         var  contact  = document.getElementById("contact").value;
         var reg =/^1[0-9]{10}/;
         var contactspan = document.getElementById("contactspan");
       //  alert(reg.test(email));
         if(reg.test(contact)){
             //符合规则
             contactspan.innerHTML="正确".fontcolor("green");
             return true;
         }else{
             //不符合规则
             contactspan.innerHTML="输入错误".fontcolor("red");
             return false;
         }
      }
function checkForm(){

      var pass  = checkPass();
      var ensure  = ensurepass();
      var email = checkEmail();
      var hoby = checkHoby();
      if(pass&&ensure&&email&&hoby){
          return true;
      }else{
          return false;
      }
   }
