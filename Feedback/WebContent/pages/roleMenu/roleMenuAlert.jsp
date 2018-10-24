<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script src="resource/js/rolemenu.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="resource/js/updateJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/updateJs/myUtil.js"></script>
<script type="text/javascript" src="resource/js/updateJs/roleMenuAlert.js"></script>
<style type="text/css">
#alertRoleMenue table td span{
	display: inline-block;
	padding: 10px;
}
</style>
</head>
<body>
	<form id='alertRoleMenue' action='menuAction_alertRoleMenue' method='post'>
			<h1 style='text-align:center;'>角色菜单管理</h1>
		<div style="height: 500px;overflow: auto;">
		<table>
		<!-- 角色拥有的菜单 -->
			<tr>
				<td>角色名：</td>
				<td id="roleName" roleId="<s:property value="#request.roleId" />"><s:property value="#request.roleName" /></td>
			</tr>
			<tr>
				<td><h3>该角色拥有的菜单</h3></td>
			</tr>
			<s:iterator value="#request.allMenusList" var="aml">
				<s:if test="#aml.parentMenuId==0">
					<tr>
						<td>roleMenulist
							<input type="checkbox" mId="<s:property value="#aml.menuId" />" name="Owned" value="<s:property value="#aml.menuId" />" />
							<span style="color:#0A9CCC"><b><s:property value="#aml.menuName" /></b></span>
						</td>
					</tr>
					<s:iterator value="#request.allMenusList" var="aml2" status="st">
						<s:if test="#aml2.parentMenuId==#aml.menuId">
							<s:if test="#st.index%4==0&&#st.index>0">
								</tr>
							</s:if>
				 			<s:if test="#st.index%4==0||st.index==0">
				 				<tr>
					 				<td>
										<input type="checkbox" mId="<s:property value="#aml2.menuId" />" name="Owned" value="<s:property value="#aml2.menuId" />" />
										<span><b><s:property value="#aml2.menuName" /></b></span>
									</td>
				 			</s:if>
				 			<s:else>
				 				<td>
									<input type="checkbox" mId="<s:property value="#aml2.menuId" />" name="Owned" value="<s:property value="#aml2.menuId" />" />
									<span><b><s:property value="#aml2.menuName" /></b></span>
								</td>
				 			</s:else>
						</s:if>
					</s:iterator>
				</s:if>
				<s:else>
					
				</s:else>
			</s:iterator>
			<tr>
				<td>
					<input type='button' class='okAlert' value='修&nbsp;改' />
				</td>
				<td>
					<input type='button' class='returnPage' value='返&nbsp;回' />
				</td>
			</tr>
		</table>
		</div>
	</form>
	<s:if test="#request.st!=null">
		<script type="text/javascript">
			$("#alertRoleMenue input[type='checkbox']").attr("disabled","disabled");
			$(".okAlert").hide();
		</script>
	</s:if>
</body>
</html>
