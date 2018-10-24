<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=utf-8" language="java"
	 errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="resource/css/updateCss/left.css" type="text/css" />
<script type="text/javascript" src="resource/js/updateJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/updateJs/tool.domElement.js"></script>
<script type="text/javascript" src="resource/js/updateJs/myUtil.js"></script>
<script type="text/javascript" src="resource/js/updateJs/left.js"></script>

</head>

<body>
	<div style="width:180px">
		<ul >
			<s:iterator value="#request.userMenuList" var="uml" status="fid">
				<s:if test="#uml.parentMenuId==0">
					<li>
						<div class="adminleftmenu"><s:property value="#uml.menuName" /></div>
						<ul class="adminleftsubmenu">
							<s:iterator value="#request.userMenuList" var="uml2" status="fid2">
								<s:if test="#uml.menuId==#uml2.parentMenuId">
									<li class="menu" mid="<s:property value="#uml2.menuId" />" adderss="<s:property value="#uml2.url" />"><s:property value="#uml2.menuName" /></li>
								</s:if>
							</s:iterator>
						</ul>
					</li>
				</s:if>
			</s:iterator>
		</ul>
	</div>
</body>
</html>
