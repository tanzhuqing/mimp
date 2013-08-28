Ext.require('Ext.chart.*');
var chart;
var aa ;
	Ext.define('WeatherPoint', {
    extend: 'Ext.data.Model',
    fields: ['temperature', 'date']
	});
	var store = Ext.create('Ext.data.Store', {
    model: 'WeatherPoint',
    data: [	{ temperature: 18, dat: 0 },{ temperature: 13, dat: 1 },
          { temperature: 13, dat: 2 }, { temperature: 18, dat: 3 }]
	});	

var frame = 0;	


Ext.onReady(function(){

	///////////////////////////////////////////////////画图操作
   chart= Ext.create('Ext.chart.Chart', {
   renderTo: Ext.getBody(),
   width: 800,
   height: 300,
  theme: 'Red',
  id: 'chartCmp',
   store: store,
   axes: [
        {
            title: 'Temperature',
            type: 'Numeric',
            position: 'left',
            fields: ['temperature'],
            minimum: 0,
            maximum: 100
        },
        {
            title: 'Time',
            type: 'Numeric',
            position: 'bottom',
			 // minimum: 0,
            // maximum: 250,
			//majorTickSteps:250,
			//minorTickSteps:2
           fields: ['dat']
          
        }
    ],
    series: [
        {
            type: 'area',
            xField: 'dat',
            yField: 'temperature'
        }
    ]
});
chart = Ext.getCmp('chartCmp');

setInterval( requestData, 3000);		
});
	
function requestData(){
	var store1 = "{head:'aa55',frame:" + frame + ",length:100,time:'"+formatDate()+"','element':[\"33\",\"33\",\"22.5\",\"66.3\"]}";
	var jsonStore = Ext.decode(store1);	
	frame = frame + 1;
	//alert(store1);
	Ext.Ajax.request({
		url : '/jsonmonitor/DownloadServlet',
		params : {
			name : 'value'
		},
		jsonData:jsonStore,
		success : function(response) {
			//Ext.Msg.alert('ss',Ext.decode( response.responseText).element);
			//Ext.Msg.alert('ss',response.responseText);
			//alert(Ext.decode( response.responseText).frame);
			aa = Ext.decode( response.responseText).element;
			reDrawChart();
			
		},
		failure : function(response) {
			Ext.Msg.alert('ff', response.responseText);
		}	
	});
}

function reDrawChart(){

	var dddd  = '[';
	var i = 0;
    for(i = 0;i<aa.length;i++){
		dddd = dddd + '{ temperature:' + aa[i] +',dat:' + i + '}' ;
		if( i !=  (aa.length - 1) )
		{dddd = dddd + ',';}
	}
	dddd = dddd + ']';

	store.loadData(Ext.decode(dddd));
	chart.redraw();
}

//格式化日期：yyyy-MM-dd 
function formatDate() {
	var date = new Date();
	var myyear = date.getFullYear();
	var mymonth = date.getMonth() + 1;
	var myweekday = date.getDate();
	var myhour = date.getHours();      //鑾峰彇褰撳墠灏忔椂鏁�0-23)
	var mymin = date.getMinutes();    //鑾峰彇褰撳墠鍒嗛挓鏁�0-59)
	var mysecond = date.getSeconds();    //鑾峰彇褰撳墠绉掓暟(0-59)
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
