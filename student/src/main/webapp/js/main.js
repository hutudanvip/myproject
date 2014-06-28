Ext.onReady(function(){
	//初始化提示条
    Ext.QuickTips.init();

	var statusText = Ext.create('Ext.toolbar.TextItem', {text: '学生管理系统 ©2000-2012'});
    var clock = Ext.create('Ext.toolbar.TextItem', {text: Ext.Date.format(new Date(), 'g:i:s A')});
	
	var indexTreeStore = Ext.create('Ext.data.TreeStore', {
		root : {
			expanded : true,
			text : '功能列表',
			children : [{
				text : "人员管理",
				expanded : true,
				children : [{
					text : "学生管理",
					id:'stu_manage',
					href:'',
					leaf : true
				},{
					id:'grade_manage',
					text : "班级管理",
					href:"",
					leaf : true
				},{
					id : "term_manage",
					text: "学期管理",
					href:"",
					leaf : true
				},{
					id : 'teacher_manage',
					text : "教师管理",
					href:"",
					leaf : true
				}]
			},{
				text : "出勤情况管理",
				expanded : true,
				children : [{
					text : "学生出勤统计",
					href:"",
					leaf : true
				},{
					text : "教师出勤统计",
					href:"",
					leaf : true
				}]
			},{
				text : "财务管理",
				expanded : true,
				children : [{
					text : "费用管理",
					href:"",
					leaf : true
				}]
			}]
		}
	});		
	
	var treePanel = Ext.create('Ext.tree.TreePanel', {
		id: 'treepanel',
		store : indexTreeStore,
		//rootVisible : false,
		region : 'west',
		collapsible : true,
		width : 177,
		border:false,
		minWidth : 177,
		maxWidth : 177,
	    split: true,//可以合并
	    width:250,
	    autoScroll: true,
	    useArrows: true,
	    collapseMode:'mini',
	    //animCollapse:true,
		listeners : {
			itemclick : function(node, record,item,index,e,eOpts){
				if(record.get("id")=="stu_manage"){//学生管理
					initTabpanel(record.data.id,record.data.text,'studentManage.jsp');
				}
				else if(record.get("id")=="grade_manage"){//班级管理
					initTabpanel(record.data.id,record.data.text,'gradeManage.jsp');
				}
				else if(record.get("id")=="term_manage"){//学期管理
					initTabpanel(record.data.id,record.data.text,'termManage.jsp');
				}
				else if(record.get("id")=="teacher_manage"){//学期管理
					initTabpanel(record.data.id,record.data.text,'teacherManage.jsp');
				}
//				if(record.get("id")=="messagebox"){//消息提示框
//					initTabpanel(record.data.id,record.data.text,'extjs/examples/message-box/index.html');
//				}
			}
		}
	});

	var tabPanelTitle = Ext.create('Ext.tab.Panel', {
		region : 'center',
		id:'tabPanel',
		activeTab :0,
		iconCls:'home',
		plugins: Ext.create('Ext.ux.TabCloseMenu',{closeTabText:'关闭当前',closeOthersTabsText:'关闭其它',closeAllTabsText:'关闭所有'}),
		items : [{
			title : '首页',
			id:'showIndex',
			html: '欢迎admin登录系统！'
		}]
	});

	var viewport = Ext.create('Ext.Viewport', {
        layout: {
            type: 'border',
            padding: 5
        },
        items: [{ 
			id : 'banner',
			region : 'north',
			height:65,
			contentEl : 'topDiv',
			collapseMode:'mini',
			hideBorders:true,
			border : false
		},{
            region: 'center',
            layout:'border',
			border:false,
			items:[treePanel,tabPanelTitle],
			tbar:new Ext.Toolbar({
				hideBorders:true,
				border:false,
			  	items :[
					{id:'logo',text:'',iconCls: 'logo'},    
			  		{id:'biaoti',xtype:'label',text:'功能菜单'},
					'->',
				    '当前用户',
				    {id:'user',text:'admin',iconCls: 'user'},
				    '-','上次登录时间 2012-05-25 09:40:49','-',
			  		{id:'edit',text:'修改密码',iconCls: 'edit',tooltip : '修改密码',handler:function(){
			  			
			  		}},
					'-',
			  		{id:'exit',text:'退出系统',iconCls: 'exit',tooltip : '退出系统',handler:function(){
			  			Ext.MessageBox.confirm('确认', '您确定要退出吗?',function(btn,text){
							if(btn=='yes'){
								
							}
						});
			  		}},'-',
					{id:'help',text:'帮助',iconCls: 'help'}
				]
			})
        },{
			id:'buttom',
			region : 'south',
			height : 20,
			border : false,
			items : [{
				xtype: 'statusbar',
				items: [
					statusText,
					'-',
					clock
				],
				listeners: {
					render: {
						fn: function(){
							Ext.TaskManager.start({
								run: function(){
									Ext.fly(clock.getEl()).update(Ext.Date.format(new Date(), 'g:i:s A'));
								},
								interval: 1000
							});
						}
					}
				}
			}]
        }]
	});
});

/**.
* <p>
* 动态加载tabPanel
* </p>
* @author  张登
* @时间    2012-03-19
*/
function initTabpanel(id,text,url,obj){
	var tabs = Ext.getCmp('tabPanel');
	//alert(url);
	if (tabs) {
		var n = tabs.getComponent(id);
		//判断是否已经打开该面板
		if (!n) {   
			n = tabs.add({
				'id': id,
				'title': text,
				closable:true,
				layout: 'fit',
				border:false,
				/*
				loader: {
					url: url,
					scripts:true,
					contentType: 'html',
					autoLoad: true
				}
				
				listeners:{
					close:function(){
						obj.destroy();
					}
				},
				items:[obj]
				*/
				html: '<iframe id="'+id+'" src="'+url+'" style="height:100%;width:100%;" frameborder="0"></iframe>'
			});
		}
	  tabs.setActiveTab(n);
	}
}
