<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="<c:url value='/management/category/insert?navTabId=categoryLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<input type="hidden" name="pid" value="${parentCategory.id}"/>
	<div class="pageFormContent" layoutH="57">
		<p class="nowrap">
			<label>编号: </label>
			<input type="text" name="sn" class="required" maxlength="20"/>
		</p>
		<p class="nowrap">
			<label>父级分类: </label>
			<span class="unit">${parentCategory.name}</span>
		</p>
		<p class="nowrap">
			<label>名称: </label>
			<input type="text" name="name" class="required"/>
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