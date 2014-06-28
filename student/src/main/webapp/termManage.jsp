<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all-gray.css" />
<script type="text/javascript" src="extjs/ext-all.js"></script>
<script type="text/javascript" src="extjs/ext-lang-zh_CN.js"></script>

<script type="text/javascript" src="js/studentModel.js"></script>
<script type="text/javascript" src="js/studentStore.js"></script>
<script type="text/javascript" src="js/termForm.js"></script>
<script type="text/javascript" src="js/termGrid.js"></script>

<link rel="stylesheet" type="text/css" href="css/student.css">

</head>
<body>
	<script type="text/javascript">
 	Ext.onReady(function(){
		var panel=new Ext.Panel({
			renderTo : Ext.getBody(),
			//width:1200,
			headerAsText:true,
			//height:750,
			//layout:"vbox",
			align: 'stretch',
			padding:'10 130 10 10',
			frame:true,
		    items:[term_grid]
		});
		
	}); 
	
	</script>
</body>
</html>