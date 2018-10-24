<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script src="resource/js/entity.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="resource/js/updateJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/updateJs/myUtil.js"></script>
<script type="text/javascript" src="resource/js/updateJs/lookMenu.js"></script>
<link href="resource/css/updateCss/menuList.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form name="menuList" id="menuList" method="post" action="menuAction_lookMenuByCondition">
		<input name="id" type="hidden" id="id" value="0" />

		<div id="main_frame">
			<div id="main_column">

				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">系统菜单查询</div>
						<s:if test="#request.message!=null">
							<div style="display: none;" class="message"><s:property value="#request.message"/></div>
							<script type="text/javascript">
								if($(".message").text()=="查询成功！"){
									popUpMessage(".message", $(".message").text(), 3000, 15, 35, false);
								}else{
									popUpMessage(".message", $(".message").text(), 6000, 15, 35, false);
								}
							</script>
						</s:if>
					</div>
					<div class="mainbox-body">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table-fixed">
							<tr>
								<td>
									<div class="statistics-box-order">
										<div class="statistics-body-order">

											<table width="100%">
												<tr>
													<td width="100%">
														<input type="text" name="searchText" placeholder="菜单id/菜单名" class="searchText"/>&nbsp;&nbsp;
														<input type="submit" class="searchMenu" value=" 搜 索 " />&nbsp;&nbsp;
													</td>
												</tr>
											</table>

											<table width="100%" border="0" cellpadding="3" cellspacing="1">
												<tr align="center">
														<td><input type="checkbox"
															name="selall" onclick="selectAll(this)" /></td>
														<td height="20">ID</td>
														<td>菜单名</td>
														<td>菜单链接</td>
														<td> 操 作 </td>
													</tr>
												<s:iterator value="#request.MenuList" var="ml" status="str">
													<tr class="vieworder_row">
														<s:if test="#ml.menuId==null">
															<td>该搜索条件下没有符合的菜单</td>
														</s:if>
														<td align="center">
															<input type='checkbox' name='ids' value="<s:property value="#ml.menuId"/>" />
														</td>
														<td align="center"><s:property value="#ml.menuId"/></td>
														<td align="center"><s:property value="#ml.menuName"/></td>
														<td align="center"><s:property value="#ml.url"/></td>
														<td align="center">
															<input type="button" class="lookMenu" value=" 查看 " />
														</td>
													</tr>
												</s:iterator>
												<s:if test="#request.MenuList.size()<=0">
													<tr>
														<td>该搜索条件下没有符合的菜单</td>
													</tr>
												</s:if>
											</table>
											<s:if test="#request.NoPage==null">
												<div class="page" style="text-align: center;">
													<span page="0">首页</span>
													<s:if test="#request.currentPage!=0">
														<span page="<s:property value="#request.currentPage-1"/>">上一页</span>
													</s:if>
													<s:if test="#request.currentPage+1<=#request.overallPageCount">
														<span page="<s:property value="#request.currentPage+1"/>" >下一页</span>
													</s:if>
													<span page="<s:property value="#request.overallPageCount"/>">末页</span>
												</div>
											</s:if>
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
	<!-- 遮罩窗口 -->
	<div class="maskWindow"></div>
	<!-- 查看的页面 -->
	<div class="alertPageMain">
		<div class='alterAddPage'></div>
		<div class="closeAlertPageMain" style="position: absolute;left: 60%;top: 10%;font-size: 18px;">X</div>
	</div>
	
	<div style="display: none;" id="updateMessage">
		<s:property value="#request.updateMessage"/>
	</div>
	<s:if test="#request.updateMessage!=null">
		<script type="text/javascript">
			popUpMessage(".maskWindow", $("#updateMessage").text(), 3000, 15, 35, false)
		</script>
	</s:if>
</body>
</html>
