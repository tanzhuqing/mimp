/// <reference path="vswd-ext_2.2.js" />


Ext.BLANK_IMAGE_URL = 'pic/blank.gif';


var login = function() {
	Ext.QuickTips.init();
	Ext.lib.Ajax.defaultPostHeader += ";charset=utf-8";
	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
	
    
	// 实现具体的功能

	var form = new Ext.FormPanel( {
		defaultType : 'textfield',
		labelWidth : 60,
		style : 'background:#ffffff;padding:25px 35px 30px 16px;',
		region : "center",
		defaults : {
			border : false,
			allowBlank : false,
			msgTarget : 'side',
			blankText : '该字段不允许为空'
		},
		waitMsgTarget : true,
		items : [ {
			fieldLabel : '登录帐号',
			name : 'user',
			regex : /^[a-zA-Z]{2,8}$/,
			regexText : '只能为两到六位的大小写字母。'
		}, {
			fieldLabel : '登录密码',
			id: 'pass',
			name : 'pass',
			inputType : 'password',
			regex : /^.{4,}$/,
			regexText : '长度不能少于4位'
		}, {
			xtype : 'panel',
			layout : 'column',
			items : [ {
				width : 130,
				layout : 'form',
				border : false,
				items : [{
					fieldLabel : '效 验 码',
					name : 'checkcode',
					xtype : 'textfield',
					allowBlank : false,
					msgTarget : 'side',
					blankText : '该字段不允许为空',
					anchor : '98%'
				}]
			}, {
				xtype : 'checkCode',
				src : 'CheckCode.aspx',
				width : 60,
				height : 20,
				handler : true
			}

			/*
			 * { width : 60, border : false, html : '<img id=\'checkpic\'
			 * src="IMG.action" onclick="this.src=\'IMG.action?\'+new Date()"/>' }
			 */

			]
		}],
		buttons : [ {
			text : '登陆',
			handler : function() {
				form.getForm().submit( {
					success : function(f, a) {
						OpenFullWin(a.result.url);
						// window.location.href = a.result.url;
						// window.open('main.html','','fullscreen=1');
					},
					url : 'Login.aspx',
					waitMsg : '正在提交，请稍等...'
				});
			}
		}, {
			text : '取消',
			handler : function() {
				form.getForm().reset();
			}
		}]

	});

	var panel = new Ext.Panel( {			
		renderTo : 'loginpanel',
		layout : "border",
		width : 525,
		height : 290,
		defaults : {
			border : false
		},
		items : [ {
			region : "north",
			height : 56,
			html : '<img src="pic/head.gif"/>'
		}, {
			region : "south",
			height : 56,
			html : '<img src="pic/foot.gif"/>'
		}, {
			region : "west",
			width : 253,
			html : '<img src="pic/left.gif"/>'
		}, form]
	});
  
   
	Ext.get('loginpanel').setStyle('position', 'absolute')
			.center(Ext.getBody());
	
};

Ext.onReady(login);

// listeners : {
// 'click' : function(t) {
// must adapt el.dom.src to set
// t.el.dom.src = 'IMG.action?time=' + new Date();
// },
// scope : this
// }

// var n = form.getForm().findField('user').getValue();
// var p = form.getForm().findField('pass').getValue();
// if (n == '123456' && p == '123456') {
// window.location.href = "main.html";
// window.open(document.URL,'','fullscreen=1');
// window.open('main.html','','fullscreen=1');
// } else {
// var a = function() {
// window.location.href = "default.html";
// };
// Ext.MessageBox.alert("出错", "你输入的员工编号或密码错误！请重新输入！", a);
// }
// }

