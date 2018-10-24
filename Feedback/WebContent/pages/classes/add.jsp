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
	<form name="frmAction" id="frmAction" method="post" action="userAction_update">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">添加班级</div>
					</div>
					<div class="mainbox-body">
					<input name="user.userId" type="hidden" id="classes.classId" value="${requestScope.classes.classId}" />
						<table cellpadding="0" cellspacing="0" border="0"
							class="table-fixed">
							<tr>
								<td>

									<div class="statistics-box-order">
										<div class="statistics-body-order">
											<table width="100%" border="0px;" cellpadding="0px;"
												cellspacing="2px;">
												<tr>
													<td height="25px" align="right" >班级编号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="classes.classId"
														type="text" id="classes.classId"
														value="${requestScope.classes.classId}" /> <span class="info1">&nbsp;*&nbsp;${message1}</span></td>
												</tr>
												<tr>
													<td height="25px" align="right">班级名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="classes.className"
														type="text" id="classes.className"
														value="${requestScope.classes.className}" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">开班日期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="classes.createDate"
														type="date" id="classes.createDate"
														value="${requestScope.classes.createDate}" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">班级状态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td><select name="classes.classStatus" id="classes.classStatus">
															<option value="0"
																${requestScope.classes.classStatus==0?'selected':'' }>注销</option>
															<option value="1"
																${requestScope.classes.classStatus==1?'selected':'' }>正常</option>
															<option value="2"
																${requestScope.classes.classStatus==2?'selected':'' }>已毕业</option>
													</select></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">辅导员编号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2">
													<select name="classes.counselorId"
														id="classes.counselorId">
															<c:forEach var="counselor" items="${counselors}">
																<option value="${classes.counselorId}" 
																<c:if test="${requestScope.classes.counselorId==counselor.counselorId}"> selected="selected"</c:if>>${counselor.name}</option>
															</c:forEach>
													</select>
													</td>
												</tr>
												
												<tr>
													<td height="25px" align="right">所在基地编号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2">
													<select name="classes.TeachingBase.baseId"
														id="classes.TeachingBase.baseId">
															<c:forEach var="base" items="${bases}">
																<option value="${base.baseId}" 
																<c:if test="${requestScope.classes.teachingBase.baseId==base.baseId}"> selected="selected"</c:if>>${base.baseName}</option>
															</c:forEach>
													</select>
													</td>
												</tr>
												
												<tr>
													<td colspan="3">
														<p align="center" /> <br /> <input type="submit"
														value=" 保 存 " /> 
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
