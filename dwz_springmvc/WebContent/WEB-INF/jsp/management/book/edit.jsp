<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="<c:url value='/management/book/update?navTabId=bookLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="id" value="${book.id}"/>
	<div class="pageFormContent" layoutH="57">
		<p>
			<label>ISBN: </label>
			<input type="text" name="sn" value="${book.sn}" class="required" maxlength="20"/>
		</p>
		<p>
			<label>中文书名: </label>
			<input type="text" name="nameCn" value="${book.nameCn}" class="required" maxlength="100"/>
		</p>
		<p>
			<label>英文书名: </label>
			<input type="text" name="nameEn" value="${book.nameEn}" maxlength="100"/>
		</p>
		<p>
			<label>一级学科: </label>
			<select name="categoryId" class="required">
				<option value="">请选择</option>
				<c:forEach var="item" items="${topCategories}">
				<option value="${item.id}" ${item.id eq book.categoryId ? 'selected="selected"' : ''}>${item.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>出版社: </label>
			<input name="publishingId" class="required" value="${book.publishingId}" type="hidden"/>
			<input name="publishingName" value="${book.publishing.name}" type="text" disabled="disabled" class="readonly"/>
			<a class="btnLook" href="/management/publishing?popSelect=1" lookupGroup="">查找带回</a>
		</p>
		<p>
			<label>出版日期: </label>
			<input type="text" name="publishDate" class="date required" readonly="readonly" value="<fmt:formatDate value="${book.publishDate}" pattern="yyyy-MM-dd"/>"/>
			<a href="javascript:;" class="inputDateButton">选择</a>
		</p>
		<p>
			<label>创建时间: </label>
			<fmt:formatDate value="${book.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</p>
		<p>
			<label>修改时间: </label>
			<fmt:formatDate value="${book.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</p>
		<p class="nowrap">
			<label>介绍: </label>
			<textarea name="description" rows="5" cols="80" maxlength="1000">${book.description}</textarea>
		</p>
		
		<c:if test="${!empty book.iconUrl}">
		<div class="unit">
			<label>封面: </label>
			<img alt="${book.nameCn}" src="${book.iconUrl}" />
		</div>
		</c:if>
	
	</div>

	<div class="formBar">
		<ul>
			<li><a class="button" target="navTab" rel="chapterLiNav" href="/management/chapter/list?relativeType=book&relativeId=${book.id}" title="篇章列表"><span>篇章列表</span></a></li>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>