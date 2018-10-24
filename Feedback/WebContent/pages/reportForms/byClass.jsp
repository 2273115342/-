<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script src="resource/js/rolemenu.js" language="javascript" type="text/javascript"></script>
<script type="text/javascript" src="resource/js/updateJs/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resource/js/updateJs/myUtil.js"></script>
<script type="text/javascript" src="resource/js/updateJs/byClass.js"></script>
</head>
<body>
	<div id="main_frame">
		<div id="main_column">
			<div class="mainbox-title" style="margin-bottom: 13px;">
			按班级统计
			</div>
			<div class="mainbox-body" style="border: 6px solid #EBEBEB;border-radius: 6px;padding: 13px 14px;width: 97%;">
				<select name="classId" id="classId">
					<s:iterator value="#request.classes" var="cl" status="st">
						<option value="<s:property value="#cl.classId" />">
							<s:property value="#cl.className" />
						</option>
					</s:iterator>
				</select>
				<input type="button" id="query" value=" 查 询 " />
				<div class="reportForms"></div>
			</div>
		</div>
	</div>
</body>
</html>
