<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resource/js/updateJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/updateJs/myUtil.js"></script>
<script type="text/javascript" src="resource/js/updateJs/menuAdd.js"></script>
<style type="text/css">
#frmAction #main_frame #main_column .mainbox-body input,#frmAction #main_frame #main_column .mainbox-body select{
	padding: 0px 10px;
	border-radius: 4px;
	border: 1px #aaa solid;
}
#frmAction #main_frame .input input:hover{
	background-color:#ccc;
	cursor: pointer;
}
.checkText{
	position: absolute;
}
</style>
</head>
<body>

	<form name="frmAction" id="frmAction" method="post" action="menuAction_add" enctype="multipart/form-data">
	<s:if test="#request.MenuList!=null">
		<script type="text/javascript">
			$("#frmAction").attr("action","menuAction_updateMenu");
		</script>
	</s:if>
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
							<div class="mainbox-title addMenuTitle">增加系统菜单</div>
					</div>
					<div class="mainbox-body">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table-fixed">
							<tr>
								<td>
									<div class="statistics-box-order">
										<div class="statistics-body-order">
											<table width="100%" border="0px;" cellpadding="0px;"
												cellspacing="2px;">
												<tr style="display: none;">
													<td>
														<input name="menu.menuId" type="text" value="${requestScope.MenuList.menuId}" /> 
													</td>
												</tr>
												<tr>
													<td height="25px" align="right" >菜单名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="menu.menuName"
														type="text" id="menuName" maxlength="12"
														value="${requestScope.MenuList.menuName}" /> <span class="info1">&nbsp;*&nbsp;${message1}</span></td>
												</tr>
												<!-- <s:property value="#request.menu.menuName"/> -->
												<tr>
													<td height="25px" align="right">响应链接&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="menu.url"
														type="text" id="url" maxlength="60"
														value="${requestScope.MenuList.url}" />
														<span class="info1">&nbsp;*&nbsp;</span>
													</td>
												</tr>
												<s:if test="#request.MenuList.menuIcon!=null">
													<tr class="imgArea">
														<td align="right">当前菜单图片：</td>
														<td>
															<img id="updateImg" src="${requestScope.MenuList.menuIcon}" style="width:80px;height:80px;border: 1px solid #ccc;"/>
														</td>
													</tr>
												</s:if>
												<s:else>
													<tr class="imgArea" style="display: none;">
														<td align="right"></td>
														<td>
															<img id="updateImg" style="width:80px;height:80px;border: 1px solid #ccc;"/>
														</td>
													</tr>
												</s:else>
												<tr>
													<td height="25px" align="right">菜单图标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2">
														<input name="menuIcon" id="menuIcon" type="file" value="${requestScope.MenuList.menuIcon}" />	
														<span class="info1">&nbsp;*&nbsp;</span>
													</td>
												</tr>
												<tr>
													<td height="25px" align="right">上级菜单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><select name="menu.parentMenuId" id="parentMenuId">
														<s:iterator value="#request.firstMenuList" var="fml" status="fid">
															<option <s:if test="#request.MenuList.parentMenuId==#fml.menuId">selected="selected"</s:if>
															value="<s:property value="#fml.menuId" />">
																<s:property value="#fml.menuName" />
															</option>
														</s:iterator>
														<option value="0" <s:if test="#request.MenuList.parentMenuId==0"> selected="selected" </s:if> style="color: red;">
															首级菜单
														</option>
													</select></td>
												</tr>
												<tr>
													<td height="25px" align="right">菜单是否有效&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><select name="menu.validFlag" id="validFlag">
															<option value="1" <s:if test="#request.MenuList.validFlag==1">selected="selected"</s:if>>有效</option> 
															<option value="0" <s:if test="#request.MenuList.validFlag==0">selected="selected"</s:if>>无效</option>
													</select></td>
												</tr>
												<tr>
													<td height="25px" align="right">菜单描述信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2">
														<textarea name="menu.menuDesc" id="menuDesc"><s:property value="#request.MenuList.menuDesc" /></textarea>
														<span class="checkText"></span>
													</td>
												</tr>
												<tr>
													<td colspan="3" class="input">
														<p align="center" /> <br /> 
														<input type="submit" class="saveMenuButton" id="submit" value=" 保 存 " /> 
														<input type="button" class="saveClearMenu" id="clear" value=" 清 空 "/>
													</td>
												</tr>
											</table>
										</div>
									</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
<s:if test="#request.MenuList!=null&&#request.lookMenu==null">
	<script type="text/javascript">
		$(".addMenuTitle").text("修改系统菜单");
		$(".saveMenuButton").val("修改");
		$(".saveClearMenu").hide();
	</script>
</s:if>
<s:if test="#request.lookMenu!=null">
	<script type="text/javascript">
		$("#frmAction input,select,textarea").attr("disabled","disabled");
		$(".addMenuTitle").text("查看系统菜单");
		$(".saveMenuButton").hide();
		$(".saveClearMenu").hide();
	</script>
</s:if>
<!-- 以下代码为后台返回结果的提示 begin -->
<s:if test="#request.success==1">
	<script type="text/javascript">
		popUpMessage("#frmAction", "新增成功", 3000, 15, 25);
	</script>
</s:if>
<s:if test="#request.message!=null">
	<div id="errorInfo" style="display: none;"><s:property value="#request.message" /></div>
</s:if>
<s:if test="#request.success==-1">
	<script type="text/javascript">
		popUpMessage("#frmAction", $("#errorInfo").text(), 8000,15, 5);
	</script>
</s:if>
<!-- 以上代码为后台返回结果的提示 end -->
</body>
</html>
