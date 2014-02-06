<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/management/chapter/lookupAuthorizer'/>" onsubmit="return dialogSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>授权人类型：</label>
				<select name="authorizerRelativeType">
					<c:forEach var="item" items="${authorizerRelativeTypeList}">
					<option value="${item}" ${item eq param.authorizerRelativeType ? 'selected="selected"' : ''}>${item}</option>
					</c:forEach>
				</select>
			</li>
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
				<th width="100">授权人类型</th>
				<th>名称</th>
				<th width="80">查找带回</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${authorizerList}" varStatus="s">
			<tr>
				<td>${s.index + 1}</td>
				<td>${param.authorizerRelativeType}</td>
				<td>${item.name}</td>
				<td><a class="btnSelect" href="javascript:$.bringBack({relativeId:'${item.id}', relativeType:'${param.authorizerRelativeType}', name:'${item.name}'})" title="查找带回">选择</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp?targetType=dialog"></c:import>
</div>
