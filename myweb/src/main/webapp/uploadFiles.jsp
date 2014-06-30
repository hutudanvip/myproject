<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>上传多个文件</title>
	<script type="text/javascript">
		function addComponent() {
			var uploadHTML = document
					.createElement("<input type='file'  name='uploads'/>");
			document.getElementById("files").appendChild(uploadHTML);
			uploadHTML = document.createElement("<p/>");
			document.getElementById("files").appendChild(uploadHTML);
		}
	</script>
</head>

<body>

	<input type="button" onclick="addComponent();" value="添加文件"/>
	<br>
	<form onsubmit="return true;" action="/myweb/mystruts/uploadFiles.action" method="post"
		enctype="multipart/form-data">
		<span id="files">
			<input type='file' name='uploads' />
            <p/>
		</span>
		<input type="submit" value="上传" />
	<form>
</body>
</html>