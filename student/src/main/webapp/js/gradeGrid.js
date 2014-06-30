Ext.require([ 'Ext.form.*', 'Ext.data.*', 'Ext.grid.*',
		'Ext.tip.QuickTipManager', 'Ext.util.*', 'Ext.layout.container.Absolute', 'Ext.panel.Panel' ]);

Ext.Loader.setConfig({
	enabled : true
});

//用于区分界面，新增/修改
var ui_state;

var grade_add = Ext.create('grade_add');

//增加
var addWindow = Ext.create('Ext.window.Window', {
	autoDestroy : true,
	closable : true,
	closeAction : 'hide',
	modal : true,
	width : 370,
	height : 250,
	layout : 'fit',
	items : [grade_add]
});

store_grade.load();
var grade_grid = Ext.create('Ext.grid.Panel', {
	renderTo : Ext.getBody(),
	// bodyPadding : '10 50 10 10',
	// padding:'10 50 10 10',
	store : store_grade,
	items:[{xtype:'toolbar'}],
	columns : [Ext.create('Ext.grid.RowNumberer'), 
	           {
				id : 'id',
				hidden:true,
				dataIndex : 'id'
	           }, {
				id : 'numner',
				name:'number',
				text : '班级编码',
				sortable : true,
				dataIndex : 'number',
				width : 120
			// flex : 1
	           }, {
	        	   id : 'name',
	        	   name:'name',
	        	   text : '班级名称',
	        	   sortable : true,
	        	   dataIndex : 'name',
	        	   width : 120
	           }, {
	        	   id : 'iseffective',
	        	   name:'iseffective',
	        	   text : '是否有效',
	        	   sortable : true,
	        	   dataIndex : 'iseffective',
	        	   width : 80,
	        	   editor : {
	        		   xtype : 'checkbox'
	        	   },
	        	   renderer : function(value) {
	        		   if (value) {
	        			   return "<center><input type='checkbox' disabled=true checked=1></center>";
	        		   } else {
	        			   return "<center><input type='checkbox' disabled=true></center>";
	        		   }
	        	   }
	           }, {
	        	   id : 'createtime',
	        	   name:'createtime',
	        	   header : "创建时间",
	        	   dataIndex : "createTime",
	        	   width : 160,
	        	   renderer : function(value) {
	        		   if (value != null) {
	        			   var date = new Date(value);
	        			   return Ext.Date.format(date,
	        					   'Y-m-d H:i:s');
	        		   } else {
	        			   return null;
	        		   }
	        	   }
	           }, {
	        	   id : 'lastUpdateTime',
	        	   name:'lastUpdateTime',
	        	   header : "最后修改时间",
	        	   dataIndex : "lastUpdateTime",
	        	   width : 160,
	        	   renderer : function(value) {
	        		   if (value != null) {
	        			   var date = new Date(value);
	        			   return Ext.Date.format(date,
	        					   'Y-m-d H:i:s');
	        		   } else {
	        			   return null;
	        		   }
	        	   }
	           }, {
	        	   id : 'describe',
	        	   name:'describtion',
	        	   header : "备注",
	        	   width : 400,
	        	   dataIndex : "describe",
	        	   sortable : false,
	           } ],
	           tbar: [
	                  { 
	                	  xtype: 'button', 
	                	  text: '新增', 
	                	  iconCls:'add',
	                	  handler : function(){

	                	  		//清空控件的值
	                	  		grade_add.getForm().reset();
	                	  		Ext.getCmp('add_num').setReadOnly(false);
	  							ui_state = 'add';
	  							addWindow.setTitle("新增");
	  							addWindow.show();
	                	  }
	                  },{ 
	                	  xtype: 'button', 
	                	  text: '修改', 
	                	  iconCls:'edit',
	                	  handler : function(){
	  						// 获取选中的行数据
	  						var updateRow = grade_grid.getSelectionModel().getSelection();
	  						
	  						if (updateRow.length != 1) {
	  							Ext.MessageBox.alert("提示", "请选择一行要修改的数据！");
	  							
	  						} else {
	  							//获取选择的记录
	  							var updateRocord = updateRow[0].data;

	  							grade_add.getForm().findField("id").setValue(updateRocord.id);
	  							grade_add.getForm().findField("number").setValue(updateRocord.number);
	  							grade_add.getForm().findField("name").setValue(updateRocord.name);
	  							grade_add.getForm().findField("describtion").setValue(updateRocord.describe);

	  							ui_state = 'modify',
	  							addWindow.setTitle("修改");
	  							addWindow.show();
	  							// Ext.getCmp('add_num').setDisabled(true);
	  							//只读
	  							Ext.getCmp('add_num').setReadOnly(true);
	  						}
	                	  }
	                  },{ 
	                	  xtype: 'button', 
	                	  text: '作废', 
  	                	  iconCls:'delete',
	                	  handler : function(){

	                	  	// 获取选中的行数据
	  						var updateRow = grade_grid.getSelectionModel().getSelection();
  							//获取选择的记录
  							var updateRocord = updateRow[0].data;
	  						
	  						if (updateRow.length != 1) {
	  							Ext.MessageBox.alert("提示", "请选择一行要修改的数据！");
	  						}
	  						if(updateRocord.iseffective == 0)
	  						{
	  							Ext.MessageBox.alert("提示", "请选择有效的数据！");
	  						}
	  						else {

	  							Ext.Msg.confirm('提示框',
										'作废后该班级则不再可用，确认作废?',
										function(btn) {
											if (btn == 'yes') {
												Ext.Ajax.request({
													url : 'repealGradeAction.action',
													params : {
														//获取id
														'grade.id':updateRocord.id
													},

													success : function(response){
														var rpon = Ext.decode(response.responseText);
														if(rpon.success)
														{
															Ext.Msg.alert('成功', '作废成功！');
															//重新查询
															store_grade.load();
														}
														else
														{
															Ext.Msg.alert('失败', '作废失败！' + rpon.message);
															//重新查询
															store_grade.load();
														}
														
													},
													failure : function(response) {
														Ext.Msg.alert('Failure', '作废失败！');
													}
													
												});
											}
												
										}
								);

	  						}
	                	  	
    		  				
	                	  } 
	                  }, { 
	                	  xtype: 'button', 
	                	  text: '刷新', 
  	                	  iconCls:'tbtn_refresh',
	                	  handler : function(){

	                	  	//重新加载数据
                	  		store_grade.load();
    		  				
	                	  } 
	                  }],
	                  
	                  stripeRows : true,
	                  // height : 300,
	                  // width : 720,
	                  frame : true
});

