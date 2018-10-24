$(function(){
	/**
	 * 左侧小菜单所对应的特效
	 */
	$(".menu").each(function() {
		$(this).unbind('click').on("click",function(){
			changClass(".menu","pitchOn","notSelected");
			changClass(this,"notSelected","pitchOn");
			setlis($(this).attr("adderss"),$(this).attr("mid"),$(this).text());
		});
	});
	/**
	 * 左侧大菜单所对应的特效
	 */
	$(".adminleftmenu").each(function(index){
		$(this).on("click",function(){
			if(!$(".adminleftsubmenu").eq(index).is(":hidden")){
				$(".adminleftsubmenu").hide();
			}else{
				$(".adminleftsubmenu").hide();
				$(".adminleftsubmenu").eq(index).show();	
			}
		});
	});
	
	/**
	 * 点击左侧链接后 所要做出的响应
	 */
	function setlis(href,mid,frameName){
		if($(".iframeName",parent.document).children(".pageInp").length<=15){
			var frame = '<iframe class="son" src="'+href+'" mid="'+mid+'" frameborder="0" style="height: 1000px;width: 100%;"></iframe>';
			var iframeName = '<div class="pageInp pitchOnIframeName" mid="'+mid+'">'
									+'<span class="sonPageName">'+frameName+'</span>'
									+'<span class="delete">X</span>'
							+'</div>';
			sonPageHide(".rightPage","#mainPage,.son");
			$(".iframeName",parent.document).children(".pageInp").removeClass("pitchOnIframeName");
			$(".son:last" , parent.document).after(frame);
			$(".iframeName", parent.document).append(iframeName); //bug 第一次添加出现空白节点
			cleanWhitespace(window.parent.document.getElementById('iframeName')); //去除空白节点 该方法为js的方法
			if($(".iframeName",parent.document).children(".iframeName div").length<=7){
				$(".iframeName",parent.document).children(".iframeName div").width("10%");
			}else{
				//经测试 最小宽度为4% 合适   最大宽度为10%合适
				var wid = (10-((10-4)*$(".iframeName",parent.document).children(".iframeName div").length/15))/100;
				wid = $(".iframeName",parent.document).width()*wid;
				$(".iframeName",parent.document).children(".iframeName div").width(wid);
			}
			//更新节点
			deleteIframe();
		}else{
			$(".iframeName",parent.document).append("<div class='pagetoomush' style='position: fixed;top:20%;left: 35%;" +
					"color:red;background-color: white;border: 1px solid #CCC;padding: 10px;font-size: 16px;'>亲！打开的页面有点多哦！先关闭一些吧！</div>");
			$(".iframeName",parent.document).children(".pagetoomush").animate({
				opacity:'0',
			},2000,function(){
				$(this).remove();
			});
		}
	}
	
	/**
	 * 关闭所有打开的页面
	 */
	$(".rightPage",parent.document).children(".closeAll").on("click",function(){
		$(".iframeName",parent.document).children(".pageInp[mid!='0']").remove(); //删除所有除了主页的小菜单
		$(".rightPage",parent.document).children("iframe[mid!='0']").remove();  //删除所有除了主页的iframe
		sonChangeClass(".iframeName",".pageInp[mid='0']","notSelectedIframeName","pitchOnIframeName"); 
		sonPageShow(".rightPage", "#mainPage"); //显示主页
	});
	
	
	function deleteIframe(){
		$(".iframeName",parent.document).children(".pageInp").each(function() {
			$(this).unbind('mouseover').mouseover(function(event){
				event.stopPropagation();	//阻止冒泡
				var mid = $(this).attr("mid");
				//删除以打开的页面
				$(this).parent().children(".pageInp[mid='"+mid+"']").each(function(index){
					$(this).children(".delete").unbind('click').on("click",function(){
						$(".iframeName",parent.document).children(".pageInp[mid='"+mid+"']").eq(index).remove();
						$(".rightPage",parent.document).children("iframe[mid='"+mid+"']").eq(index).remove();
						//如果删除的是正在显示的页面  则删除后打开最后一个页面
						if($(this).closest(".pageInp").attr("class").indexOf('pitchOnIframeName')!=-1){
							sonChangeClass(".iframeName",".pageInp:last","notSelectedIframeName","pitchOnIframeName"); //选中右侧最后一个小菜单
							sonPageShow(".rightPage", ".son:last");  //显示最后一个页面
						}
						//改变宽度
						if($(".iframeName",parent.document).children(".iframeName div").length<=7){
							$(".iframeName",parent.document).children(".iframeName div").width("10%");
						}else{
							//经测试 最小宽度为4% 合适   最大宽度为10%合适
							var wid = (10-((10-4)*$(".iframeName",parent.document).children(".iframeName div").length/15))/100;
							wid = $(".iframeName",parent.document).width()*wid;
							$(".iframeName",parent.document).children(".iframeName div").width(wid);
						}
						//如果没有打开的页面了，则打开第一个页面
						if($(".iframeName",parent.document).children(".pageInp").length<=1){
							sonChangeClass(".iframeName",".pageInp[mid='0']","notSelectedIframeName","pitchOnIframeName"); //显示主页
							sonPageShow(".rightPage", "#mainPage");
							return true;
						}
					});
					//点击右侧小菜单打开页面
					$(this).unbind('click').on("click",function(){
						if(mid==0){
							//打开首页  隐藏其他页面
							sonPageHide(".rightPage",".son");
							sonPageShow(".rightPage", "#mainPage");
							$(".iframeName",parent.document).children(".pageInp").removeClass("pitchOnIframeName");
							$(this).addClass("pitchOnIframeName");
						}else{
							//更改选中页面的小菜单的样式
							$(".iframeName",parent.document).children(".pageInp").removeClass("pitchOnIframeName");
							$(this).addClass("pitchOnIframeName");
							sonChangeClass
							//隐藏其他页面 显示选中的页面
							sonPageHide(".rightPage","#mainPage,.son");
							$(".rightPage",parent.document).children(".son[mid='"+mid+"']").eq(index).show();
						}
					});
					
				});
			});
		});
	}
});