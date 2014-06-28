<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="<s:url value="/styles/styles.css"/>">
<html>
<head>
<title>struts2验证框架</title>
</head>
<body>
	<s:form action="validate" namespace="/mystruts">
		<s:textfield name="msg" label="姓名" />
		<s:textfield name="age" label="年龄" />
		<s:submit />
	</s:form>
</body>
</html>