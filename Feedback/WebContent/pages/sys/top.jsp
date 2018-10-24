<%@ page contentType="text/html; charset=utf-8" language="java" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="../../resource/js/updateJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../../resource/js/updateJs/myUtil.js"></script>
<script language=JavaScript>
function logout(){
	if (confirm("您确定要退出登录吗？")){
		$.ajax({
            url:"userAction_quitLogin",
            dataType:"html",
            type:"post",
            beforeSend: function(){
                $('.loading').html('正在处理请稍后...');
            },
            success:function(result){
            	parent.location.reload();
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
            	popUpMessage($("#main",parent.document), "退出登录失败："+XMLHttpRequest
                		+textStatus+errorThrown, 2000, 35, 30,true);
            }
        }); 
		return false;
	}
}
</script>

<link href="../../resource/css/new_style.css" rel="stylesheet" type="text/css" />



</head>
<body>
<div class="header-wrap">
<div id="header">

<div id="logo">
	
</div>
<div id="top_quick_links">
	<a>${(user.name)}， 您好！今天是
        <script language=javascript type=text/javascript>
		<!--
				var enabled = 0; today = new Date();
				var day; var date;
				if(today.getDay()==0) day = " 星期日"
				if(today.getDay()==1) day = " 星期一"
				if(today.getDay()==2) day = " 星期二"
				if(today.getDay()==3) day = " 星期三"
				if(today.getDay()==4) day = " 星期四"
				if(today.getDay()==5) day = " 星期五"
				if(today.getDay()==6) day = " 星期六"
				date = (today.getFullYear()) + "年" + (today.getMonth() + 1 ) + "月" + today.getDate() + "日" + day +"";
				document.write(date);
		// -->
		</script>
		&nbsp;&nbsp;
		<a href="../../index" title="回到首页" target="_blank" >网站首页</a>
		
		</a>
</div>

<ul id="menu">
	<li class="quit"><a href="#" target="_self" onClick="logout();"><img src="../resource/images/out.gif" alt="安全退出" width="46" height="20" border="0"></a></li>
</ul>

	</div>
</div>    
</body>
</html>