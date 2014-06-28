Ext.require([
//'Ext.form.*',
//'Ext.layout.container.Column',
//'Ext.tab.Panel'
'*']);

Ext.onReady(function() {

    var simple = Ext.widget({
        xtype: 'form',
//        layout: 'form',
        collapsible: false,
        id: 'loginForm',
        frame: true,
        title: '用户登录',
        bodyPadding: '5 5 0',
        width: 350,
        fieldDefaults: {
            msgTarget: 'side',
            labelWidth: 75
        },
        defaultType: 'textfield',
        items: [{
            fieldLabel: '用户名',
            name: 'user.username',
            allowBlank: false
        }, {
            fieldLabel: '密码',
            name: 'user.password',
            allowBlank: false,
            inputType: 'password'
        }],

        buttons: [{
            text: '登录',
            //            type:'submit',
            //            url:'http://www.baidu.com',
            handler: function() {
                if (simple.getForm().isValid()) {
                    var name = simple.getForm().findField("user.username").getValue();
                    var pas = simple.getForm().findField("user.password").getValue();

                    Ext.Ajax.request({
                        url: 'valid.action',
                        params: {
                            'user.username': name,
                            'user.password': pas
                        },
                        success: function(response) {
                            var result = Ext.decode(response.responseText);
                            alert(result.user.username + "登录成功！");
                            window.location.href = "login.action";
                            //            				window.location.href="http://www.163.com";
                        },
                        failure: function(response) {
                            alert("账户名或密码错误，请重新输入！");
                            //            				var result = Ext.decode(response.responseText);
                            //            				failFn(result);
                        }
                    });

                    //提交到服务器操作
                    //            		simple.getForm().doAction('submit',{
                    //                    url:'login.action',
                    //                    method:'post',
                    //                    params:{'user.username': name, 'user.password':psd}
                    //                    success:function(form, action){
                    ////                        document.location="index.jsp";
                    //                    	window.location.href="http://www.163.com";
                    //                        Ext.Msg.alert("登录成功！");
                    //                    },
                    //                    failure:function(form,action){
                    //                    	alert(333);
                    ////                    	window.location.href="./login";
                    ////                        Ext.Msg.alert("登录失败！");
                    //                    }
                    //                    });


                    //            		Ext.MessageBox.show({
                    //            			title:'请等待',  
                    //            			msg:'正在加载',  
                    //            			progressText:'',  
                    //            			width:300,  
                    //            			progress:true,  
                    //            			closable:'false',  
                    //            			animEl:'loding' 
                    //            		});
                    //            		window.location.href="student/login.action";
                    //            		window.location.href="http://www.baidu.com";
                    //            		simple.form.doAction('submit', {
                    //                		url:'kaixindao/login.action',
                    //                		method:'post',
                    //                		success:function(form,action){
                    ////                			Ext.Msg.alert("登录成功！",action.result.message,function(){});
                    ////                			window.location.href="http://www.163.com";
                    //                			
                    //                		},
                    //                		failure:function(form,action){
                    ////                			document.location="error.jsp",
                    //                			//Ext.Msg.alert("登录失败！");
                    //                			//window.location.href="http://www.baidu.com";
                    //                		}
                    //                	});
                }
            }
        }, {
            text: '重置',
            handler: function() {
                this.up('form').getForm().reset();
            }
        }]
    });


    simple.render("login");
});