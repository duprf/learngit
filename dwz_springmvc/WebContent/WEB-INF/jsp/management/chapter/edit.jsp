<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="<c:url value='/management/chapter/update?navTabId=chapterLiNav'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="id" value="${chapter.id}"/>
	<div class="pageFormContent" layoutH="57">
		
		<p>
			<label>篇号: </label>
			<input type="text" name="chapterNo" value="${chapter.chapterNo}" class="required alphanumeric" maxlength="20"/>
		</p>
		<p>
			<label>中文篇名: </label>
			<input type="text" name="nameCn" value="${chapter.nameCn}" class="required" maxlength="100"/>
		</p>
		<p>
			<label>英文篇名: </label>
			<input type="text" name="nameEn" value="${chapter.nameEn}" maxlength="100"/>
		</p>

		<p class="nowrap">
			<label>学科1: </label>
			<input name="categoryId1" class="required" value="${chapter.categoryId1}" type="hidden"/>
			<input name="categoryName1" value="${chapter.category1.name}" type="text" postField="keywords" suggestFields="categoryName1" 
					suggestUrl="<c:url value='/management/category?suggest=1&type=notTop&idKey=categoryId1&nameKey=categoryName1'/>" lookupGroup=""/>
			<a class="btnLook" href="<c:url value='/management/category?popSelect=1&idKey=categoryId1&nameKey=categoryName1'/>" lookupGroup="">查找带回</a>
		</p>
		<p class="nowrap">
			<label>学科2: </label>
			<input name="categoryId2" value="${chapter.categoryId2}" type="hidden"/>
			<input name="categoryName2" value="${chapter.category2.name}" type="text" postField="keywords" suggestFields="categoryName2" 
					suggestUrl="<c:url value='/management/category?suggest=1&type=notTop&idKey=categoryId2&nameKey=categoryName2'/>" lookupGroup=""/>
			<a class="btnLook" href="<c:url value='/management/category?popSelect=1&idKey=categoryId2&nameKey=categoryName2'/>" lookupGroup="">查找带回</a>
		</p>
		<p>
			<label>起始页: </label>
			<input type="text" name="startPageNo" value="${chapter.startPageNo}" class="required digits"/>
		</p>
		<p>
			<label>总页数: </label>
			<input type="text" name="pageCount" value="${chapter.pageCount}" class="required digits"/>
		</p>
		<p>
			<label>创建时间: </label>
			<fmt:formatDate value="${chapter.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</p>
		<p>
			<label>修改时间: </label>
			<fmt:formatDate value="${chapter.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</p>

		<p class="nowrap">
			<label>摘要: </label>
			<textarea name="summary" rows="3" cols="80" maxlength="1000">${chapter.summary}</textarea>
		</p>
		
		<p class="nowrap">
			<label>关键词: </label>
			<textarea name="keywords" rows="2" cols="80" maxlength="200">${chapter.keywords}</textarea>
		</p>
		
		<div class="divider"></div>
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li class="selected"><a href="javascript:void(0)"><span>著作人</span></a></li>
						<li><a href="javascript:void(0)"><span>授权人</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<div>
					<table class="list nowrap itemDetail" width="100%" addButton="添加">
						<thead>
							<tr>
								<th type="text" fieldClass="required digits" name="authorList[#index#].sequence" defaultVal="#index#" size="12">次序</th>
								<th type="enum" fieldClass="required" name="authorList[#index#].type" enumUrl="<c:url value='/management/author/authorTypeSelect'/>">著作人类型</th>
								<th type="lookup" fieldClass="required disabled" fieldAttrs="{disabled:'disabled'}" name=authorList[#index#].authorName size="12" lookupPk="id" lookupGroup="authorList[#index#]" lookupUrl="<c:url value='/management/author?popSelect=1&lookupPk=id'/>">著作人名称</th>
								<th type="del" width="60">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="author" items="${chapter.authorList}" varStatus="s">
							<input type="hidden" name="authorList[${s.index}].id" value="${author.id}"/>
							<tr>
								<td>
									<input type="text" name="authorList[${s.index}].authorSequence" value="${s.index+1}" class="required digits" size="12"/>
								</td>
								<td>
									<select name="authorList[${s.index}].authorType">
										<c:forEach var="item" items="${authorTypeList}">
										<option value="${item}" ${item eq author.authorType ? 'selected="selected"' : ''}>${item.name}</option>
										</c:forEach>
									</select>
								</td>
								<td>
									<input type="text" name="authorList[${s.index}].name" value="${author.name}" size="12" disabled="disabled" class="readonly"/>
									<a class="btnLook" href="<c:url value='/management/author?popSelect=1&lookupPk=id'/>" lookupGroup="authorList[${s.index}]">查找带回</a>
								</td>
								<td><a href="javascript:" class="btnDel"></a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<div>
					<table class="list nowrap" width="100%">
						<thead>
							<tr>
								<th></th>
								<th>授权人类型</th>
								<th>授权人名称</th>
								<th width="60">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach begin="0" end="3"  varStatus="s">
							<input type="hidden" name="authorizerList[${s.index}].id" value="${chapter.authorizerList[s.index].id}"/>
							<input type="hidden" name="authorizerList[${s.index}].relativeId" value="${chapter.authorizerList[s.index].relativeId}"/>
							<input type="hidden" name="authorizerList[${s.index}].sequence" value="${s.index+1}"/>
							<tr>
								<td>
									第${s.index+1}授权人
								</td>
								<td>
									<input type="text" name="authorizerList[${s.index}].relativeType" value="${chapter.authorizerList[s.index].relativeType}" size="12" class="readonly" readonly/>
								</td>
								<td>
									<input type="text" name="authorizerList[${s.index}].name" value="${chapter.authorizerList[s.index].name}" disabled="disabled" class="readonly"/>
									<a class="btnLook" href="<c:url value='/management/chapter/lookupAuthorizer?authorizerRelativeType=author'/>" lookupGroup="authorizerList[${s.index}]">查找带回</a>
								</td>
								<td><a href="javascript:" onclick="$(this).parents('tr:first').find(':input').val('')" class="btnDel"></a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>
		<div class="divider"></div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>

</div>