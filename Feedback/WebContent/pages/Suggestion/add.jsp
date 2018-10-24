<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="resource/css/new_style.css" rel="stylesheet"
	type="text/css" />	
<script type="text/javascript" src="resource/js/updateJs/jquery-3.2.1.min.js"></script>
</head>
<body>
	<form name="frmAction" id="frmAction" method="post" action="suggestionAction_save">
		<div id="main_frame">
			<div id="main_column">
				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">个人建议添加</div>
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
														<select name="usersByTeacherId" id="user.sex">
															<s:iterator value="#request.teachersList" var="teachList" status="st">
																<option value="<s:property value="#teachList.userId" />">
																	<s:property value="#teachList.name" />
																</option>
															</s:iterator>
														</select>
													</td>
													<td>
														${message }
													</td>
												</tr>
												<tr>
													<td height="25px" align="right" >个人建议&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
													<td colspan="2">
														<textarea rows="5" cols="30" name="suggestionText"></textarea>
														<span class="info1"></span>
													</td>
												</tr>
												<tr>
													<td colspan="3">
														<p align="center" /> <br />
														<input id="save" type="submit" value=" 保 存 " /> 
														<input type="button" value=" 返 回 " onclick='javascript: history.go(-1)' />
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
<script type="text/javascript">
	$(function(){
		var maxlen = 60;
		$("textarea[name='suggestionText']").bind("input propertychange",function(){
			$(".info1").html("你还能输入"+(maxlen-$("textarea[name='suggestionText']").val().length)+"字");
			if(maxlen-$("textarea[name='suggestionText']").val().length<=0){
				alert("输入的字已经上限");
			}
		});
		$("#save").on("click",function(){
			if($("textarea[name='suggestionText']").val().trim().length==0||$("textarea[name='suggestionText']").val().trim().length==null){
				alert("请输入建议内容");
				return false;
			}
			if(maxlen-$("textarea[name='suggestionText']").val().trim().length<0){
				alert("输入的字已经上限");
				return false;
			}
		});
	});
</script>
</body>
</html>
