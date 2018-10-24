// JavaScript Document
//兼容各种浏览器的获取firstChild的函数
function get_firstChild(node){
	cleanWhitespace(node);
	
	return node.firstChild;
}

//兼容各种浏览器的获取lastChild的函数
function get_lastChild(node){
	cleanWhitespace(node);
	
	return node.lastChild;
}

//兼容各种浏览器的获取nextSibling的函数
function get_nextSibling(node){
	var next = node.nextSibling;
	while (next.nodeType!=1){
		next=next.nextSibling;
	}
	return next;
}

//兼容各种浏览器的获取previousSibling的函数
function get_previousSibling(node){
	var prev = node.previousSibling;
	while (prev.nodeType!=1){
		prev=prev.previousSibling;
	}
	return prev;
}

//去掉Element对象内的所有空白节点
function cleanWhitespace(node){
	var loopIndex;
	for (loopIndex = 0; loopIndex < node.childNodes.length; loopIndex++){
		var currentNode = node.childNodes[loopIndex];
		//如果是元素节点，则遍历该子元素的所有的子节点，用递归检查是否包含白节点
		if (currentNode.nodeType == 1){
				cleanWhitespace(currentNode);
		}
		//如果是文本节点，则检查是否是纯粹的空白节点，如果是，就将它从对象中删除
		if (((/^\s+$/.test(currentNode.nodeValue))) && (currentNode.nodeType == 3)){
			node.removeChild(node.childNodes[loopIndex--]);
		}
	}
} 