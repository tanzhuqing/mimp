Ext.onReady(function(){

	var store = "{head:'aa55',frame:3,length:100,time:'"+formatDate()+"','element':[331,33,22.5,66.3]}";
	var jsonStore = Ext.decode(store);
	Ext.Ajax.request({
	url : '/LoginSystem/DataUploadAction',
	params : {
		name : 'value'
	},
	jsonData:jsonStore,
	success : function(response) {
		Ext.Msg.alert('success', response.responseText);
	},
	failure : function(response) {
		Ext.Msg.alert('failure', response.responseText);
	}
	
	});
});

function element()
{


}