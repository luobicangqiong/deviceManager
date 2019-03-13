<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

<!DOCTYPE HTML>
<html>

<head>
<base href="<%=basePath%>">

<title>设备审批管理</title>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="../../javascript/themes/bootstrap/easyui.css" />

<link rel="stylesheet" type="text/css"
	href="../../javascript/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="../../javascript/bootstrap/css/bootstrap.css" />

<link rel="stylesheet" href="../../css/main.css" />
<link rel="stylesheet" href="../../css/kefu.css" />
<script type="text/javascript" src="../../javascript/jquery-2.1.3.js"></script>
<script type="text/javascript"
	src="../../javascript/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../../javascript/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../../javascript/my.js"></script>
</head>

<body>
	<!--面板-->
	<div class="panel panel-primary out-pane">
		<div class="panel-heading">
			<h3 class="panel-title">设备审批管理</h3>

		</div>
		<div class="panel-body">
			<!--内嵌面板-->

			<div class="panel panel-default">
				<div class="panel-heading">

					<!-- 按钮触发模态框 -->
					<button class="btn btn-default delete-cus" data-toggle="modal"
						data-target="#myModal3">审阅</button>

					<div class="form-inline" style="float: right;margin-right: 100px;"
						name="searchform" method="post" action="" id="searchform">
						<input type="text" class="form-control s-int" name="device" id=""
							value="" placeholder="请输入记录名字" />
						<button type="submit" class="btn btn-default cus-search"
							id="submit_search" onclick="doSearch()">搜索</button>
						<!--<button type="button" class="btn btn-default cus-search" name="" id="" value="搜索"onclick="doSearch()" />-->

					</div>
					<script type="text/javascript">
			 function doSearch(){ //用户输入用户名,点击搜素,触发此函数
			    	var value=$(".s-int").val();
			    	var se=$.trim(value);
			    	if(se!=""){
			    		$("#dg").datagrid({
			
			           url:'<%=basePath%>DeviceRecorderAction_queryDeviceByName?name='+se
			            //url:'keFuAction_queryAllCustomBy?search='+se //触发此action,带上参数searcValue
			
			        })
			    	}else{
			    		$("#dg").datagrid({
			
			           	url:'<%=basePath%>DeviceBorrowAction_queryAllDevice'
			            //url:'keFuAction_queryAllCustom' //触发此action,带上参数searcValue
			
			        })
			
			    	}
			
			    }

		    function randomWord(randomFlag, min, max){
		    var str = "",
		        range = min,
		        arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

		    // 随机产生
		    if(randomFlag){
		        range = Math.round(Math.random() * (max-min)) + min;
		    }
		    for(var i=0; i<range; i++){
		        pos = Math.round(Math.random() * (arr.length-1));
		        str += arr[pos];
		    }
		    return str;
		}


    </script>

				</div>
				<!--表格数据-->
				<table class="easyui-datagrid" id="dg" title="记录信息"
					style="width:1000px;height:400px" pagination="true"
					data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>AdminBorrowManagerAction_queryAllDevice',

				pageSize:10,

			pageList:[ 5, 10, 15, 20 ],method:'get'">
					<thead>
						<tr>
							<th data-options="field:'lenId',width:110 ,align : 'center', ">ID</th>
							<th data-options="field:'deviceId',width:110 ,align : 'center', ">设备序列号</th>
							<th data-options="field:'devicName',width:120,align:'center'">设备名</th>
							<th data-options="field:'devicePeople',width:110,align:'center'">借出人姓名</th>
							<th data-options="field:'devicePhone',width:110">借阅人电话</th>
							<th data-options="field:'deviceNumber',width:110,align:'center'">借出数量</th>
						</tr>
					</thead>
				</table>
			</div>
												
             <!--Delete Device  -->
            <div class="modal fade" id="myModal3" tabindex="-1" role="dialog"
				  aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal"
				          aria-hidden="true">×</button>
				        <h4 class="modal-title" id="myModalLabel">请选择</h4>
				      </div>
				      <div class="modal-body">确定同意该用户借阅吗？</div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default"
				          data-dismiss="modal">关闭</button>
				        <button type="button" class="btn btn-primary sure-delete">
				          我确定</button>
				      </div>
				    </div>
				    <!-- /.modal-content -->
				  </div>
				  <!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				<script>
				  $(function() {
				    $('#myModal').modal({
				      keyboard : true
				    })
				  });
				
				  $(function() {
				    var row;
				
				    $(".delete-cus").click(
				      function() {
				        var ro = $('#dg').datagrid('getSelected');
				        if (ro) {
				
				          row = ro;
				          $(".delete-cus").attr("data-target", "#myModal3");
				        } else {
				          alert("请选择一行");
				          $("#myModal3").hide();
				          $(".delete-cus").attr("data-target", "none");
				
				        }
				
				      }
				    );
				
				
				
				    $(".sure-delete").click(function() {
				
				      $.ajax({
				        type : "post",
				        url : "AdminBorrowManagerAction_agreeDevice",
				        dataType : "json",
				        data : {
				       
					      	"lenId":row.lenId,
				            "deviceId" : row.deviceId,
				            "devicName" : row.devicName,
				            "devicePeople" : row.devicePeople,
				            "devicePhone" : row.devicePhone,
				            "deviceNumber" : row.deviceNumber,
					        },
				
				        success : function(data) {
				          alert(data.info);
				
				
				          $("#myModal3").hide();
				          $('#dg').datagrid('reload');
				
				
				        }
				      });
				
				    });
				  });
				
				</script>



	</div>

</body>

</html>
