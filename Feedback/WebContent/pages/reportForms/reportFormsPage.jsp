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
<style type="text/css">
.outBorder{
	position: relative;
	height:126px;
	margin:0px 5px;
	border: 1px solid black;
	border-right: none;
}
.avgScore{
	position:absolute;
	bottom:0px;
	display:inline-block;
	height:0px;
	width:80px;
	background-color:#CAE1FF;
	transition:height 2s;
}
.maxScore{
	height:126px;
	position: relative;
	display: inline-block;
}
.avgScoreIndividual{
	display: inline-block;
	margin:0px 10px;
	width: 11%;
}
.avgScoreText{
	position: absolute;
	bottom: 50%;
	z-index: 10;
}
.fiName{
	position:absolute;
	bottom:-16px;
	display:inline-block;
	width:11%;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}
</style>
</head>
<body>
	<div>
		<s:iterator value="#request.feedbacks" var="fb">
			<div>
				<div style="border: 2px solid #EBEBEB;border-radius: 6px;padding: 30px 14px;">
					<h4>
						<s:property value="#fb.feedbackName" />
						<s:if test="#fb.status==1">(该反馈正在进行，数据可能不完全)</s:if>
					</h4>
					<div>
						<div class="outBorder">
							<s:iterator value="#request.reportFormsList" var="rfl" status="sts">
									<s:if test="#fb.feedbackId==#rfl.feedbackId">
										<div class="avgScoreIndividual">
												<div class="maxScore">
													<span class="avgScoreText"><s:property value="#rfl.avgScore" /></span>
													<span class="avgScore" imgHeight=<s:property value="#rfl.avgScore*10" />%
													avgScore="<s:property value="#rfl.avgScore" />"></span>
												</div>
											<span class="fiName" title='<s:property value="#rfl.fiName" />'>
												<s:property value="#rfl.fiName" />
											</span>
										</div>
									</s:if>
							</s:iterator>
						</div>
					</div>
				</div>
			</div>
		</s:iterator>
	</div>
<s:if test="#request.byClass!=null">
	<script type="text/javascript">
		$(".avgScore").each(function(){
			$(this).height($(this).attr("imgHeight"));
			$(this).removeAttr("imgHeight");
		});
		var x = 10;
		var y = 20; 
		$(".avgScore").mouseover(function(event){
			var avgScore = "<div class='title' style='position:absolute;background-color: white;font-size:24px;'>"+$(this).attr("avgScore")+"</div>";
			$("body").append(avgScore);	//把它追加到文档中
			$(".title").css({
				"top": (event.pageY+20) + "px",
				"left": (event.pageX+10)  + "px"
			}).show();	  //设置x坐标和y坐标，并且显示
	    }).mouseout(function(){
			$(".title").remove();   //移除
	    }).mousemove(function(e){
			$(".title").css({
				"top": (e.pageY+y) + "px",
				"left": (e.pageX+x)  + "px"
			});
		});
	</script>
</s:if>
</body>
</html>
