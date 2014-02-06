<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/management/author?popSelect=1'/>" onsubmit="return dialogSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>关键词：</label>
				<input type="text" name="keywords" value="${param.keywords}"/>
			</li>
		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">

	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th width="100">代码</th>
				<th width="100">姓名</th>
				<th width="100">地区</th>
				<th width="200">学科</th>
				<th>研究领域</th>
				<th width="80">查找带回</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${authorList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.sn}</td>
				<td>${item.name}</td>
				<td><fmt:message key="${item.region.key}" /></td>
				<td>${item.category.name}</td>
				<td>${item.summary}</td>
				<td><a class="btnSelect" href="javascript:$.bringBack({${param.lookupPk}:'${item.id}', authorName:'${item.name}'})" title="查找带回">选择</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp?targetType=dialog"></c:import>
</div>
