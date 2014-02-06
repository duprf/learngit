<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
[
	["","请选择"],
	<c:forEach var="item" items="${categoryList}" varStatus="s">
	["${item.id}", "<c:out value='${item.name}'/>"]<c:if test="${!s.last}">,</c:if>
	</c:forEach>
]