<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/management/publishing/insert?navTabId=publishingLiNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="57">
		<p>
			<label>名称: </label>
			<input type="text" name="name" class="required" maxlength="30"/>
		</p>
		<p>
			<label>区域: </label>
			<select name="region" class="combox required" ref="agencyCombox" refUrl="/management/publishing/agencyList?region={value}">
				<option value="">请选择</option>
				<c:forEach var="item" items="${regionList}">
				<option value="${item}" ${item eq vo.region ? 'selected="selected"' : ''}><fmt:message key="${item.key}" /></option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>权重: </label>
			<input type="text" name="weight" class="number" value="1.0"/>
		</p>
		<p>
			<label>出版机构: </label>
			<select id="agencyCombox" name="agency" class="combox required">
				<option value="">请选择区域</option>
			</select>
		</p>
		<p class="nowrap">
			<label>摘要: </label>
			<textarea name="summary" rows="2" cols="80" maxlength="1000"></textarea>
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
