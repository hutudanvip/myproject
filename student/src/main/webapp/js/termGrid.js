Ext.require([ 'Ext.form.*', 'Ext.data.*', 'Ext.grid.*',
		'Ext.tip.QuickTipManager', 'Ext.util.*', 'Ext.layout.container.Absolute', 'Ext.panel.Panel' ]);

Ext.Loader.setConfig({
	enabled : true
});


//用于区分界面，新增/修改
var ui_state;

var term_add = Ext.create('term_add');

//增加
var addWindow = Ext.create('Ext.window.Window', {
	autoDestroy : true,
	closable : true,
	closeAction : 'hide',
	modal : true,
	width : 370,
	height : 250,
	layout : 'fit',
	items : [term_add]
});

store_term.load();
var term_grid = Ext.create('Ext.grid.Panel', {
	renderTo : Ext.getBody(),
	// bodyPadding : '10 30 10 10',
	// padding:'10 80 10 10',
	store : store_term,
	items:[{xtype:'toolbar'}],
	columns : [Ext.create('Ext.grid.RowNumberer'), 
	           {
				id : 'id',
				hidden:true,
				dataIndex : 'id'
	           }, {
				id : 'numner',
				name:'number',
				text : '学期编码',
				sortable : true,
				dataIndex : 'number',
				width : 120
			// flex : 1
	           }, {
	        	   id : 'name',
	        	   name:'name',
	        	   text : '学期',
	        	   sortable : true,
	        	   dataIndex : 'name',
	        	   width : 120
	           }, {
	        	   id : 'beginTime',
	        	   name:'beginTime',
	        	   header : "开学时间",
	        	   dataIndex : "beginTime",
	        	   width : 140,
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
	        	   width : 140,
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
	        	   width : 300,
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
	                	  		term_add.getForm().reset();
	                	  		Ext.getCmp('add_num').setReadOnly(false);
	  							ui_state = 'add';
	  							addWindow.setTitle("新增");
	  							addWindow.show();
	                	  }
	                  }, { 
	                	  xtype: 'button', 
	                	  text: '修改', 
	                	  iconCls:'edit',
	                	  handler : function(){
	  						// 获取选中的行数据
	  						var updateRow = term_grid.getSelectionModel().getSelection();
	  						
	  						if (updateRow.length != 1) {
	  							Ext.MessageBox.alert("提示", "请选择一行要修改的数据！");
	  							
	  						} else {
	  							//获取选择的记录
	  							var updateRocord = updateRow[0].data;

	  							//只能修改有效数据
	  							if(updateRocord.iseffective){
		  							term_add.getForm().findField("id").setValue(updateRocord.id);
		  							term_add.getForm().findField("number").setValue(updateRocord.number);
		  							term_add.getForm().findField("name").setValue(updateRocord.name);
		  							term_add.getForm().findField("beginTime").setValue(updateRocord.beginTime);
		  							term_add.getForm().findField("describtion").setValue(updateRocord.describe);

		  							ui_state = 'modify',
		  							addWindow.setTitle("修改");
		  							addWindow.show();
		  							// Ext.getCmp('add_num').setDisabled(true);
		  							//只读
		  							Ext.getCmp('add_num').setReadOnly(true);
	  							} else {
	  								Ext.MessageBox.alert("提示", "只能修改有效数据！");
	  							}



	  						}
	                	  }
	                  },{ 
	                	  xtype: 'button', 
	                	  text: '删除', 
  	                	  iconCls:'delete',
	                	  handler : function(){

	                	  	// 获取选中的行数据
	  						var updateRow = term_grid.getSelectionModel().getSelection();
  							//获取选择的记录
  							var updateRocord = updateRow[0].data;
	  						
	  						if (updateRow.length != 1) {
	  							Ext.MessageBox.alert("提示", "请选择要删除的数据！");
	  							
	  						}
	  						else {

	  							Ext.Msg.confirm('提示框',
										'确认要删除该数据？',
										function(btn) {
											if (btn == 'yes') {
												Ext.Ajax.request({
													url : 'deleteTermAction.action',
													params : {
														//获取id
														'term.id':updateRocord.id
													},
													success : function(response){
														Ext.Msg.alert('Success', '删除成功！');
														//重新查询
														store_term.load();
													},
													failure : function(response) {
														Ext.Msg.alert('Failure', "删除失败！");
														//重新查询
														store_term.load();
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
                	  		store_term.load();
    		  				
	                	  } 
	                  }],
	                  
	                  stripeRows : true,
	                  // height : 300,
	                  // width : 720,
	                  frame : true,
	                  bbar: Ext.create('Ext.PagingToolbar', {
						  store: store_term,
						  displayInfo: true
						            // plugins: Ext.create('Ext.ux.ProgressBarPager', {})
					  })

});

