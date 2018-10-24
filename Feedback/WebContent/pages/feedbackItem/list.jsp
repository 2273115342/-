<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script src="resource/js/updateJs/feedbackItem.js" language="javascript"
	type="text/javascript"></script>
</head>
<body>
	<form name="frmAction" id="frmAction" method="post" action="list">
		<input name="fiId" type="hidden" id="fiId" value="0" />

		<div id="main_frame">
			<div id="main_column">

				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">反馈指标管理</div>
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
														<td height="20">反馈指标项编号</td>
														<td>反馈指标项类型编号</td>
														<td>反馈指标项名称</td>
														<td>指标项分值</td>
														<td>显示顺序</td>
													</tr>
												<c:forEach var="feedbackItem" items="${feedbackItems}" varStatus="status">
													<tr class="vieworder_row">
														<td align="center"><input type='checkbox' name='ids'
															value="${feedbackItem.fiId}" /></td>
														<td align="center"><c:out value="${feedbackItem.fiId}" /></td>
														<td align="center"><c:out value="${feedbackItem.feedbackItemType.fitId}" /></td>
														<td align="center"><c:out value="${feedbackItem.fiName}" /></td>
														<td align="center"><c:out value="${feedbackItem.itemValue}" /></td>
														<td align="center"><c:out value="${feedbackItem.dispOrder}" /></td>
														<td align="center"><input type="button"
															onclick="editSingle(${feedbackItem.fiId})" value=" 修 改 " /> <input type="button"
															onclick="delSingle(${feedbackItem.fiId})"
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
