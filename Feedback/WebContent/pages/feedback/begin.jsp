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
	<form name="frmAction" id="frmAction" method="post" action="feedBackAction_begin">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">开启反馈批次</div>
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
													<td>
														<input type="hidden" name="feedback.status" id="feedback.status" value="2" />
													</td>
												</tr>
												<tr>
													<td height="25px" align="right">所在班级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2">
													<select name="feedback.classes.classId"
														id="feedback.classes.classId">
															<c:forEach var="classes" items="${classes}">
																<option value="${classes.classId}" 
																<c:if test="${feedback.classes.classId==classes.classId}"> selected="selected"</c:if>>${classes.className}</option>
															</c:forEach>
													</select>
													</td>
												</tr>
												
												<tr>
													<td height="25px" align="right">反馈名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="feedback.feedbackName"
														type="text" id="feedback.feedbackName"
														value="${feedback.feedbackName}" /> <span class="info1">&nbsp;*&nbsp;${message2}</span></td>
												</tr>
												<tr>
													<td height="25px" align="right">学年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="feedback.schoolYear"
														type="text" id="feedback.schoolYear"
														value="${feedback.schoolYear}" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">所属学期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td><select name="feedback.semester" id="feedback.semester">
															<option value="1" <c:if test="${feedback.semester=='1'}"> selected="selected"</c:if>>上学期</option>
															<option value="2" <c:if test="${feedback.semester=='2'}"> selected="selected"</c:if>>下学期</option>
													</select></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">开启时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="feedback.beginTiime"
														type="date" id="feedback.beginTiime"
														value="${feedback.beginTiime}" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">结束时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="feedback.endTime"
														type="date" id="feedback.endTime"
														value="${feedback.endTime}" /></td>
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
