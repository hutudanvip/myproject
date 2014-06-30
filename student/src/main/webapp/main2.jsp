<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统</title>
<link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all-gray.css" />
<script type="text/javascript" src="extjs/ext-all.js"></script>
<script type="text/javascript" src="extjs/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="extjs/StatusBar.js"></script>
<script type="text/javascript" src="extjs/TabCloseMenu.js"></script>

<script type="text/javascript" src="js/studentModel.js"></script>
<script type="text/javascript" src="js/studentStore.js"></script>
<script type="text/javascript" src="js/studentForm.js"></script>
<script type="text/javascript" src="js/studentGrid.js"></script>
<script type="text/javascript" src="js/main2.js"></script>

<style>
	#topDiv{
		height:65px;
		border:#373c64  thin solid;
		background-color:#373c64;
		width:100%;
		color:#FFF;
	}
	#biaoti{
		font-weight:bold;
		text-align:center;
	}
	.user{background-image:url(images/user.png) !important}
	.exit{background-image:url(images/exit.png) !important}
	.edit{background-image:url(images/edit.png) !important}
	.help{background-image:url(images/help.png) !important}
	.home{background-image:url(images/homemanage.gif) !important}
	
	.add{background-image:url(images/add.gif) !important}
</style>
	

</head>
<body>

	
	<script type="text/javascript">
		Ext.onReady(function(){
			Ext.create('Ext.Panel', {
			    title: '容器面板',
			    renderTo: Ext.getBody(),
			    width: 400,
			    height: 300,
			    layout: 'accordion',
			    items: [{
			        tools: [{ type: 'gear', handler: function () {
			            Ext.Msg.alert('提示', '配置按钮被点击。');
			        }
			        }, { type: 'refresh'}],
			        title: '面板1',
			        xtype: "panel",
			        html: "子元素1"
			 
			    }, {
			        title: '面板2',
			        xtype: "panel",
			        html: "子元素2"
			    }, {
			        id: 'panel3',
			        title: '面板3',
			        xtype: "panel",
			        html: "子元素3",
			        items:[
			        	treePanel
			        	]
			    }]
			});
			Ext.create("Ext.Button", {
			    renderTo: Ext.getBody(),
			    text: "打开第三页",
			    handler: function () {
			        Ext.getCmp('panel3').expand(true);
			    }
			});
			
		});
		
	</script>
	
</body>
</html>