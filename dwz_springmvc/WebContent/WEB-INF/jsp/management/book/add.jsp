<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/management/book/insert?navTabId=bookLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="57">

		<p>
			<label>ISBN: </label>
			<input type="text" name="sn" class="required" maxlength="20"/>
		</p>
		<p>
			<label>中文书名: </label>
			<input type="text" name="nameCn" class="required" maxlength="100"/>
		</p>
		<p>
			<label>英文书名: </label>
			<input type="text" name="nameEn" maxlength="100"/>
		</p>
		<p>
			<label>一级学科: </label>
			<select name="categoryId" class="required">
				<option value="">请选择</option>
				<c:forEach var="item" items="${topCategories}">
				<option value="${item.id}">${item.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>出版社: </label>
			<input name="publishingId" class="required" value="" type="hidden"/>
			<input name="publishingName" value="" type="text" disabled="disabled" class="readonly"/>
			<a class="btnLook" href="/management/publishing?popSelect=1" lookupGroup="">查找带回</a>
		</p>
		
		<p>
			<label>出版日期: </label>
			<input type="text" name="publishDate" class="date required" readonly="readonly"/>
			<a href="javascript:;" class="inputDateButton">选择</a>
		</p>
		<p class="nowrap">
			<label>介绍: </label>
			<textarea name="description" rows="5" cols="80" maxlength="1000"></textarea>
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
