Ext.require([ 'Ext.form.*', 'Ext.data.*', 'Ext.grid.*',
		'Ext.tip.QuickTipManager', 'Ext.util.*' ]);

Ext.onReady(function() {

	Ext.define('ddw', {
		extend : 'Ext.data.Model',
		idProperty : 'ddw',
		fields : [ {
			name : 'number'
		}, {
			name : 'name'
		}, {
			name : 'isused'
		}, {
			name : 'createtime'
		}]
	});

	var selectStore = new Ext.data.Store({
		model : 'ddw',
		pageSize : 30,
		// autoLoad:true,
		proxy : {
			type : 'ajax',
			url : 'selectAction',
			// actionMethods : {
			// read : 'POST'
			// },
			reader : {
				type : 'json',
				root : 'select'
			}
		}
	});

	var grid = Ext.create('Ext.grid.Panel', {
		renderTo : Ext.getBody(),
	
		store : selectStore,
		columns : [Ext.create('Ext.grid.RowNumberer'), 
		{
			id : 'numner',
			text : '编号',
			sortable : true,
			dataIndex : 'number'
		// flex : 1
		}, {
			id : 'name',
			text : '名字',
			sortable : true,
			dataIndex : 'name'
		}, {
			id : 'isused',
			text : '是否有效',
			sortable : true,
			dataIndex : 'isused',
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
			header : "创建时间",
			dataIndex : "createtime",
			renderer : function(value) {
				if (value != null) {
					var date = new Date(value);
					return Ext.Date.format(date,
							'Y-m-d H:i:s');
				} else {
					return null;
				}
			}
		} ],
		stripeRows : true,
		height : 300,
		width : 500,
		frame : true
	});

	/*
	 * Here is where we create the Form
	 */
	var gridForm = Ext.create('Ext.form.Panel', {
		renderTo : Ext.getBody(),
		id : 'company-form',
		frame : true,
		title : 'Company data',
		bodyPadding : 5,
		width : 520,
		height : 460,
		// layout : 'column', // Specifies that the items will now be
		// arranged in columns

		fieldDefaults : {
			labelAlign : 'left',
			msgTarget : 'side'
		},
		items : [
				{
					xtype : 'fieldset',
					title : 'ddw',
					defaultType : 'textfield',
					// layout : 'anchor',
					defaults : {
						width : 520
					// anchor : '50%'
					},
					items : [
							{
								xtype : 'container',
								layout : 'hbox',
								items : [ {
									xtype : 'textfield',
									fieldLabel : '编号',
									name : 'number',
									id : 'number'
								}, {
									xtype : 'textfield',
									fieldLabel : '名字',
									name : 'name',
									// flex : 1
									allowBlank : false
								} ]
							},
							{
								xtype : 'button',
								text : '查询',
								width : 80,
								handler : function() {
									selectStore.currentPage = 1, selectStore
											.load({

												waitMsg : 'Loading...',
												params : {
													"category" : 1,
													'selectBean.number' : Ext
															.getCmp('number')
															.getValue()
												}
											});
								}
							} ]
				}, grid ]

	});

});
