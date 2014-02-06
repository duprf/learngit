<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/management/author/insert?navTabId=authorLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="56">
		<p>
			<label>编码: </label>
			<input type="text" name="sn" class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>
		<p>
			<label>姓名: </label>
			<input type="text" name="name" class="required" maxlength="30"/>
		</p>
		<p>
			<label>区域: </label>
			<select name="region" class="required">
				<option value="">请选择</option>
				<c:forEach var="item" items="${regionList}">
				<option value="${item}" ${item eq vo.region ? 'selected="selected"' : ''}><fmt:message key="${item.key}" /></option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>学科: </label>
			<input name="categoryId" class="required" value="" type="hidden"/>
			<input name="categoryName" type="text" postField="keywords" suggestFields="categoryName" 
					suggestUrl="/management/category?suggest=1&type=notTop" lookupGroup=""/>
			<a class="btnLook" href="/management/category?popSelect=1" lookupGroup="">查找带回</a>
		</p>
		<p>
			<label>研究领域: </label>
			<input type="text" name="summary" maxlength="100"/>
		</p>
		<p class="nowrap">
			<label>介绍: </label>
			<textarea name="description" rows="3" cols="80" maxlength="1000"></textarea>
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
