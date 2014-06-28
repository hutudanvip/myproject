//必填项提示
var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';

	/**
 * 功能：新增
 * 作者：刘飞 
 * 2011-07-15
 */
Ext.define('term_add', {
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
			name : 'id'
		}, {
			id : 'add_num',
			xtype : 'textfield',
			fieldLabel : '学期编码',
			columnWidth : 0.5,
			allowBlank: false,
			afterLabelTextTpl: required,
			name : 'number'
		}, {
			id : 'add_name',
			xtype : 'textfield',
			fieldLabel : '学期',
			columnWidth : 0.5,
			allowBlank: false,
			afterLabelTextTpl: required,
			name : 'name'
		}, {
			id : 'add_beginTime',
			xtype : 'datefield',
			fieldLabel : '开学时间',
			value: new Date(),
	        format:'Y-m-d',
	        editable:false,
			columnWidth : 0.5,
			name : 'beginTime'
		}, {
			xtype : 'textarea',
			fieldLabel : '备注说明',
			columnWidth : 0.8,
			name : 'describtion',
			id : 'describtion'
		}]
	}],
	buttons :[{
		text : '保存',
		iconCls : 'tbtn_save',
		handler:function(){
			var form = this.up('form').getForm();
			//获取学生学号
			var id = this.up('form').getForm().findField("id").getValue();
			var num = this.up('form').getForm().findField("number").getValue();
			var name = this.up('form').getForm().findField("name").getValue();
			var beginTime = this.up('form').getForm().findField("beginTime").getValue();
			var describe = this.up('form').getForm().findField("describtion").getValue();

			//提示信息
			var message = '新增学期时会将之前的设置为不可用，请确认是否新增数据?';
			if(ui_state != 'add')
			{
				message = '确认修改此数据？';
			}
			if(form.isValid()){
				Ext.Msg.show({
				     title:'信息提示',
				     msg: message,
				     closable:false,
				     buttons: Ext.Msg.OKCANCEL,
					 fn:function(btnId){
						switch(btnId){
							case "ok":
								form.submit({
									url : 'addTermAction.action',
									params:{'term.number':num, 'term.name':name, 'term.id':id,
											'term.describe':describe, 'term.beginTime':beginTime, 'state':ui_state},

				                    success: function(form, action) {
				                       Ext.Msg.alert('Success', '保存成功！');
				                       addWindow.close();
				                       //新增后重新加载数据
				                       store_term.load();
				                    },
				                    failure: function(form, action) {
				                       Ext.Msg.alert('Error', '保存失败！');
				                       addWindow.close();
				                       store_term.load();
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