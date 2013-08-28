/*

This file is part of Ext JS 4

Copyright (c) 2011 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

*/
Ext.require('Ext.chart.*');
var chart;
	Ext.define('WeatherPoint', {
    extend: 'Ext.data.Model',
    fields: ['temperature', 'date']
	});
	var store = Ext.create('Ext.data.Store', {
    model: 'WeatherPoint',
    data: [		
		 { temperature: 18, dat: 0 },
        { temperature: 13, dat: 1 },
        { temperature: 13, dat: 2 },
        { temperature: 18, dat: 3 },
        { temperature: 13, dat: 4 },

	    { temperature: 18, dat: 5 },
        { temperature: 13, dat: 6 },
        { temperature: 13, dat: 7 },
        { temperature: 18, dat: 8 },
        { temperature: 13, dat: 9 },
        { temperature: 3, dat: 10 },
        { temperature: 18, dat: 11 },
        { temperature: 1, dat: 12 },
		 { temperature: 18, dat: 20 },
        { temperature: 13, dat: 21 },
        { temperature: 33, dat: 22 },
        { temperature: 18, dat: 23 },
        { temperature: 13, dat: 24 },

	    { temperature: 68, dat: 25 },
        { temperature: 43, dat: 26 },
        { temperature: 33, dat: 27 },
        { temperature: 28, dat: 28 },
        { temperature: 13, dat: 29 },
        { temperature: 3, dat: 30 },
        { temperature: 78, dat: 31 },
        { temperature: 1, dat: 32 }
    ]
	});	
		
	var data2 = [	   
		 { temperature: 18, dat: 0 },
        { temperature: 23, dat: 1 },
        { temperature: 33, dat: 2 },
        { temperature: 48, dat: 3 },
        { temperature: 53, dat: 4 },

	    { temperature: 68, dat: 5 },
        { temperature: 43, dat: 6 },
        { temperature: 33, dat: 7 },
        { temperature: 28, dat: 8 },
        { temperature: 13, dat: 9 },
        { temperature: 3, dat: 10 },
        { temperature: 78, dat: 11 },
        { temperature: 1, dat: 12 },
		 { temperature: 18, dat: 20 },
        { temperature: 23, dat: 21 },
        { temperature: 33, dat: 22 },
        { temperature: 48, dat: 23 },
        { temperature: 53, dat: 24 },

	    { temperature: 68, dat: 25 },
        { temperature: 43, dat: 26 },
        { temperature: 33, dat: 27 },
        { temperature: 28, dat: 28 },
        { temperature: 13, dat: 29 },
        { temperature: 3, dat: 30 },
        { temperature: 78, dat: 31 },
        { temperature: 1, dat: 32 }
		];	
	function bb(){
		////////////////////sy
		
		
		var aa = "[1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4,10,20,3,4,10,2,30]";
		
		//replaceString(aa,']',"");
		 aa = aa.replace("[","");
		 aa = aa.replace("]","");
		 var b = aa.split(',');
		
		//var reader = new Ext.data.ArrayReader({id:1},aa);
		var dddd  = '[';
		var i = 0;
		
        for(i = 0;i<b.length;i++){
			dddd = dddd + '{ temperature:' + b[i] +',dat:' + i + '}' ;
			if( i !=  (b.length - 1) )
			{dddd = dddd + ',';}
		}
		dddd = dddd + ']';
		alert(dddd);
		/*var   text= "[abcdefabc]"; 
		text   =   text.replace(/abc/g, '***'); 
		
		text.replace(/"([^"]*)"/g, "[$1]");
		alert(text) */
		
		var aaa = Ext.decode(dddd);
		//////////////////////
		store.loadData(aaa);
		chart.redraw();
		//Ext.MessageBox.alert('ad','ffff');
	}
Ext.onReady(function () {
  //store1.loadData(generateData(8));
var button1 = Ext.get('fu');
button1.on('click',bb);
	//store.loadData(data2);
   chart= Ext.create('Ext.chart.Chart', {
   renderTo: Ext.getBody(),
   width: 400,
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
});

