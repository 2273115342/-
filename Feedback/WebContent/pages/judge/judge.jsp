<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ include file="../util/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link href="resource/css/new_style.css" rel="stylesheet" type="text/css" />
<script src="resource/js/judge.js" language="javascript"
	type="text/javascript"></script>
</head>


<body>
	<form name="frmAction" id="frmAction" method="post" action="list">
		<input name="id" type="hidden" id="id" value="0" />

		<div id="main_frame">
			<div id="main_column">

				<div>
					<div class="mainbox-title-container">
						<div class="mainbox-title">评分管理</div>
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
														type="button" onclick="del()" value=" 删 除 " />
													</td>
												</tr>
											</table>

											<table width="100%" border="0" cellpadding="3" cellspacing="1">
													<tr align="center">
														<td></td>
														<td height="20">理论/实践</td>
														<td>要 求</td>
														<td>基本分</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">理论授课</td>
														<td align="center">为人师表，关心学生，要求严格</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">理论授课</td>
														<td align="center">仪表端庄，情绪饱满，认真负责</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">理论授课</td>
														<td align="center">按时上下课，课前准备充分</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">理论授课</td>
														<td align="center">讲授语言清晰、流畅、简洁；语调抑扬顿挫、语速适中</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">理论授课</td>
														<td align="center">关心学生，严格要求、认真负责</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">理论授课</td>
														<td align="center">能合理、高效组织实践课程，兼顾整个班级</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">理论授课</td>
														<td align="center">实践内容和理论紧密结合、难度和数量适中</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">上机实践</td>
														<td align="center">为人师表，关心学生，要求严格</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">上机实践</td>
														<td align="center">仪表端庄，情绪饱满，认真负责</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">上机实践</td>
														<td align="center">按时上下课，课前准备充分</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">上机实践</td>
														<td align="center">讲授语言清晰、流畅、简洁；语调抑扬顿挫、语速适中</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">上机实践</td>
														<td align="center">关心学生，严格要求、认真负责</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">上机实践</td>
														<td align="center">能合理、高效组织实践课程，兼顾整个班级</td>
														<td align="center">10</td>
													</tr>
													<tr class="vieworder_row">
														<td align="center"><input type="checkbox" name="selall" onclick="selectAll(this)" /></td>
														<td align="center">上机实践</td>
														<td align="center">实践内容和理论紧密结合、难度和数量适中</td>
														<td align="center">10</td>
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
