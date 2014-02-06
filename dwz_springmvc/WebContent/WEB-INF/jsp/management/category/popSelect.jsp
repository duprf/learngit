<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/management/category?popSelect=1'/>" onsubmit="return dialogSearch(this)">
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


	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th width="100">编号</th>
				<th>名称</th>
				<th width="100">级别</th>
				<th width="80">查找带回</th>
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
				<td>
				<c:if test="${item.depth eq 2 or item.depth eq 3}">
					<a class="btnSelect" href="javascript:$.bringBack({${empty param.idKey ? 'categoryId' : param.idKey}:'${item.id}', ${empty param.nameKey ? 'categoryName' : param.nameKey}:'${item.sn} ${item.name}'})" title="查找带回">选择</a>
				</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp?targetType=dialog"></c:import>
</div>
