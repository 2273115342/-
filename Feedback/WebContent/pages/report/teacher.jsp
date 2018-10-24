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
	<form name="frmAction" id="frmAction" method="post" action="">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">按教师统计</div>
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
											 <table width="100%" border="0" cellpadding="3"
												cellspacing="1">
												<tr align="center">
														<td>教师名</td>
														<td>课程名</td>
														<td>指标类型</td>
														<td>指标项</td>
														<td>满分</td>
														<td>平均得分</td>
													</tr>
												<c:forEach var="user" items="${users}" varStatus="status">
													<tr class="vieworder_row">
														<td align="center"><c:out value="${user.userId}" /></td>
														<td align="center"><c:out value="${user.loginName}" /></td>
														<td align="center"><c:out value="${user.sex}" /></td>
														<td align="center"><c:out value="${user.name}" /></td>
														<td align="center"><c:out value="${user.idcard}" /></td>
														<td align="center"><c:out
																value="${user.role.roleName}" /></td>
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
