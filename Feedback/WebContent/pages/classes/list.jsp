<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>班级管理</title>
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
						<div class="mainbox-title">班级管理</div>
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
													<td><input type="checkbox" name="selall"
														onclick="selectAll(this)" />
													</td>
													<td height="20">班级编号</td>
													<td>班级名称</td>
													<td>开班日期</td>
													<td>班级状态</td>
													<td>辅导员编号</td>
													<td>所属基地编号</td>
													<td> 操 作 </td>
												</tr>
												<c:forEach var="user" items="${class}" varStatus="status">
													<tr class="vieworder_row">
														<td align="center"><input type='checkbox' name='ids'
															value="${class.classId}" /></td>
														<td align="center"><c:out value="${class.classId}" /></td>
														<td align="center"><c:out value="${class.className}" /></td>
														<td align="center"><c:out value="${class.createDate}" /></td>
														<td align="center"><c:out value="${class.classStatus}" /></td>
														<td align="center"><c:out value="${class.counselorId}" /></td>
														<td align="center"><c:out value="${class.baseId}" /></td>
														<td><select name="classes.status" id="class.status">
													<td><select name="classes.classStatus" id="class.classStatus">
															<option value="1"
																${requestScope.classes.classStatus==1?'selected':'' }>正常</option>
													</select></td>
														<td align="center"><input type="button"
															onclick="editSingle(${classes.classId})" value=" 修 改 " /> <input type="button"
															onclick="delSingle(${classes.classId})"
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
