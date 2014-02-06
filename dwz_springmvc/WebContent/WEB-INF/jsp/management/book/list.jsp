<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/management/book'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>关键词：</label>
				<input type="text" name="keywords" value="${param.keywords}"/>
			</li>
			<li>
				<label>所属机构：</label>
				<select name="publish">
					<option value="">所有</option>
					<c:forEach var="item" items="${publishList}">
					<option value="${item}" ${item.id eq param.publish ? 'selected="selected"' : ''}>${item.name}</option>
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
			<li><a class="add" target="navTab" rel="bookNav" href="<c:url value='/management/book/add'/>" title="添加书目"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="bookNav" href="<c:url value='/management/book/edit/{slt_objId}'/>" title="编辑书目"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/book/delete/{slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" target="navTab" rel="chapterLiNav" href="<c:url value='/management/chapter/list?relativeType=book&relativeId={slt_objId}'/>" title="篇章列表"><span>篇章列表</span></a></li>
			<li><a class="icon" target="dialog" mask="true" href="<c:url value='/management/book/uploadIcon/{slt_objId}'/>" title="上传封面"><span>上传封面</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th width="100" orderField="SN" class="${param.orderField eq 'SN' ? param.orderDirection : ''}">ISBN</th>
				<th orderField="NAME_CN" class="${param.orderField eq 'NAME_CN' ? param.orderDirection : ''}">中文名称</th>
				<th orderField="NAME_EN" class="${param.orderField eq 'NAME_EN' ? param.orderDirection : ''}">英文名称</th>
				<th width="100">出版社</th>
				<th width="100" orderField="PUBLISH_DATE" class="${param.orderField eq 'PUBLISH_DATE' ? param.orderDirection : ''}">出版日期</th>
				<th width="130" orderField="INSERT_DATE" class="${param.orderField eq 'INSERT_DATE' ? param.orderDirection : ''}">创建时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${bookList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.sn}</td>
				<td>${item.nameCn}</td>
				<td>${item.nameEn}</td>
				<td>${item.publishing.name}</td>
				<td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>