<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/management/chapter/insert?navTabId=chapterLiNav&callbackType=forwardConfirm'/>" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
	<input type="hidden" name="relativeId" value="${vo.relativeId}"/>
	<input type="hidden" name="relativeType" value="${vo.relativeType}"/>
	<input type="hidden" name="forwardUrl" value="/management/chapter/edit/{chapterId}"/>
	
	<div class="pageFormContent" layoutH="57">

		<p>
			<label>篇号: </label>
			<input type="text" name="chapterNo" class="required alphanumeric" maxlength="20"/>
		</p>
		<p>
			<label>中文篇名: </label>
			<input type="text" name="nameCn" class="required" maxlength="100"/>
		</p>
		<p>
			<label>英文篇名: </label>
			<input type="text" name="nameEn" maxlength="100"/>
		</p>
		<p class="nowrap">
			<label>学科1: </label>
			<input name="categoryName1" value="" type="text" postField="keywords" suggestFields="categoryName1" 
					suggestUrl="/management/category?suggest=1&type=notTop&idKey=categoryId1&nameKey=categoryName1" lookupGroup=""/>
			<a class="btnLook" href="/management/category?popSelect=1&idKey=categoryId1&nameKey=categoryName1" lookupGroup="">查找带回</a>
			<input name="categoryId1" class="required" value="" type="hidden"/>
		</p>
		<p class="nowrap">
			<label>学科2: </label>
			<input name="categoryName2" value="" type="text" postField="keywords" suggestFields="categoryName2" 
					suggestUrl="/management/category?suggest=1&type=notTop&idKey=categoryId2&nameKey=categoryName2" lookupGroup=""/>
			<a class="btnLook" href="/management/category?popSelect=1&idKey=categoryId2&nameKey=categoryName2" lookupGroup="">查找带回</a>
			<input name="categoryId2" value="" type="hidden"/>
		</p>
		<p>
			<label>起始页: </label>
			<input type="text" name="startPageNo" class="required digits"/>
		</p>
		<p>
			<label>总页数: </label>
			<input type="text" name="pageCount" class="required digits"/>
		</p>
		<p>
			<label>PDF: </label>
			<input type="file" name="file" class="required"/>
		</p>
		
		<p class="nowrap">
			<label>摘要: </label>
			<textarea name="summary" rows="3" cols="80" maxlength="1000"></textarea>
		</p>
		
		<p class="nowrap">
			<label>关键词: </label>
			<textarea name="keywords" rows="2" cols="80" maxlength="200"></textarea>
		</p>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>