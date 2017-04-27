$(function () {
    $("#jqGrid").jqGrid({
        url: '../tuser/list',
        datatype: "json",
        colModel: [			
			{ label: 'userid', name: 'userid', width: 50, key: true },
			{ label: '姓名', name: 'name', width: 80 }, 			
			{ label: '地址', name: 'address', width: 80 }, 			
			{ label: '联系方式', name: 'phone', width: 80 }, 			
			{ label: '出生日期', name: 'birthday', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.recordList",
            page: "page.currentPage",
            total: "page.pageCount",
            records: "page.recordCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		tUser: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tUser = {};
		},
		update: function (event) {
			var userid = getSelectedRow();
			if(userid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userid)
		},
		saveOrUpdate: function (event) {
			var url = vm.tUser.userid == null ? "../tuser/save" : "../tuser/update";
			if(vm.tUser.userid == null) vm.tUser.userid = new Date().getTime(); 
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.tUser),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var userids = getSelectedRows();
			if(userids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../tuser/delete",
				    data: JSON.stringify(userids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(userid){
			$.get("../tuser/info/"+userid, function(r){
                vm.tUser = r.tUser;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});