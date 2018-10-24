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
	<form name="frmAction" id="frmAction" method="post" action="feedBackAction_query">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">查询反馈批次</div>
					</div>
					<div class="mainbox-body">
					<input name="feedback.feedbackId" type="hidden" id="feedback.feedbackId" value="${feedback.feedbackId}" />
						<table width="100%">
							<tr>
								<td width="100%">查询条件：&nbsp;&nbsp;
								<select name="condName" id="condName">
								<option value="feedbackId" <c:if test="${condName=='feedbackId'}"> selected="selected"</c:if>>反馈编号</option>
								<option value="feedbackName" <c:if test="${condName=='feedbackName'}"> selected="selected"</c:if>>反馈名</option></select>
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
													<td height="25px" align="right">反馈名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="feedback.feedbackName"
														type="text" id="feedback.feedbackName"
														value="${feedback.feedbackName}"  disabled="true" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">学年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="feedback.schoolYear"
														type="text" id="feedback.schoolYear"
														value="${feedback.schoolYear}"  disabled="true" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">开始时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="feedback.beginTiime"
														type="text" id="feedback.beginTiime"
														value="${feedback.beginTiime}"  disabled="true" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">结束时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2"><input name="feedback.endTime"
														type="text" id="feedback.endTime"
														value="${feedback.endTime}"  disabled="true" /></td>
												</tr>
												
												<tr>
													<td height="25px" align="right">反馈状态&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td><select name="feedback.status" id="feedback.status"  disabled="true">
															<option value="0" <c:if test="${feedback.status=='0'}"> selected="selected"</c:if>>失效</option>
															<option value="1" <c:if test="${feedback.status=='1'}"> selected="selected"</c:if>>进行中</option>
															<option value="2" <c:if test="${feedback.status=='2'}"> selected="selected"</c:if>>待进行</option>
															<option value="3" <c:if test="${feedback.status=='3'}"> selected="selected"</c:if>>已完成</option>
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
