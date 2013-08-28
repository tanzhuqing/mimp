Ext.onReady(function(){
	var cm = new Ext.grid.ColumnModel([{
		header:"id",
		dataIndex:"id"
	},{
		header:"time",
		dataIndex:"time"
	},{
		header:"frame",
		dataIndex:"frame"
	},{
		header:"length",
		dataIndex:"length"
	},{
		header:"element",
		dataIndex:"element"
	}]);
	var fields = ["id","time","frame","length","element"];
	var data = [
		["1","0","0","0","0"],
		["2","0","0","0","0"],
		["3","0","0","0","0"],
		["4","0","0","0","0"],
		["5","0","0","0","0"]];
	var store = new Ext.data.SimpleStore({
		fields:fields,
		data:data
	});
	var grid = new Ext.grid.GridPanel({
		//renderTo: Ext.getBody(),
		title:"数据结果显示表",
		width:600,
		cm:cm,
		store:store
	});
	grid.render(Ext.getBody());
});
var store = new Ext.data.Store({
     proxy:new Ext.data.
	
})

 var ds = new Ext.data.Store（{
        proxy: new Ext.data.HttpProxy（{url:""gridjson.jsp""}），        
        reader: new Ext.data.JsonReader（{
            totalProperty: ""totalProperty""，
            root: ""root""，
            successProperty :""success""
        }， [
            {name: ""id""，mapping:""id""，type:""int""}，
            {name: ""name""，mapping:""name""，type:""string""}，
            {name: ""descn""，mapping:""descn""，type:""string""}
        ]）
    }）;
