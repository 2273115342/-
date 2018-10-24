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
<style type="text/css">
.maskWindow{
	position: absolute;
	top: 0px;
	background-color: #aaa;
	z-index: 20;
	width: 100%;
	height: 100%;
	left: 0;
	opacity: 0.7;
	display: none;
}
.alterAddPage{
	display:none;
	padding:30px;
	position: fixed;
	top:0;
	left: 15%;
	background-color: white;
	z-index: 21;
	width: 60%;
}
</style>
</head>
<body>
	<form name="frmAction" id="frmAction" method="post" action="menuAction_queryRoleMenuInfo">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title roleMenuWH">角色菜单维护</div>
					</div>
					<div class="mainbox-body">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table-fixed">
							<tr>
								<td>
									<div class="statistics-box-order">
										<div class="statistics-body-order">
											<s:if test="#request.message!=null">
												<table width="100%" align="center">
													<tr style="display: none;">
														<td width="100%" id="message">
															<s:property value="#request.message" />
														</td>
													</tr>
												</table>
												<script type="text/javascript">
														popUpMessage("#main_column", $("#message").text(), 3000, 15, 35, false)
												</script>
											</s:if>
											<table width="100%" border="0" cellpadding="3" cellspacing="1">
												<tr align="center">
													<td height="20">角色编号</td>
													<td>角色名</td>
													<td>操作</td>
												</tr>
												<s:iterator value="#request.roles" var="roles">
													<tr align="center">
														<td height="20" class="roleId"><s:property value="#roles.roleId" /></td>
														<td><s:property value="#roles.roleName" /></td>
														<td>
															<input type="button" class="alterRml" value=" 修 改 " /> 
														</td>
													</tr>
												</s:iterator>
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
	<!-- 遮罩窗口 -->
	<div class="maskWindow"></div>
	<!-- 修改、新增公用的页面 -->
	<div class='alterAddPage'></div>
	<s:if test="#request.st!=null">
		<script type="text/javascript">
			$(".roleMenuWH").text("角色菜单查询");
			$(".alterRml").val("查看");
		</script>
	</s:if>
<script type="text/javascript">
	$(function(){
		$(".maskWindow").height($("body").height());
		//单击管理界面修改按钮
		$(".alterRml").each(function(){
			$(this).unbind("click").on("click",function(){
				if($(".alterRml").val()=="查看"){
					var	url = "menuAction_queryRoleMenu?st=1";
				}else{
					var url = "menuAction_queryRoleMenu";
				}
				var roleID = {"roleId":findFatherBrothers(this,"td",0),"roleName":findFatherBrothers(this,"td",1)};
				$.ajax({
		            url:url,
		            dataType:"html",
		            data: roleID,
		            type:"post",
		            beforeSend: function(){
		            	loading = loadingFlash(".maskWindow", 15, 25, 100);
		            },
		            success:function(result){
		            	$(loading).remove();
		            	$(".maskWindow").show();
		            	$(".alterAddPage").show();
		                $(".alterAddPage").html(result);
		            },
		            error:function(XMLHttpRequest, textStatus, errorThrown){
		            	$(loading).remove();
		            	popUpMessage(".alterAddPage", '查询失败'+XMLHttpRequest
		                		+textStatus+errorThrown, 5000, 15, 25, false);
		            }
		        });
			});
		});
	});
</script>
</body>
</html>
