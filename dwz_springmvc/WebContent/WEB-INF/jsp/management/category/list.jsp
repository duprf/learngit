<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/management/category'/>" onsubmit="return navTabSearch(this)">
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

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" mask="true" href="<c:url value='/management/category/add?pid={slt_objId}'/>" warn="请选择父级分类" title="添加分类"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" mask="true" href="<c:url value='/management/category/edit/{slt_objId}'/>" title="编辑分类"><span>编辑</span></a></li>
			<!-- <li><a class="delete" target="ajaxTodo" href="<c:url value='/management/category/delete/{slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li> -->
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100">编号</th>
				<th>名称</th>
				<th width="100">级别</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${categoryList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${item.sn}</td>
				<td>
					<c:forEach begin="1" end="${item.depth-1}">　</c:forEach>
					${item.name}
				</td>
				<td>${item.depth}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>