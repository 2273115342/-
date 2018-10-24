<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script src="resource/js/feedback.js" language="javascript"
	type="text/javascript"></script>
</head>
<body>
	<form name="frmAction" id="frmAction" method="post" action="feedBackAction_end">
		<input name="id" type="hidden" id="id" value="0" />

		<div id="main_frame">
			<div id="main_column">

				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">借宿反馈批次</div>
					</div>

					<div class="mainbox-body">
						<table cellpadding="0" cellspacing="0" border="0"
							class="table-fixed">
							<tr>
								<td>
									<div class="statistics-box-order">
										<div class="statistics-body-order">

											<table width="100%" border="0" cellpadding="3"
												cellspacing="1">
												<tr align="center">
														<td height="20">ID</td>
														<td>反馈名称</td>
														<td>学年</td>
														<td>开启时间</td>
														<td>结束时间</td>
														<td> 操 作 </td>
													</tr>
												<c:forEach var="feedbacks" items="${feedbackAlls}" varStatus="status">
													<tr class="vieworder_row">
														<td align="center"><c:out value="${feedbacks.feedbackId}" /></td>
														<td align="center"><c:out value="${feedbacks.feedbackName}" /></td>
														<td align="center"><c:out value="${feedbacks.schoolYear}" /></td>
														<td align="center"><c:out value="${feedbacks.beginTiime}" /></td>
														<td align="center"><c:out value="${feedbacks.endTime}" /></td>
														<td align="center">
															<input type="button"
															onclick="delSingle(${feedbacks.feedbackId})" value="结束反馈批次"/>
														</td>
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
