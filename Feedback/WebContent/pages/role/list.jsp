<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script src="resource/js/role.js" language="javascript"
	type="text/javascript"></script>
</head>
<body>
	<form name="frmAction" id="frmAction" method="post" action="list">
		<!-- 操作类型：1新增 2修改 3删除 -->
		<input name="operateType" type="hidden" id="operateType" value="0" />
		<input name="role.roleId" type="hidden" id="role.roleId" value="" />
		<input name="role.roleName" type="hidden" id="role.roleName" value="" />

		<div id="main_frame">
			<div id="main_column">

				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">角色管理</div>
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
														value=" 增 加 " />&nbsp;&nbsp; <input
														type="button" onclick="del()" value=" 删 除 " />&nbsp;&nbsp;
														<input type="button"  onclick="save()" value=" 保存 " />&nbsp;&nbsp;</td>
												</tr>
											</table>

											<table width="100%" border="0" cellpadding="3"
												cellspacing="1" id="roleListTable">
												<tr align="center">
														<td><input type="checkbox"
															name="selall" onclick="selectAll(this)" /></td>
														<td height="20">ID</td>
														<td>角色名称</td>
														<td> 操 作 </td>
													</tr>
												<c:forEach var="role" items="${roles}" varStatus="status">
													<tr class="vieworder_row">
														<td align="center"><input type='checkbox' name='ids'
															value="${role.roleId}" /></td>
														<td align="center"><c:out value="${role.roleId}" /></td>
														<td align="center"><input name="role.roleName_${role.roleId}"
														type="text" id="role.roleName_${role.roleId}"
														value="<c:out value="${role.roleName}" />"  disabled="true" /></td>
														<td align="center"><input type="button"
															onclick="editSingle(${role.roleId})" value=" 修 改 " /> <input type="button"
															onclick="delSingle(${role.roleId})"
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
