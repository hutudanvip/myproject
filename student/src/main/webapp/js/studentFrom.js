Ext.Loader.setConfig({enabled: true});
Ext.require([
	'Ext.form.*',
	'Ext.layout.container.Absolute',
	'Ext.panel.Panel'
]);

//必填项提示
var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';

//查询
var stu_query = Ext.create('Ext.form.Panel', {
renderTo : Ext.getBody(),
id : 'show_student',
frame : true,
title : '学生查询',
padding:'10 10 10 10',
// bodyPadding : 10,
// width : 1200,
// height : 250,
defaults:{
	// layout : 'form' // Specifies that the items will now be
},

// arranged in columns

fieldDefaults : {
	labelAlign : 'right',
	msgTarget : 'side'
},
items : [
		{
			xtype : 'fieldset',
			title : '查询',
			defaultType : 'textfield',
			collapsible : true,
			// width:520,
			// layout : 'anchor',
//					padding:'20 30',
			defaults: {//统一设置宽、居右
				margin:'5 5 5 5',//间距				
				labelWidth:60,
				labelAlign: 'right',
				layout:'hbox',
				// width : 200,
				// column:3,
				xtype:'textfield'
			},
			items : [
					{
						xtype : 'container',
						items : [ {
							xtype : 'textfield',
							fieldLabel : '学号',
							name : 'number',
							id : 'query_number'
//									anchor : 0.3,
//									padding:'20 10'
						}, {
							id:'query_name',
							xtype : 'textfield',
							fieldLabel : '姓名',
							name : 'name'
							// flex : 1
//									allowBlank : false
						}]
					}]
			}, {
				xtype : 'fieldset',
				title : '高级查询',
				defaultType : 'textfield',
				collapsible : true,
				defaults: {//统一设置宽、居右
					margin:'5 5 5 5',//间距
					labelWidth:20,
					labelAlign: 'right',
					layout:'hbox',
					// width : 200,
					// column:3,
					xtype:'textfield'
				},
				items : [
						{
							xtype : 'container',
							items : [ {
								xtype : 'combobox',
								fieldLabel : '查询类型',
								name : 'query_type',
								id : 'query_type',
								store: store_querytype,
								displayField:'value',
								editable:false,
								valueField:'key'
	//									anchor : 0.3,
	//									padding:'20 10'
							}, {
								id:'query_month',
								xtype : 'datefield',
								fieldLabel : '月份',
								name : 'query_month',
								width: 200,
								editable: false,
								format : 'Y-m'
								// flex : 1
	//									allowBlank : false
							}, {
								id : 'query_term',
								xtype : 'combobox',
								// name:'student.grade.id',
								editable:false,
								displayField: 'name',
								fieldLabel : '学期',
								store:store_term,
								allowBlank : false,
								name:'query_term',
							    // queryMode: 'local',
							    valueField: 'id'
							}, {
								id : 'query_grade',
								xtype : 'combobox',
								name:'query_grade',
								// name:'student.grade.id',
								editable:false,
								displayField: 'name',
								fieldLabel : '所属班级',
								store:store_grade,
								width: 220,
							    // queryMode: 'local',
							    valueField: 'id'
							} ]
					}]
			}, {
				xtype : 'container',
				defaults:{
					layout:'form'
				},
				items : [{
							xtype : 'button',
							text : '重置',
							iconCls:'tbtn_Clear',
							margin:'5 750',//间距		
							width : 80,
							handler : function() {
								this.up('form').getForm().reset();
							}
					}, {
							xtype : 'button',
							text : '查询',
							iconCls:'tbtn_filter',
							// padding:'10,10,10,500',
							margin:'5 850',//间距		
							width : 80,
							handler : function() {
								var number = this.up('form').getForm().findField("number").getValue();
								var name = this.up('form').getForm().findField("name").getValue();
								var type = this.up('form').getForm().findField("query_type").getValue();
								var month = this.up('form').getForm().findField("query_month").getValue();
								var term = this.up('form').getForm().findField("query_term").getValue();
								var grade = this.up('form').getForm().findField("query_grade").getValue();

								if(number == "" && name == "")
								{
									if(type == null 
										||  month == null 
										||  term == null
										||  grade == null)
									{
										Ext.Msg.alert("提示","查询条件不完整，请补充查询条件！");
										//停止程序
										return false;
									}
								}
								store_student.load({params:{
									'student.name':name, 'student.number':number,
									'student.queryType':type, 'student.beginTime':month,
									'student.term.id':term, 'student.grade.id':grade	
								}});
				 				
							}
					}]
			}]

});


store_grade.load();
/**
 * 功能：新增
 * 作者：刘飞 
 * 2011-07-15
 */
Ext.define('stu_add', {
	extend :'Ext.form.Panel',
	layout : 'form',
	defaultType: 'textfield',
	defaults: {labelAlign:'right'},
	baseCls:'x-plain',
	margin:'5 5 5 5',//间距
    // layout: {
    //     type: 'vbox',
    //     align: 'right'
    // },
	// dockedItems : {
	// 	xtype : 'toolbar',
	// 	dock : 'bottom',
	// 	height : 30,
	// 	items : [{
	// 		xtype : 'label',
	// 		text : '学生新增'
	// 	}]
	// },
    items: [{
		xtype : 'fieldset',
		width : 360,
		defaults: {//统一设置宽、居右
					margin:'5 5 5 5',//间距
					labelWidth:60,
					labelAlign: 'right',
					width : 160,
					xtype:'textfield'
		},
		layout :{
			type : 'column',	//table布局
			columns : 2	//列数
		},
		
		items : [{
			id : 'add_num',
			xtype : 'textfield',
			fieldLabel : '学号',
			allowBlank: false,
			name : 'student.number'
		}, {
			id : 'add_name',
			xtype : 'textfield',
			fieldLabel : '姓名',
			allowBlank: false,
			afterLabelTextTpl: required,
			name : 'student.name'
		},  {
 	    	id : 'add_gender',
 	    	name:'student.gender',
	        xtype: 'radiogroup',
            fieldLabel : '性别',
            afterLabelTextTpl: required,
            vertical: true,
            layout: 'hbox',
			defaults: {
                flex: 1
            },
            items: [
                    { boxLabel: '男', name: 'student.gender', inputValue: '1', checked:true},
                    { boxLabel: '女', name: 'student.gender', inputValue: '0' }
                ]
		}, {
			id :'add_age',
			name : 'student.age',
			xtype : 'numberfield',
//			validator : isNumber,
			fieldLabel : '年龄',
	        maxValue: 99,
	        minValue: 1,
			value:1
		}, {
			id : 'add_grade',
			xtype : 'combobox',
			name:'student.grade.id',
			editable:false,
			displayField: 'name',
			fieldLabel : '所属班级',
			store:store_gradeEffect,
		    // queryMode: 'local',
		    valueField: 'id'
		}, {
 	    	name: 'student.intime',
 	    	id : 'add_intime',
	        xtype: 'datefield',
	        fieldLabel: '入学日期',
	        value: new Date(),
	        format:'Y-m-d',
	        editable:false
	    }, {
	    	id : 'add_genearch',
	    	name:'student.genearchName',
	    	afterLabelTextTpl: required,
	    	allowBlank: false,
			fieldLabel: '家长姓名'
		}, {
			id : 'add_relation',
			xtype : 'combobox',
			editable:false,
			name:'student.relation',
			displayField: 'value',
			fieldLabel : '关系',
			afterLabelTextTpl: required,
			store:store_relation,
		    queryMode: 'local',
		    valueField: 'value'
		}, {
			id : 'add_term',
			xtype : 'combobox',
			editable:false,
			name:'student.term.id',
			displayField: 'name',
			fieldLabel : '入学学期',
			width:220,
			afterLabelTextTpl: required,
			store:store_termEffect,
		    // queryMode: 'local',
		    valueField: 'id'
		}, {
			id:'add_cellphone',
	    	xtype : 'textfield',
			fieldLabel: '联系方式',
			width:220,
			name:'student.cellphone',
			allowBlank: false,
			afterLabelTextTpl: required
			// allowBlank:false,//不能为空的设置
			// blankText:'手机号码不能为空',//不能为空设置的提示
			//maxLength:11,
			//maxLengthText:'手机号码最长为11位',//自定义最大长度提示
			//minLength:4,
			//minLengthText:'...',//自定义最小长度提示
			// regex:/13[0-9]{9}|15[0|1|2|3|5|6|7|8|9]\d{8}|18[0|5|6|7|8|9]\d{8}/,
			// regexText:'请输入正确手机号码',
			// name:'phone'
		}, {
	    	id : 'add_address',
	    	name:'student.address',
			fieldLabel: '家庭住址',
			allowBlank: false,
			afterLabelTextTpl: required,
			width:340
		}, {
			xtype : 'textarea',
			fieldLabel : '备注说明',
			width:340,
			name : 'student.describe',
			id : 'add_description'
		}]
	}],
	buttons :[{
		text : '保存',
		iconCls : 'tbtn_save',
		handler:function(){
			var form = this.up('form').getForm();

			if(form.isValid()){
				Ext.Msg.show({
				     title:'信息提示',
				     msg: '确认保存此信息?',
				     closable:false,
				     buttons: Ext.Msg.OKCANCEL,
					 fn:function(btnId){
						switch(btnId){
							case "ok":
								form.submit({
									url : 'addStuAction.action',
									params:{'ui_sate':ui_state},
				                    success: function(form, action) {
				                       Ext.Msg.alert('Success', '保存成功！');
				                       
				                       addWindow.close();
				                    },
				                    failure: function(form, action) {
				                       Ext.Msg.alert('Error', '保存失败！');
				                       
				                       addWindow.close();
				                    }
				                });
								break;
							case "no":
								break;
						}
					}		
				});
			}
		}
	}]
}); 
		

//导入界面
Ext.define('upload_form', {
	extend:'Ext.form.Panel',
    // renderTo: 'fi-form',
    width: 500,
    frame: true,
    // title: 'File Upload Form',
    bodyPadding: '10 10 0',

    defaults: {
        anchor: '100%',
        allowBlank: false,
        msgTarget: 'side',
        labelWidth: 50
    },

    items: [{
        xtype: 'filefield',
        id: 'form_file',
        emptyText: '请选择文件',
        fieldLabel: '文件',
        name: 'file_path',
        buttonText: '',
        buttonConfig: {
            iconCls: 'upload'
        }
    }],

    buttons: [{
        text: '上传',
        handler: function(){
            var form = this.up('form').getForm();
            var file_path = form.findField("form_file").getValue();
            alert(file_path);
            if(form.isValid()){
                form.submit({
                    url: 'addFileAction.action',
					params:{'filePath':file_path},
                    // waitMsg: 'Uploading your file...',
                    // msg('Success', 'Processed file "' + o.result.file + '" on the server');
                    success: function(fp, o) {
                        msg('Success', 'Processed file "' + o.result.file + '" on the server');
                    }
                });
            }
        }
    },{
        text: '重置',
        handler: function() {
            this.up('form').getForm().reset();
        }
    }]
});


