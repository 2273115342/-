<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>教学反馈系统</title>
<meta http-equiv=Content-Type content=text/html;charset=utf-8>
<link href="resource/css/updateCss/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div>
		<iframe class="topPage" src="pages/sys/top.jsp" height="85" width="100%" frameborder='0' scrolling="no"></iframe>
		<div class="main" id="main">
			<iframe class="leftPage" src="getSysMenu" width="250" height="385" frameborder='0'  style="height: 685px;"></iframe>
			<div class="rightPage">
				<div class="iframeName" id="iframeName">
					<div class="pageInp pitchOnIframeName" style="width: 10%;" mid="0" pageUrl="pages/sys/right.jsp">
						<span class="sonPageName">主页</span>
					</div> <!-- 此处换行导致出现了一个空白节点 -->
				</div>
				<div class="closeAll" style="position: absolute;right: 30px;top:10px;">closeAll</div>
				<iframe id="mainPage" class="son" src="pages/sys/right.jsp" mid="0" width="100%" frameborder='0'></iframe>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="resource/js/updateJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		//设置一些元素的size
		$(".rightPage").width($(window).width()-$(".leftPage").width());
		$(".iframeName").width($("#main_frame").width());
		$("#mainPage").height($("#main").height()-72);
		$(".leftPage").height(1200);
	});
</script>

</html>