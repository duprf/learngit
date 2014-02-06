<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/management/chapter/list?relativeType=${vo.relativeType}&relativeId=${vo.relativeId}'/>" onsubmit="return navTabSearch(this)">
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
			<li><a class="add" target="navTab" rel="chapterNav" href="<c:url value='/management/chapter/add?relativeId=${vo.relativeId}&relativeType=${vo.relativeType}'/>" title="添加篇章"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="chapterNav" href="<c:url value='/management/chapter/edit/{slt_objId}'/>" title="编辑篇章"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/chapter/delete/{slt_objId}'/>" title="你确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="100" orderField="CHAPTER_NO" class="${param.orderField eq 'CHAPTER_NO' ? param.orderDirection : ''}">篇号</th>
				<th orderField="NAME_CN" class="${param.orderField eq 'NAME_CN' ? param.orderDirection : ''}">中文篇名</th>
				<th orderField="NAME_EN" class="${param.orderField eq 'NAME_EN' ? param.orderDirection : ''}">英文篇名</th>
				<th width="100">起始页</th>
				<th width="100">总页数</th>
				<th width="130" orderField="INSERT_DATE" class="${param.orderField eq 'INSERT_DATE' ? param.orderDirection : ''}">创建时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${chapters}" varStatus="s">
			<tr target="slt_objId" rel="${item.id}">
				<td>${item.chapterNo}</td>
				<td>${item.nameCn}</td>
				<td>${item.nameEn}</td>
				<td>${item.startPageNo}</td>
				<td>${item.pageCount}</td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>
