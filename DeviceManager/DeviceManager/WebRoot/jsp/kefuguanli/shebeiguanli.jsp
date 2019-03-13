<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% String path=request.getContextPath(); String basePath=request.getScheme()+ "://"+request.getServerName()+ ":"+request.getServerPort()+path+ "/"; %>

<!DOCTYPE HTML>
<html>

<head>
<base href="<%=basePath%>">

<title>客户管理</title>
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
			<h3 class="panel-title">客户信息管理</h3>

		</div>
		<div class="panel-body">
			<!--内嵌面板-->

			<div class="panel panel-default">
				<div class="panel-heading">

					<!-- 按钮触发模态框 -->
					<button class="btn btn-default add-cus" data-toggle="modal"
						data-target="#myModal9">添加新设备</button>
					<!-- 按钮触发模态框 -->
					<button class="btn btn-default edit-cus " data-toggle="modal"
						data-target="#myModal2">修改现有设备</button>
					<button class="btn btn-default delete-cus" data-toggle="modal"
						data-target="#myModal3">删除设备</button>
					<!-- 按钮触发模态框 -->

					<div class="form-inline" style="float: right;margin-right: 100px;"
						name="searchform" method="post" action="" id="searchform">
						<input type="text" class="form-control s-int" name="device" id=""
							value="" placeholder="请输入设备名字" />
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
			
			           url:'DeviceAction_queryDeviceByName?name='+se
			            //url:'keFuAction_queryAllCustomBy?search='+se //触发此action,带上参数searcValue
			
			        })
			    	}else{
			    		$("#dg").datagrid({
			
			           	url:'DeviceAction_queryAllDevice'
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
				<table class="easyui-datagrid" id="dg" title="客户信息"
					style="width:1000px;height:400px" pagination="true"
					data-options="singleSelect:true,rownumbers:true,

				collapsible:true,

				url:'<%=basePath%>DeviceAction_queryAllDevice',

				pageSize:10,

			pageList:[ 5, 10, 15, 20 ],method:'get'">
					<thead>
						<tr>
							<th data-options="field:'deviceId',width:110 ,align : 'center', ">ID</th>
							<th data-options="field:'deviceName',width:110 ,align : 'center', ">设备名</th>
							<th data-options="field:'deviceVersion',width:120,align : 'center', ">设备版本</th>
							<th data-options="field:'devicePrice',width:120,align:'center'">价格</th>
							<th data-options="field:'deviceNumber',width:110,align:'center'">数量</th>
							<th data-options="field:'warnNumber',width:110">预警数量</th>
							<th data-options="field:'deviceState',width:110,align:'center'">状态</th>
							<th data-options="field:'devicePeople',width:110,align:'center'">管理人</th>
							<th data-options="field:'deviceUse',width:120,align:'center'">当前用途</th>
							<th data-options="field:'devicePhone',width:120,align:'center'">手机号</th>
							<th data-options="field:'deviceLeave',width:120,align:'center'">剩余数量</th>
							
						</tr>
					</thead>
				</table>
			</div>

			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal9" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">请填写设备信息</h4>
						</div>
						<!--		<form action="<%=basePath%>keFuAction_addCustom" method="post">-->

						<div class="modal-body add-success">

							<table class="table">

								<tr class="table-tr">
									<th>ID</th>
									<td><input type="text" class="form-control   "
										name="device.deviceId" id="deviceId" value=""
										required="required" /></td>
									<th>设备名:</th>
									<td><input type="text" class="form-control   "
										name="device.deviceName" id="deviceName" value=""
										required="required" /></td>
								</tr>
								<tr class="table-tr">
									<th>设备价格：</th>
									<td><input type="text" class="form-control   "
										name="device.devicePrice" id="devicePrice" value=""
										required="required"
										pattern="r'^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$'" /></td>
									<th>设备数量</th>
									<td><input type="text" class="form-control   "
										name="device.deviceNumber" id="deviceNumber" value=""
										required="required" /></td>
								</tr>

								<tr class="table-tr">
									<th>设备状态：</th>
									<td><input type="text" class="form-control   "
										name="device.deviceState" id="deviceState" value=""
										required="required" pattern="[1-9]\d{5}(?!\d)" /></td>
									<th>管理人：</th>
									<td><input type="text" class="form-control   "
										name="device.devicePeople" id="devicePeople" value=""
										required="required" /></td>
								</tr>
								<tr class="table-tr">
									<th>设备用途：</th>
									<td><input type="text" class="form-control   "
										name="device.deviceUse" id="deviceUse" value=""
										required="required" /></td>
									<th>管理人电话:</th>
									<td><input type="text" class="form-control   "
										name="device.devisePhone" id="devicePhone" value=""
										required="required" /></td>
								</tr>
								<tr class="table-tr">
									<th>预警数量</th>
									<td><input type="text" class="form-control   "
										name="device.warnNumber" id="warnNumber" value=""
										required="required" /></td>
									<th>设备版本:</th>
									<td><input type="text" class="form-control   "
										name="device.deviceVersion" id="deviceVersion" value=""
										required="required" /></td>
								</tr>
								
								<tr class="table-tr">
									<th>剩余数量</th>
									<td><input type="text" class="form-control   "
										name="device.deviceLeave" id="deviceLeave" value=""
										required="required" /></td>
								</tr>
								

							</table>

						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default add-close"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary add-custom-add add">
								提交设备信息</button>
						</div>

						<!--</form>-->
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<script>
						$(function () { $('#myModal').modal({
						      keyboard: true
						   })});
						$(function(){
//							$(".add-cus").click(function(){
//
//								  $("this").ATTR("data-target","#myModal");
//
//							})
							 $("#myModal9").hide();
	   	                    $(".add-cus").attr("data-target","none");
								$(".add-cus").click(function(){

              $(".add-cus").attr("data-target","#myModal9");

             	$("#myModal9").show();

						   	});

							$(".add-custom-add").click(
								function(){
									var id = $("#deviceID").val();
									var name=$("#deviceName").val();
									var version=$("#deviceVersion").val();
									var price=$("#devicePrice").val();
									var count=$("#deviceNumber").val();
									var state=$("#deviceState").val();
									var people=$("#devicePeople").val();

									var use=$("#deviceUse").val();
									var phone=$("#devicePhone").val();
									var warncount=$("#warnNumber").val();
									var leavenumber = $("#deviceLeave").val();
									 console.log(name);
									 console.log(randomWord(false, 36));
									 $.ajax({
							
							             type: "post",
							             url: "DeviceAction_addDevice",
							             dataType: "json",
							            data:{
							            	"device.deviceName":name,
							            	"device.deviceVersion":version,
							            	"device.devicePrice":price,
							            	"device.deviceNumber":count,
							            	"device.deviceState":state,
							            	"device.devicePeople":people,
							            	"device.deviceUse":use,
							            	"device.warnNumber":warncount,
											"device.devicePhone":phone,
											"device.deviceID":id,
											"device.deviceLeave":leavenumber
							            },
							             success: function(data){
							             	alert(data.info);
							             	$("#deviceName").val("");
												$("#deviceVersion").val("");
												$("#devicePrice").val("");
												$("#deviceNumber").val("");
												$("#deviceState").val("");
												$("#devicePeople").val("");
							
												$("#deviceUse").val("");
												$("#devicePhone").val("");
												$("#warnNumber").val("");
							             	$("#myModal").hide();
							             	$('#dg').datagrid('reload');
							
							//           	$(".add-success").empty()
							//           	.html("<h6>"+data.info+"</h6>");
							//           	$(".add-custom-add").hide();
							             }



    });


								}
							);
						})
					</script>

									<!-- 修改设备功能 -->
									
					<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
									</button>
									<h4 class="modal-title" id="myModalLabel">
               请修设备信息
            </h4>
								</div>
								<div class="modal-body">

									<table class="table">

										<tr class="table-tr">
											<th>ID</th>
											<td><input type="text" class="form-control   "
												name="device.deviceId" id="devId" value=""
													required="required" readonly="true" /></td>
								            <th>设备名:</th>
								            <td><input type="text" class="form-control   "
								              name="device.deviceName" id="devName" value=""
								              required="required" /></td>
								            
								          </tr>
								          <tr class="table-tr">
								            <th>设备价格：</th>
								            <td><input type="text" class="form-control   "
								              name="device.devicePrice" id="devPrice" value=""
								              required="required"
								              pattern="r'^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$'" /></td>
								            <th>设备数量</th>
								            <td><input type="text" class="form-control   "
								              name="device.deviceNumber" id="devNumber" value=""
								              required="required" /></td>
								          </tr>
								
								          <tr class="table-tr">
								            <th>设备状态：</th>
								            <td><input type="text" class="form-control   "
								              name="device.deviceState" id="devState" value=""
								              required="required" pattern="[1-9]\d{5}(?!\d)" /></td>
								            <th>管理人：</th>
								            <td><input type="text" class="form-control   "
								              name="device.devicePeople" id="devPeople" value=""
								              required="required" /></td>
								          </tr>
								          <tr class="table-tr">
								            <th>设备用途：</th>
								            <td><input type="text" class="form-control   "
								              name="device.deviceUse" id="devUse" value=""
								              required="required" /></td>
								            <th>管理人电话:</th>
								            <td><input type="text" class="form-control   "
								              name="device.devisePhone" id="devPhone" value=""
								              required="required" /></td>
								          </tr>
								          <tr class="table-tr">
								            <th>预警数量</th>
								            <td><input type="text" class="form-control   "
								              name="device.warnNumber" id="warnNum" value=""
								              required="required" /></td>
								            <th>设备版本:</th>
								            <td><input type="text" class="form-control   "
								              name="device.deviceVersion" id="devVersion" value=""
								              required="required" /></td>
								          </tr>
								          <tr class="table-tr">
								            <th>剩余数量</th>
								            <td><input type="text" class="form-control   "
								              name="device.deviceLeave" id="devLeave" value=""
								              required="required" /></td>
								          </tr>
									</table>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary edit-custom">
										提交更改
									</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<script>
						$(function () { $('#myModal').modal({
						      keyboard: true
						   })});



						   $(function(){
						   	var id="a";
						   	$(".edit-cus").click(function(){

							
						   var row = $("#dg").datagrid('getSelected');
							 console.log(row);

			   	if(row)
			   	{

               $(".edit-cus").attr("data-target","#myModal2");
               console.log(row.deviceName);
               $("#devName").val(row.deviceName);
               $("#devVersion").val(row.deviceVersion);
               $("#devPrice").val(row.devicePrice);
               $("#devNumber").val(row.deviceNumber);
               $("#devState").val(row.deviceState);
               $("#devPeople").val(row.devicePeople);

               $("#devUse").val(row.deviceUse);
               $("#devPhone").val(row.devicePhone);
               $("#warnNum").val(row.warnNumber);
               $("#devId").val(row.deviceId);
               $("#devLeave").val(row.deviceLeave)

               $("#myModal2").show();





	   	}else{
	   		alert("请选择一行");

	   	   $("#myModal2").hide();
	   	   $(".edit-cus").attr("data-target","none");

	   	}

							});

//						   	结束
		$(".edit-custom").click(
		      function() {
		    	var id = $("#devId").val();
		        var name = $("#devName").val();
		        var version = $("#devVersion").val();
		        var price = $("#devPrice").val();
		        var count = $("#devNumber").val();
		        var state = $("#devState").val();
		        var people = $("#devPeople").val();
		
		        var use = $("#devUse").val();
		        var phone = $("#devPhone").val();
		        var warncount = $("#warnNum").val();
		        var deviceLea = $("#devLeave").val();
		        //									 console.log(a);
		        console.log(id);
		        $.ajax({
		          type : "post",
		          url : "DeviceAction_editDevice",
		          dataType : "json",
		          data : {
		        	"device.deviceId":id,
		            "device.deviceName" : name,
		            "device.deviceVersion" : version,
		            "device.devicePrice" : price,
		            "device.deviceNumber" : count,
		            "device.deviceState" : state,
		            "device.devicePeople" : people,
		            "device.deviceUse" : use,
		            "device.warnNumber" : warncount,
		            "device.devicePhone" : phone,
		            "device.deviceLeave" : deviceLea,
		          },
		
		          success : function(data) {
		            alert(data.info);
		            $("#deviceName").val("");
		            $("#deviceVersion").val("");
		            $("#devicePrice").val("");
		            $("#deviceNumber").val("");
		            $("#deviceState").val("");
		            $("#devicePeople").val("");
		
		            $("#deviceUse").val("");
		            $("#devicePhone").val("");
		            $("#warnNumber").val("");
		            $("#myModal").hide();
		            $('#dg').datagrid('reload');
		             }



    });
    							}
							);
//							结束
						})
					</script>
					
					
					
					
					
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
				      <div class="modal-body">确定要删除客户信息吗？</div>
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
				        url : "DeviceAction_deleteDevice",
				        dataType : "json",
				        data : {
				       
					      	"device.deviceId":row.deviceId,
				            "device.deviceName" : row.deviceName,
				            "device.deviceVersion" : row.deviceVersion,
				            "device.devicePrice" : row.devicePrice,
				            "device.deviceNumber" : row.deviceNumber,
				            "device.deviceState" : row.deviceState,
				            "device.devicePeople" : row.devicePeople,
				            "device.deviceUse" : row.deviceUse,
				            "device.warnNumber" : row.warnNumber,
				            "device.devicePhone" : row.devicePhone,
				            "device.deviceLeave": row.deviceLeave
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
