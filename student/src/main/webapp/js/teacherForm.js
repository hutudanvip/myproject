	/**
 * 功能：新增
 * 作者：刘飞 
 * 2011-07-15
 */
Ext.define('teacher_add', {
	extend :'Ext.form.Panel',
	layout : 'absolute',
	defaultType: 'textfield',
	defaults: {labelAlign:'left'},
	baseCls:'x-plain',
    layout: {
        type: 'vbox',
        align: 'right'
    },
	dockedItems : {
		xtype : 'toolbar',
		dock : 'bottom',
		padding:'10 10 10 10',
		// height : 30,
		items : [{
			xtype : 'label'
		}]
	},
    items: [{
		xtype : 'fieldset',
		defaults: {labelAlign:'right'},
		width : 340,
		style:'margin-left:10px; margin-top:20px',
		items : [{
			id : 'add_id',
			xtype : 'textfield',
			hidden:true,
			name : 'teacher.id'
		}, {
			id : 'add_num',
			xtype : 'textfield',
			fieldLabel : '编码',
			columnWidth : 0.5,
			allowBlank: false,
			name : 'teacher.number'
		}, {
			id : 'add_name',
			xtype : 'textfield',
			fieldLabel : '姓名',
			columnWidth : 0.5,
			name : 'teacher.name'
		}, {
			id : 'add_cellphone',
			xtype : 'textfield',
			fieldLabel : '联系方式',
			columnWidth : 0.5,
			name : 'teacher.cellphone'
		}, {
			id : 'add_intime',
			xtype : 'datefield',
			fieldLabel : '入校时间',
			columnWidth : 0.5,
			name : 'teacher.inTime'
		}, {
			xtype : 'textarea',
			fieldLabel : '备注说明',
			columnWidth : 0.8,
			name : 'teacher.describe',
			id : 'describtion'
		}]
	}],
	buttons :[{
		text : '保存',
		iconCls : 'tbtn_save',
		handler:function(){
			var form = this.up('form').getForm();
			//获取学生学号
			// var id = this.up('form').getForm().findField("id").getValue();
			// var num = this.up('form').getForm().findField("number").getValue();
			// var name = this.up('form').getForm().findField("name").getValue();
			// var describe = this.up('form').getForm().findField("describtion").getValue();
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
									url : 'addTeacherAction.action',
									params:{'state':ui_state},

				                    success: function(form, action) {
				                       Ext.Msg.alert('Success', '保存成功！');
				                       addWindow.close();
				                       //新增后重新加载数据
				                       store_grade.load();
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