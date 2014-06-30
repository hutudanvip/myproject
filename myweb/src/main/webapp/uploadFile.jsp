<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>上传单个文件</title>
</head>
<body>
	<s:form action="uploadFile" namespace="/mystruts" enctype="multipart/form-data">
		<s:file name="upload" label="请选择要上传的文件"/>
		<s:submit value="上传" />
	</s:form>
</body>
</html>