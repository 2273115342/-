<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>系统登陆</title>
<link href="resource/css/skin.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="resource/css/demo.css" type="text/css" />
<link rel="stylesheet" href="resource/css/updateCss/login.css" type="text/css" />
<script type="text/javascript" src="resource/js/updateJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/updateJs/myUtil.js"></script>
</head>
<body>
	<div class="login_from">
		<img class="bgimg" src="./resource/images/cs/loginbg.jpg" width="1000" height="700" />
		<div class="loginMain">
			<form id="loginForm" name="loginForm" action="loginCheck" method="post">
				<div style="text-align: center;height:30px;" class="loginError">
					<span style="color:#F00;  font-size: 14px;"> ${message == null ? "" : message }</span>
				</div>
				<div class="loginArea">
					<input name="user.loginName" id="loginName" placeholder="账号" class="editbox4" type="text" value='${user.loginName == null ? "" : user.loginName }' />
				</div>
				<div class="loginArea">
					<input  name="user.password" id="password" placeholder="密码" class="editbox4" type="password" value='${user.password  == null ? "" : user.password  }' />
				</div>
				<div class="loginArea">
					<input name="code" id="code" class="code" placeholder="验证码"  type="text" maxLength=4 size=7 />
					<img id="codeImg" src = "pages/util/rand.jsp" class="codeImg" title="点击刷新"/>
				</div>
				<a href="javascript:void(0);">
					<input name="Submit" type="submit" class="button" id="Submit" value=" 登 录 "/>
				</a>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript" src="resource/js/updateJs/login.js"></script>
</html>
