<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/management/author'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>区域：</label>
				<select name="status">
					<option value="">全部</option>
					<c:forEach var="item" items="${regionList}">
					<option value="${item}" ${item eq param.region ? 'selected="selected"' : ''}>${item}</option>
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

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab" rel="authorNav" href="<c:url value='/management/author/add'/>" title="添加作者"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="authorNav" href="<c:url value='/management/author/edit/{slt_objId}'/>" title="编辑作者"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/author/delete/{slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th width="100">代码</th>
				<th width="100">姓名</th>
				<th width="100">地区</th>
				<th width="200">学科</th>
				<th>研究领域</th>
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
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>