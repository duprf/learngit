<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="<c:url value='/management/book/doUploadIcon/${book.id}'/>" class="required-validate pageForm" enctype="multipart/form-data" onsubmit="return iframeCallback(this, dialogAjaxDone);">
	
	<div class="pageFormContent" layoutH="57">
		<div class="unit">
			<label>上传封面(150*215): </label>
			<input type="file" name="file" />
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">上传</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close" >关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>