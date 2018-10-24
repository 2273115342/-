<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="resource/css/new_style.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<form name="frmAction" id="frmAction" method="post" action="userRoleAction_queryByCond">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">查询用户角色</div>
					</div>
					<div class="mainbox-body">
					<input name="user.userId" type="hidden" id="user.userId" value="${requestScope.user.userId}" />
						<table width="100%">
							<tr>
								<td width="100%">查询条件：&nbsp;&nbsp;
								<select name="condName" id="condName">
								<option value="userId" <c:if test="${condName=='userId'}"> selected="selected"</c:if>>用户编号</option>
								<option value="loginName" <c:if test="${condName=='loginName'}"> selected="selected"</c:if>>登录名</option></select>
								 &nbsp;&nbsp;<input name="condValue"
												type="text" id="condValue"
												value="${condValue}" />&nbsp;&nbsp;<input type="submit"
														value=" 查询 " />&nbsp;&nbsp;<span class="info1">&nbsp;*&nbsp;${message}</span></td>
							</tr>
						</table>
						<table cellpadding="0" cellspacing="0" border="0"
							class="table-fixed">
							<tr>
								<td>
									<div class="statistics-box-order">
										<div class="statistics-body-order">
											<table width="100%" border="0px;" cellpadding="0px;"
												cellspacing="2px;">
												<tr>
													<td height="25px" align="right" >登录名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.loginName"
														type="text" id="user.loginName"
														value="${requestScope.user.loginName}" disabled="true" /> </td>
												</tr>
												<tr>
													<td height="25px" align="right">姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.name"
														type="text" id="user.name"
														value="${requestScope.user.name}"  disabled="true" /></td>
												</tr>
												
												
												<tr>
													<td height="25px" align="right">性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td><select name="user.sex" id="user.sex"  disabled="true">
															<option value="男"
																<c:if test="${requestScope.user.sex=='男'}"> selected="selected"</c:if>>男</option>
															<option value="女"
																<c:if test="${requestScope.user.sex=='女'}"> selected="selected"</c:if>>女</option>
													</select></td>
												</tr>
												<tr>
													<td height="25px" align="right">用户角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><select name="user.role.roleId"
														id="user.role.roleId"  disabled="true">
															<c:forEach var="role" items="${roles}">
																<option value="${role.roleId}" 
																<c:if test="${requestScope.user.role.roleId==role.roleId}"> selected="selected"</c:if>>${role.roleName}</option>
															</c:forEach>
													</select>
													</td>
												</tr>
												<tr>
													<td height="25px" align="right">用户类别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td><select name="user.userType" id="user.userType"  disabled="true">
															<option value="1" <c:if test="${requestScope.user.userType=='1'}"> selected="selected"</c:if>>教师</option>
															<option value="2" <c:if test="${requestScope.user.userType=='2'}"> selected="selected"</c:if>>学生</option>
													</select></td>
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
</body>
</html>
