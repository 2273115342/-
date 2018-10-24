/*此js文件封装了页面经常使用的各种方法*/
/**
 * 改变文本框得到和失去焦点的样式
 * id:空间的标识属性
 * classes:得到焦点所对应样式
 */
function inpFocal(id,classes){
	$(id).focus(function(){
		$(id).addClass(classes);
	});
	$(id).blur(function(){
		$(id).removeClass(classes);
	});
}
/**
 * 判断文本框是否有值
 * @param id 控件的标识属性
 * @param errorContent 如果没有值，则提示的内容
 * @param top 提示消息距离浏览器上边距离(单位为%)
 * @param left 提示消息距离浏览器左边距离(单位为%)
 * @returns {Boolean} 有值返回ture 无值返回false
 */
function inpValue(id,errorContent,top,left){
	if($(id).val().trim()==""||$(id).val().trim().length<=0){
		popUpMessage(id, errorContent, 2000, top, left);
		$(id).focus();
		return false;
	}
	return true;
}
/**
 * 隐藏父页面的子页面的元素
 * @param fatherPageId 父页面的id
 * @param sonId 子元素的id
 */
function sonPageHide(fatherPageId,sonId){
	$(fatherPageId,parent.document).children(sonId).hide();
}
/**
 * 显示父页面的子页面的元素
 * @param fatherPageId 父页面的id
 * @param sonId 子元素的id
 */
function sonPageShow(fatherPageId,sonId){
	$(fatherPageId,parent.document).children(sonId).show();
}

/**
 * 获得给定元素父亲节点的兄弟节点
 * @param id 给定的元素
 * @param brothers 父元素的兄弟节点
 * @param index 第几个兄弟节点
 * @returns 所找到的父亲兄弟节点的内容test()
 */
function findFatherBrothers(id,brothers,index){
	return $(id).closest(brothers).siblings().eq(index).text();
}

/**
 * 改变选中的子页面class样式 (如果不要删除、增加css或者选中子元素，请传入空字符串)
 * @param fatherId 父页面的Id(标识)
 * @param sonElement 要更改的子页面元素的标识
 * @param removeClassName 要删除的class样式的名称
 * @param addClassName 要增加的class样式的名称
 */
function sonChangeClass(fatherId,sonElement,removeClassName,addClassName){
	if(sonElement.length>0&&sonElement!=null){
		if(removeClassName.length>0&&removeClassName!=null){
			$(fatherId,parent.document).children(sonElement).removeClass(removeClassName);
		}
		if(addClassName.length>0&&addClassName!=null){
			$(fatherId,parent.document).children(sonElement).addClass(addClassName);
		}
	}else{
		if(removeClassName.length>0&&removeClassName!=null){
			$(fatherId,parent.document).removeClass(removeClassName);
		}
		if(addClassName.length>0&&addClassName!=null){
			$(fatherId,parent.document).addClass(addClassName);
		}
	}
}

/**
 * 改变选中元素的样式
 * @param elementId 选中元素的id
 * @param removeCLassName 要删除的class样式的名称
 * @param addClassName 要增加的class样式的名称
 */
function changClass(elementId,removeCLassName,addClassName){
	if(removeCLassName.length>0&&removeCLassName!=null){
		$(elementId).removeClass(removeCLassName);
	}
	if(addClassName.length>0&&addClassName!=null){
		$(elementId).addClass(addClassName);
	}
}

/**
 * 给Array新增一个名为removeByValue方法
 * 如果传入的值在该数组中存在
 * 则会删除该值在数组中第一次出现位置的元素
 * @param val 指定的值
 */
Array.prototype.removeByValue = function(val) {
    for(var i=0; i<this.length; i++) {
        if(this[i] == val) {
            this.splice(i, 1);
            break;
        }
    }
};

/**
 * 在指定的元素后添加一个提示框信息,
 * @param afterWhatAddId 在哪个元素后添加
 * @param promptMessage  提示的信息
 * @param displayTime 要显示的时长(毫秒为单位)
 * @param top 距离浏览器上边距离(%为单位)
 * @param left 距离浏览器左边距离(%为单位)
 * @param father (true or false)是不是在子页面控制父页面
 */
function popUpMessage(afterWhatAddId,promptMessage,displayTime,top,left,father){
	if(father){
		$(afterWhatAddId).after("<div class='pagetoomush' style='position: fixed;top:"+top+"%;left: "+left+"%;" +
			"color:red;background-color: white;border: 1px solid #CCC;padding:40px 80px;font-size: 16px;'>"+promptMessage+"</div>");
		$(".pagetoomush",parent.document).animate({
			opacity:'0',
			top:'0%',
		},displayTime,function(){
			$(this).remove();
		});
	}else{
		$(afterWhatAddId).after("<div class='pagetoomush' style='position: fixed;top:"+top+"%;left: "+left+"%;" +
			"color:red;background-color: white;border: 1px solid #CCC;padding:40px 80px;font-size: 16px;'>"+promptMessage+"</div>");
		$(".pagetoomush").animate({
			opacity:'0',
			top:'0%',
		},displayTime,function(){
			$(this).remove();
		});
	}
}
/**
 * 加载动画
 * @param afterWhatAddId 在哪个元素后添加
 * @param top 距离浏览器上边距离(%为单位)
 * @param left 距离浏览器左边距离(%为单位)
 * @param size 加载动画的大小
 * @returns 动画元素的class
 */
function loadingFlash(afterWhatAddId,top,left,size){
	var classId = "loading";
	$(afterWhatAddId).after("<img class='"+classId+"' src='resource/images/cs/loading.gif' style='z-index:50;position: fixed;top:"+top+"%;left: "+left+"%;'"+
			"height="+size+" alt='正在加载...'/>");
	return "."+classId;
}