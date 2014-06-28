<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>显示代数和</title>
</head>
<body>
	求代数和
	<br>
	<s:form action="sum" namespace="/mystruts">
		<s:textfield name="operate1" label="操作数1"></s:textfield>
		<s:textfield name="operate2" label="操作数2"></s:textfield>
		<s:submit value="代数和"></s:submit>
	</s:form>
</body>
</html>