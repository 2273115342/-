<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>部门管理</title>
<script type="text/javascript" src="resource/js/updateJs/jquery-3.2.1.min.js"></script>
<link href="resource/css/bootstrap.min.css" rel="stylesheet">
<link href="resource/css/styles.css" rel="stylesheet">
<script src="resource/js/jquery.dataTables.min.js"></script>
<script src="resource/js/dataTables.bootstrap.js"></script>
<script src="resource/js/bootstrap.min.js"></script>
<script src="resource/js/custom.js"></script>
<script src="resource/js/tables.js"></script>
<script src="resource/js/department.js" type="text/javascript"></script>
</head>

<script type="text/javascript">
<%--部门相同弹框提示--%>
	$(function(){
		if("${msg1}" != ""){
			alert("${msg1 }");
		}
		<% request.removeAttribute("msg1");%>
	})
</script>
<body>
	<form name="frmAction" id="frmAction" method="post" action="departmentAction_batchDelete">
		<!-- 操作类型：1新增 2修改 3删除 -->
		<input name="operateType" type="hidden" id="operateType" value="0" />
		<input name="department.deptId" type="hidden" id="department.deptId" value="" />
		<input name="department.deptName" type="hidden" id="department.deptName" value="" />
		<input name="department.deptAddress" type="hidden" id="department.deptAddress" value="" />

		<div class="row">
			<div class="col-md-12">
				<div class="content-box-large">
					<div class="panel-heading">
						<!-- 显示栏目标题 -->
						<div class="panel-title">部门管理</div>
                        <a href="javascript:;" onclick="add()" >添加部门</a>
						<a href="javascript:;" onclick="save()" >保存</a>
						<a href="javascript:;" onclick="del()" >批量删除</a>
					</div>
					<div class="panel-body">
						<div id="example_wrapper" class="dataTables_wrapper form-inline"
							role="grid">
							<table cellpadding="0" cellspacing="0" border="0"
								class="table table-striped table-bordered dataTable"
								id="example" aria-describedby="example_info">
								<thead>
									<tr role="row">
										<th><input type="checkbox" name="selall" onclick="selectAll(this)" /></th>
										<th class="sorting" >#</th>
										<th class="sorting" >部门编号</th>
										<th class="sorting" >部门名称</th>
										<th class="sorting" >部门地址</th>
										<th class="sorting" >操作</th>
									</tr>
								</thead>

								<tbody role="alert" aria-live="polite" aria-relevant="all" id="departmentListTable">
									<c:forEach var="department" items="${departments}" varStatus="status">
										<tr class="gradeA odd">
											<td class="sorting"><input type='checkbox' name='ids' value="${department.deptId}" /></td>
											<td class="sorting"><c:out value="${status.index+1}" /></td>
											<td class="sorting"><c:out value="${department.deptId}" /></td>
											<td class="sorting">
											<input name="department.departmentName_${department.deptId}" type="text"
												id="department.departmentName_${department.deptId}"
												value="<c:out value="${department.deptName}" />" disabled="true" />
											</td>
											<td class="sorting"><input name="department.departmentAddress_${department.deptId}" type="text"
												id="department.departmentAddress_${department.deptId}"
												value="<c:out value="${department.deptAddress}" />" disabled="true" />
											</td>
											<td class="sorting">
											<a href="javascript:;" onclick="editSingle( ${department.deptId} )">修改 </a> 
											<a href="javascript:;" onclick="delSingle( ${department.deptId} )">删除</a>
										    </td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>