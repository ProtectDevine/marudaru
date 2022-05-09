<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/include/include-body.jspf" %>
 <section class="home">
        <div class="text">마루다루</div>

<header> <h2 style="margin:0 120px">Login</h2> </header> 
<form id="loginFrm" action="/doLogin" method="POST"> 
		
	<div class="input-box"> 
		<input id="memId" type="text" name="memId" placeholder="아이디"> 
		<label for="memId">아이디</label> </div> 
	<div class="input-box"> 
		<input id="memPass" type="password" name="memPass" placeholder="비밀번호"> 
		<label for="memPass">비밀번호</label> </div> 
	<a style="margin:120px" href="#" id="doLogin">로그인</a>
	<!-- <input style="margin:0 120px" type="submit" value="로그인"> --> 
	</form>
<a style="margin:120px" href="/joinMember">회원가입</a>
<div style="margin:0 120px"id="forgot">비밀번호 찾기</div> 



</section>

</body>
<style type="text/css">
.input-box{
  position:relative;
  margin:10px 120px;
  width:30%;
}

.input-box > input{
  background:transparent;
  border:none;
  border-bottom: solid 1px #ccc;
  padding:20px 0px 5px 0px;
  font-size:14pt;
  width:100%;
}
input::placeholder{
	color:transparent;
}


input:placeholder-shown + label{
  color:#aaa;
  font-size:14pt;
  top:15px;
}


input:placeholder-shown + label{
  color:#aaa;
  font-size:14pt;
  top:15px;
}


input:focus + label, label{
  color:#8aa1a1;
  font-size:10pt;
  pointer-events: none;
  position: absolute;
  left:0px;
  top:0px;
  transition: all 0.2s ease ;
  -webkit-transition: all 0.2s ease;
  -moz-transition: all 0.2s ease;
  -o-transition: all 0.2s ease;
}

input:focus, input:not(:placeholder-shown){
  border-bottom: solid 1px #8aa1a1;
  outline:none;
}




</style>

<script src="/js/common.js"></script>
<script type="text/javascript">
$('#doLogin').click(function(){
	$('#loginFrm').submit();
});


$(document).ready(function(){ 
	var message = "${message}";
	if(message!=null && message!=''){
		alert(message);
	}
});
</script>
</html>