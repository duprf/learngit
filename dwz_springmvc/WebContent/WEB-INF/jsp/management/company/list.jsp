<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/management/company'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>关键词：</label>
				<input type="text" name="keywords" value="${param.keywords}"/>
			</li>
			<li>
				<label>状态：</label>
				<select name="status">
					<option value="">全部</option>
					<c:forEach var="item" items="${companyStatusList}">
					<c:if test="${item ne 'DELETED'}">
					<option value="${item}" ${item eq param.status ? 'selected="selected"' : ''}>${item}</option>
					</c:if>
					</c:forEach>
				</select>
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
			<li><a class="add" target="navTab" rel="companyNav" href="<c:url value='/management/company/add'/>" title="添加团体"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="companyNav" href="<c:url value='/management/company/edit/{slt_objId}'/>" title="编辑团体"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/company/delete/{slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th>团体名称</th>
				<th width="100">联系人</th>
				<th>Email</th>
				<th width="100">电话</th>
				<th width="100">终止日期</th>
				<th width="130">创建时间</th>
				<th width="100">状态</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${companyList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id}">
				<td>${s.index + 1}</td>
				<td>${item.name}</td>
				<td>${item.contactName}</td>
				<td>${item.email}</td>
				<td>${item.phone}</td>
				<td><fmt:formatDate value="${item.expiryDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${item.status}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>