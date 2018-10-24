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
	<form name="frmAction" id="frmAction" method="post" action="userAction_save">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">增加用户</div>
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
												<tr>
													<td height="25px" align="right" >登录名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.loginName"
														type="text" id="user.loginName"
														value="${requestScope.user.loginName}" /> <span class="info1">&nbsp;*&nbsp;${message1}</span></td>
												</tr>
												<tr>
													<td height="25px" align="right">密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.password"
														type="password" id="user.password"
														value="${requestScope.user.password}" /> <span class="info1">&nbsp;*&nbsp;${message2}</span></td>
												</tr>
												<tr>
													<td height="25px" align="right">姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.name"
														type="text" id="user.name"
														value="${requestScope.user.name}" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">身份证号码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.idcard"
														type="text" id="user.idcard"
														value="${requestScope.user.idcard}" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td><select name="user.sex" id="user.sex">
															<option value="男"
																<c:if test="${requestScope.user.sex=='男'}"> selected="selected"</c:if>>男</option>
															<option value="女"
																<c:if test="${requestScope.user.sex=='女'}"> selected="selected"</c:if>>女</option>
													</select></td>
												</tr>
												
												
												<tr>
													<td height="25px" align="right">出生日期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.birthday"
														type="date" id="user.birthday"
														value="${requestScope.user.birthday}" /></td>
												</tr>
												
												
												<tr>
													<td height="25px" align="right">联系地址&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.address"
														type="text" id="user.address"
														value="${requestScope.user.address}" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">联系电话&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="user.telephone"
														type="text" id="user.telephone"
														value="${requestScope.user.telephone}" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">所在部门&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2">
													<select name="user.department.deptId"
														id="user.department.deptId">
															<c:forEach var="department" items="${departments}">
																<option value="${department.deptId}" 
																<c:if test="${requestScope.user.department.deptId==department.deptId}"> selected="selected"</c:if>>${department.deptName}</option>
															</c:forEach>
													</select>
													</td>
												</tr>
												
												<tr>
													<td height="25px" align="right">所在班级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2">
													<select name="user.classes.classId"
														id="user.classes.classId">
															<c:forEach var="classes" items="${classes}">
																<option value="${classes.classId}" 
																<c:if test="${requestScope.user.classes.classId==classes.classId}"> selected="selected"</c:if>>${classes.className}</option>
															</c:forEach>
													</select>
													</td>
												</tr>
												
												<tr>
													<td height="25px" align="right">用户角色&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><select name="user.role.roleId"
														id="user.role.roleId">
															<c:forEach var="role" items="${roles}">
																<option value="${role.roleId}" 
																<c:if test="${requestScope.user.role.roleId==role.roleId}"> selected="selected"</c:if>>${role.roleName}</option>
															</c:forEach>
													</select>
													</td>
												</tr>
												<tr>
													<td height="25px" align="right">用户类别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td><select name="user.userType" id="user.userType">
															<option value="1" <c:if test="${requestScope.user.userType=='1'}"> selected="selected"</c:if>>教师</option>
															<option value="2" <c:if test="${requestScope.user.userType=='2'}"> selected="selected"</c:if>>学生</option>
													</select></td>
												</tr>
												<tr>
													<td colspan="3">
														<p align="center" /> <br /> <input type="submit"
														value=" 保 存 " /> <input type="button" value=" 返 回 "
														onclick='javascript: history.go(-1)' />
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
