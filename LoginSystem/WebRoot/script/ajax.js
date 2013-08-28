Ext.onReady(function(){

	var store = "{head:'aa55',frame:3,length:100,time:'"+formatDate()+"','element':[331,33,22.5,66.3]}";
	var jsonStore = Ext.decode(store);
	Ext.Ajax.request({
	url : '/LoginSystem/json',
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
//格式化日期：yyyy-MM-dd 
function formatDate() {
	var date = new Date();
	var myyear = date.getFullYear();
	var mymonth = date.getMonth() + 1;
	var myweekday = date.getDate();
	var myhour = date.getHours();      //获取当前小时数(0-23)
	var mymin = date.getMinutes();    //获取当前分钟数(0-59)
	var mysecond = date.getSeconds();    //获取当前秒数(0-59)
	if (mymonth < 10) {
	 mymonth = "0" + mymonth;
	}
	if (myweekday < 10) {
	 myweekday = "0" + myweekday;
	}
	
	if (myhour < 10) {
		myhour = "0" + myhour;
		}
	if (mymin < 10) {
		mymin = "0" + mymin;
		}
	if (mysecond < 10) {
		mysecond = "0" + mysecond;
		}
	return (myyear + "-" + mymonth + "-" + myweekday + " " + myhour +":"+ mymin +":"+ mysecond );
}

