<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<select name="${param.inputName}">
	<c:forEach var="item" items="${authorTypeList}">
	<option value="${item}">${item.name}</option>
	</c:forEach>
</select>