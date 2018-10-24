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
	<form name="frmAction" id="frmAction" method="post" action="suggestionAction_queryByCond">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">查询建议</div>
					</div>
					<div class="mainbox-body">
					<input name="suggestion.SUG_ID" type="hidden" id="user.userId" value="" />
						<table width="100%">
							<tr>
								<td width="100%">查询条件：&nbsp;&nbsp;
								<select name="condName" id="condName">
								<option value="TEACHER_ID" <c:if test="${condName=='teacher_id'}"> selected="selected"</c:if>>老师编号</option>
								<option value="STUDENT_ID" <c:if test="${condName=='student_id'}"> selected="selected"</c:if>>学生编号</option></select>
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
												<s:iterator value="#request.lists" var="li" status="str">
													<tr>
														<td height="25px" align="right" >个人建议&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
														<td colspan="2">
															<input type="text" value="<s:property value="#li.sugContent" />" disabled="true" />
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
</body>
</html>
