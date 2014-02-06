<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/management/company/insert?navTabId=companyLiNav'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="57">

		<p>
			<label>团体名称: </label>
			<input type="text" name="name" class="required" maxlength="50"/>
		</p>
		<p>
			<label>联系人: </label>
			<input type="text" name="contactName" class="required" maxlength="30"/>
		</p>
		<p>
			<label>状态: </label>
			<select name="status">
				<c:forEach var="item" items="${companyStatusList}">
				<c:if test="${item ne 'DELETED'}">
				<option value="${item}">${item}</option>
				</c:if>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>Email: </label>
			<input type="text" name="email" class="required email" maxlength="100"/>
		</p>
		<p>
			<label>电话: </label>
			<input type="text" name="phone" maxlength="30"/>
		</p>
		<p>
			<label>开通日期: </label>
			<input type="text" name="startDate" value="<fmt:formatDate value='${now}' pattern='yyyy-MM-dd'/>" class="required date" readonly="readonly"/>
			<a href="javascript:;" class="inputDateButton">选择</a>
		</p>
		<p>
			<label>终止日期: </label>
			<input type="text" name="expiryDate" class="required date" readonly="readonly"/>
			<a href="javascript:;" class="inputDateButton">选择</a>
		</p>
		<div class="unit">
			<label>团体IP段: </label>
			<textarea name="ipRange" rows="3" cols="80" maxlength="500">${vo.ipRange}</textarea>
			<span class="info">多个段换行(192.168.1.1-192.168.1.100)</span>
		</div>
		<div class="unit">
			<label>备注: </label>
			<textarea name="remark" rows="2" cols="80" maxlength="255"></textarea>
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
