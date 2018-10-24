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
	<form name="frmAction" id="frmAction" method="post" action="userRoleAction_update">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">修改用户角色</div>
					</div>
					<div class="mainbox-body">
					<input name="user.userId" type="hidden" id="user.userId" value="${user.userId}" />
						<table cellpadding="0" cellspacing="0" border="0"
							class="table-fixed">
							<tr>
								<td>

									<div class="statistics-box-order">
										<div class="statistics-body-order">
											<table width="100%" border="0px;" cellpadding="0px;"
												cellspacing="2px;">
												<tr>
													<td height="25px" align="right" >用户ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.userId"
														type="text" id="user.userId"
														value="<c:out value="${user.userId}" />" disabled="true" /> <span class="info1">&nbsp;*&nbsp;${message1}</span></td>
												</tr>
												
												<tr>
													<td height="25px" align="right" >登录名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.loginName"
														type="text" id="user.loginName" disabled="true"
														value="${user.loginName}" /> <span class="info1">&nbsp;*&nbsp;${message1}</span></td>
												</tr>
												
												
												<tr>
													<td height="25px" align="right">用户角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><select name="user.role.roleId"
														id="user.role.roleId">
															<c:forEach var="role" items="${roles}">
																<option value="${role.roleId}" 
																<c:if test="${user.role.roleId==role.roleId}"> selected="selected"</c:if>>${role.roleName}</option>
															</c:forEach>
													</select>
													</td>
												</tr>
												
												
												<tr>
													<td colspan="3">
														<p align="center" /> <br /> <input type="submit"
														value="修改" /> 
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
</body>
</html>
