<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script src="resource/js/teachingBase.js" language="javascript"
type="text/javascript"></script>
</head>
<body>
	<form name="frmAction" id="frmAction" method="post" action="list">
		<input name="id" type="hidden" id="id" value="0" />

		<div id="main_frame">
			<div id="main_column">

				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">教学基地管理</div>
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
														<td height="20">基地编号</td>
														<td>基地名称</td>
														<td> 操 作 </td>
													</tr>
												<c:forEach var="teachingBase" items="${teachingBases}" varStatus="status">
													<tr class="vieworder_row">
														<td align="center"><input type='checkbox' name='ids'
															value="${teachingBase.baseId}" /></td>
														<td align="center"><c:out value="${teachingBase.baseId}" /></td>
														<td align="center"><c:out value="${teachingBase.baseName}" /></td>
														<td align="center"><input type="button"
															onclick="editSingle(${teachingBase.baseId})" value=" 修 改 " /> <input type="button"
															onclick="delSingle(${teachingBase.baseId})"
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
