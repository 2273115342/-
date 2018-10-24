<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script src="resource/js/entity.js" language="javascript"
	type="text/javascript"></script>
</head>
<body>
	<form name="frmAction" id="frmAction" method="post" action="list">
		<input name="id" type="hidden" id="id" value="0" />

		<div id="main_frame">
			<div id="main_column">

				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">用户管理</div>
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
													<td width="100%"><input type="button" onclick="add()"
														value=" 增 加 " />&nbsp;&nbsp; <input type="button"
														onclick="edit()" value=" 修 改 " />&nbsp;&nbsp; <input
														type="button" onclick="del()" value=" 删 除 " />&nbsp;&nbsp;</td>
												</tr>
											</table>

											<table width="100%" border="0" cellpadding="3"
												cellspacing="1">
												<tr align="center">
														<td><input type="checkbox"
															name="selall" onclick="selectAll(this)" /></td>
														<td height="20">ID</td>
														<td>登录名</td>
														<td>性别</td>
														<td>姓名</td>
														<td>身份证号码</td>
														<td>所属部门</td>
														<td>用户类别</td>
														<td> 操 作 </td>
													</tr>
												<c:forEach var="user" items="${users}" varStatus="status">
													<tr class="vieworder_row">
														<td align="center"><input type='checkbox' name='ids'
															value="${user.userId}" /></td>
														<td align="center"><c:out value="${user.userId}" /></td>
														<td align="center"><c:out value="${user.loginName}" /></td>
														<td align="center"><c:out value="${user.sex}" /></td>
														<td align="center"><c:out value="${user.name}" /></td>
														<td align="center"><c:out value="${user.idcard}" /></td>
														<td align="center"><c:out
																value="${user.role.roleName}" /></td>
														<td align="center"><c:if test="${user.userType==1}">教师</c:if>
															<c:if test="${user.userType==2}">学生</c:if></td>
														<td align="center"><input type="button"
															onclick="editSingle(${user.userId})" value=" 修 改 " /> <input type="button"
															onclick="delSingle(${user.userId})"
															value=" 删 除 " /></td>
													</tr>
												</c:forEach>
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
