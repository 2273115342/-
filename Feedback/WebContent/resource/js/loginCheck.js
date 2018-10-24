// JavaScript Document
/*****************************************************  
 *  函数名：loginCheck()
 *  作  用：登录表单数据验证
 *	参  数：无 
 *  返回值：True: 验证通过
 *          False: 验证没有通过
 *****************************************************
*/
 function loginCheck()
 {
	var loginCheck = false;
	var userName = document.getElementById("user.loginName");
	if (userName.value == "") {
		alert("请输入你的用户名!");
		userName.focus();
		return false;
	}
	
//	document.getElementById("code")
	
	var userPwd = document.getElementById("user.password");
	if (userPwd.value == "") {
		alert("请输入你的密码!");
		userPwd.focus();
		return false;
	}
	var code = document.getElementById("code");
	if (code.value == "" || code.value.length != 4) {
		alert("请输入正确的验证码!");
		code.focus();
		return false;
	}
  return true;
  }  
  
/*****************************************************  
 *  函数名：anotherImg()
 *  作  用：刷新验证码
 *	参  数：无 
 *****************************************************
*/ 
function anotherImg()
{
	var obj = document.getElementById("code");
	obj.src="../util/rand.jsp?rnd="+Math.random();
}
