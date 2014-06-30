Ext.require([ 'Ext.form.*', 'Ext.data.*', 'Ext.grid.*',
		'Ext.tip.QuickTipManager', 'Ext.util.*', 'Ext.layout.container.Absolute', 'Ext.panel.Panel' ]);

Ext.Loader.setConfig({
	enabled : true
});

//界面控制
var ui_state;

//增加
var stu_add = Ext.create('stu_add');
var addWindow = Ext.create('Ext.window.Window', {
	autoDestroy : true,
	closable : true,
	closeAction : 'hide',
	title : '学生新增',
	modal : true,
	width : 390,
	height : 420,
	// layout : 'form',
	items : [stu_add]
});

//文件导入
var upload_form = Ext.create('upload_form');
var uploadWindow = Ext.create('Ext.window.Window', {
	autoDestroy : true,
	closable : true,
	closeAction : 'hide',
	title : '文件导入',
	modal : true,
	width : 370,
	height : 120,
	layout : 'fit',
	items : [upload_form]
});


var stu_grid = Ext.create('Ext.grid.Panel', {
	renderTo : Ext.getBody(),
	// bodyPadding : 5,
	// padding:'10 10 10 10',
	// width : 900,
	height : 450,
	store : store_student,
	items:[{xtype:'toolbar'}],
	columns : [Ext.create('Ext.grid.RowNumberer'), 
	           {
				id : 'id',
				hidden:true,
				dataIndex : 'id'
			// flex : 1
	           },{
				id : 'numner',
				text : '学号',
				sortable : true,
				dataIndex : 'number'
			// flex : 1
	           }, {
	        	   id : 'name',
	        	   text : '学生姓名',
	        	   sortable : true,
	        	   dataIndex : 'name'
	           },  {
	        	   id : 'age',
	        	   text : '年龄',
	        	   sortable : true,
	        	   dataIndex : 'age'
	           },  {
	        	   id : 'gender',
	        	   text : '性别',
	        	   sortable : true,
	        	   dataIndex : 'gender'
	           }, {
	        	   id : 'intime',
	        	   header : "入学时间",
	        	   dataIndex : "intime",
	        	   renderer : function(value) {
	        		   if (value != null) {
	        			   var date = new Date(value);
	        			   return Ext.Date.format(date,
	        					   'Y-m-d H:i:s');
	        		   } else {
	        			   return null;
	        		   }
	        	   }
	           } , {
	        	   id : 'gradeName',
	        	   text : '班级',
	        	   sortable : true,
	        	   dataIndex : 'gradeName'
	           }, {
	        	   id : 'genearchName',
	        	   text : '家长姓名',
	        	   sortable : true,
	        	   dataIndex : 'genearchName'
	           }, {
	        	   id : 'relation',
	        	   text : '关系',
	        	   sortable : true,
	        	   dataIndex : 'relation'
	           }, {
	        	   id : 'cellphone',
	        	   text : '联系方式',
	        	   sortable : true,
	        	   dataIndex : 'cellphone'
	           }, {
	        	   id : 'isused',
	        	   text : '是否有效',
	        	   sortable : true,
	        	   dataIndex : 'iseffective',
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
	        	   id : 'term',
	        	   text : '学期',
	        	   sortable : true,
	        	   dataIndex : 'termName'
	           }, {
	        	   id : 'createtime',
	        	   header : "创建时间",
	        	   dataIndex : "createTime",
	        	   renderer : function(value) {
	        		   if (value != null) {
	        			   var date = new Date(value);
	        			   return Ext.Date.format(date,
	        					   'Y-m-d H:i:s');
	        		   } else {
	        			   return null;
	        		   }
	        	   }
	           } , {
	        	   id : 'lastUpdateTime',
	        	   header : "最后修改时间",
	        	   dataIndex : "lastUpdateTime",
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
	        	   id : 'address',
	        	   text : '家庭住址',
	        	   sortable : true,
	        	   dataIndex : 'address'
	           }, {
	        	   id : 'describe',
	        	   text : '备注说明',
	        	   sortable : true,
	        	   dataIndex : 'describe'
	           }],
	           tbar: [
	                  { 
	                	  xtype: 'button', 
	                	  text: '新增', 
	                	  iconCls:'add',
	                	  handler : function(){
	                	  	  ui_state = 'add';
	                	  	  addWindow.setTitle("学生新增");
	                	  	  Ext.getCmp('add_num').setReadOnly(false);
	                		  addWindow.show();
	                	  }
	                  },{ 
	                	  xtype: 'button', 
	                	  text: '修改', 
	                	  iconCls:'edit',
	                	  handler : function(){

	                	  	ui_state = 'add';
	                	  	
	  						// 获取选中的行数据
	  						var updateRow = stu_grid
	  								.getSelectionModel()
	  								.getSelection();
	  						
	  						if (updateRow.length != 1) {
	  							Ext.MessageBox.alert("提示", "请选择一行要修改的数据！");
	  							
	  						} else {
	  							//获取选择的记录
	  							var updateRocord = updateRow[0].data;
	  							
	  							stu_add.getForm().findField("student.number").setValue(updateRocord.number);
	  							stu_add.getForm().findField("student.name").setValue(updateRocord.name);
	  							stu_add.getForm().findField("student.gender").setValue(updateRocord.gender);
	  							stu_add.getForm().findField("student.age").setValue(updateRocord.age);
	  							
	  							//班级
	  							store_grade.each(function(record) {
									if (updateRocord.gradeName == record.data.name) {
										stu_add.getForm()
												.findField("student.grade.id")
												.setValue(record.data.id);
									}
								});	
	  							stu_add.getForm().findField("student.intime").setValue(updateRocord.intime);
	  							stu_add.getForm().findField("student.genearchName").setValue(updateRocord.genearchName);
	  							stu_add.getForm().findField("student.relation").setValue(updateRocord.relation);
	  							stu_add.getForm().findField("student.cellphone").setValue(updateRocord.cellphone);
	  							stu_add.getForm().findField("student.address").setValue(updateRocord.address);

	  							stu_add.getForm().findField("student.describe").setValue(updateRocord.describe);

	  							// stu_add.getForm().findField("student.name").setValue(updateRocord.name);
	  							addWindow.setTitle("学生修改");
	  							Ext.getCmp('add_num').setReadOnly(true);
	  							addWindow.show();
	  						}
	                	  }
	                  },{ 
	                	  xtype: 'button', 
	                	  text: '作废', 
  	                	  iconCls:'tbtn_blankout',
	                	  handler : function(){

	                	  	// 获取选中的行数据
	  						var updateRow = stu_grid.getSelectionModel().getSelection();
	  						
	  						if (updateRow.length != 1) {
	  							Ext.MessageBox.alert("提示", "请选择一行要作废的数据！");
	  							
	  						}
	  						else {

	  							//获取选择的记录
  								var updateRocord = updateRow[0].data;
  								
	  							Ext.Msg.confirm('提示框',
										'确认删除作废该学生信息?',
										function(btn) {
											if (btn == 'yes') {
												Ext.Ajax.request({
													url : 'repealStuAction.action',
													params : {
														//获取id
														'student.id':updateRocord.id
													},
													success : function(response){
														Ext.Msg.alert('Success', '作废成功！');
														//重新查询
														store_student.load();
													},
													failure : function(response) {
														Ext.Msg.alert('Failure', "作废失败！");
														//重新查询
														store_student.load();
													}
													
												});
											}
												
										}
								);

	  						}
	                	  	
    		  				
	                	  } 
	                  }, { 
	                	  xtype: 'button', 
	                	  text: '导入', 
	                	  iconCls:'export',
	                	  handler : function(){
	                		  uploadWindow.show();
	                	  } 
	                  }, { 
	                	  xtype: 'button', 
	                	  id:'btn_exportExcel',
	                	  text: '导出', 
	                	  iconCls:'export',
	                	  handler : function(){
	                	  
	                	  		// alert(Ext.CONTEXT);
	                	  		window.location.href = Ext.CONTEXT + '/exportStuAction.action';
	                	  	
	                	  } 
	                  }],

	                  
	                  stripeRows : true,
	                  // height : 300,
	                  // width : 520,
	                  frame : true
});

