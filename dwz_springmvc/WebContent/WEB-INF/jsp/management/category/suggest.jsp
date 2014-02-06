<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
[
	<c:forEach var="item" items="${categoryList}" varStatus="s">
	{"${empty param.idKey ? 'categoryId' : param.idKey}":"${item.id}", "${empty param.nameKey ? 'categoryName' : param.nameKey}":"${item.sn} ${item.name}"}<c:if test="${!s.last}">,</c:if>
	</c:forEach>
]