<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<link href="bootstrap/css/bootstrap-theme.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/m-border-max.css">
</head>
<body>
	<div class="container">
		<br /> <br />
		<h1>员工管理系统</h1>
		<div class="table-bordered m-bord-max">
			<form class="form-inline">
				<div class="form-group">
					<label style="font-size: 16px;" for="exampleInputName2">姓名：</label>&nbsp;&nbsp;&nbsp;<input
						type="text" class="form-control" id="SearchByEmpName"
						placeholder="Jane Doe">
				</div>
				<button id="search_submit" type="submit" class="btn btn-default">搜 索</button>
			</form>
			<div class="row">
				<table align='center' class="table table-bordered table-hover">
					<tr>
						<td>id</td>
						<td>姓名</td>
						<td>年龄</td>
						<td>性别</td>
						<td>头像</td>
						<td>所在省</td>
						<td>所在市</td>
						<td style="width: 100px">编辑</td>
					</tr>
					<c:forEach items="${emplist}" var="emp" varStatus="st">
						<tr>
							<td>${emp.id}</td>
							<td>${emp.empName}</td>
							<td>${emp.empAge}</td>
							<td>${emp.empSex}</td>
							<td><img alt="" height="40px"
								src="${emp.empHeadPortrait}"></td>
							<td>${emp.city}</td>
							<td>${emp.province}</td>
							<td><button id="editEmp" onclick="editEmp(${emp.id})" class="btn btn-primary btn-xs" href="#"
							data-toggle="modal" data-target="#editModal" data-whatever="@mdo">编辑</button>&nbsp;&nbsp;<button
								class="btn btn-info btn-xs" href="#">详情</button></td>
						</tr>
					</c:forEach>
					
				</table>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<button id="addEmp" type="button" style="float: right;"
						class="btn btn-primary" data-toggle="modal"
						data-target="#addModal" data-whatever="@mdo">新 增</button>
				</div>
				<div class="modal fade" id="editModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel">
					<div class="modal-dialog" style="width: 450px !important;"
						role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="exampleModalLabel">修改员工</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-md-6">
										<div class="row"
											style="padding-left: 20px; padding-bottom: 5px;">
											
											<label for="recipient-name" style="float: left;"
												class="control-label">姓名：</label><input id="editEmpName" type="text"
												style="width: 70%;" class="form-control" id="recipient-name">
										</div>
										<div class="row"
											style="padding-left: 20px; padding-bottom: 5px;">
											<label for="recipient-name" style="float: left;"
												class="control-label">年龄：</label><input id="editEmpAge" type="text"
												style="width: 70%;" class="form-control" id="recipient-name">
										</div>
										<div class="row"
											style="padding-left: 20px; padding-bottom: 10px;">
											<label for="recipient-name" style="float: left;"
												class="control-label">性别：</label><input id="editEmpSex" type="text"
												style="width: 70%;" class="form-control" id="recipient-name">
										</div>
										<div class="row"
											style="padding-left: 20px; padding-bottom: 10px;">
											<label for="recipient-name" style="float: left;"
												class="control-label">所在省：</label> <select id="editProvince"
												style="width: 62%;" class="form-control">
												<option value= "" data-id="0">--选择省份--</option>
											</select>
										</div>
										<div class="row"
											style="padding-left: 20px; padding-bottom: 5px;">
											<label for="recipient-name" style="float: left;"
												class="control-label">所在市：</label> <select id="editCity"
												style="width: 62%;" class="form-control">
												<option value= "" data-id="0">--选择城市--</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
									<div>
            							<div class="row"><label style="text-align: center;font-size:16px;margin-left:105px;">头  像</label></div>
            							<div class="row"><img id="editHeadImg" class="editHeadImg" style="border-width:3px;width:120px;height:150px;margin-left:60px;"></div>
           								<div class="row"><input type="file"	id="brandPic" style="margin-left:55px;margin-top:5px;"></div>
             						</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取 消</button>
								<button id="submitEditEmp" type="button" class="btn btn-primary">添 加
							</button>
							</div>
						</div>
					</div>
				</div>
				<div class="modal fade" id="addModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel">
					<div class="modal-dialog" style="width: 450px !important;"
						role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="exampleModalLabel">添加员工</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-md-6">
										<div class="row"
											style="padding-left: 20px; padding-bottom: 5px;">
											<label for="recipient-name" style="float: left;"
												class="control-label">姓名：</label><input id="empName" type="text"
												style="width: 70%;" class="form-control" id="recipient-name">
										</div>
										<div class="row"
											style="padding-left: 20px; padding-bottom: 5px;">
											<label for="recipient-name" style="float: left;"
												class="control-label">年龄：</label><input id="empAge" type="text"
												style="width: 70%;" class="form-control" id="recipient-name">
										</div>
										<div class="row"
											style="padding-left: 20px; padding-bottom: 10px;">
											<label for="recipient-name" style="float: left;"
												class="control-label">性别：</label><input id="empSex" type="text"
												style="width: 70%;" class="form-control" id="recipient-name">
										</div>
										<div class="row"
											style="padding-left: 20px; padding-bottom: 10px;">
											<label for="recipient-name" style="float: left;"
												class="control-label">所在省：</label> <select id="province"
												style="width: 62%;" class="form-control">
												<option value= "" data-id="0">--选择省份--</option>
											</select>
										</div>
										<div class="row"
											style="padding-left: 20px; padding-bottom: 5px;">
											<label for="recipient-name" style="float: left;"
												class="control-label">所在市：</label> <select id="city"
												style="width: 62%;" class="form-control">
												<option value= "" data-id="0">--选择城市--</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
									<div>
            							<div class="row"><label style="text-align: center;font-size:16px;margin-left:105px;">头  像</label></div>
            							<div class="row"><img id="headImg" class="head-img" style="border-width:3px;width:120px;height:150px;margin-left:60px;"></div>
           								<div class="row"><input type="file"	id="brandPic" style="margin-left:55px;margin-top:5px;"></div>
             						</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">取 消</button>
								<button id="submitEmp" type="button" class="btn btn-primary">添 加
							</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<script src="bootstrap/js/jquery-1.11.0.min.js"></script>
			<script src="bootstrap/js/bootstrap.min.js"></script>
			<script type="text/javascript">
			$("#search_submit").click(function(){
				var Search_empName = $("#SearchByEmpName").val();
				
				$.ajax({
					async:false,
					url : '/managerSystem/SearchEmployee',
					type : 'POST',
					data:{empName:Search_empName},
					success : function(data) {
						console.log("成功");
					},
					error : function() {
						alert("EditCity System error");
					}
				});
			})
			
			
			$('#submitEditEmp').click(function(){
				var emp_Id =$("#editEmpName").attr("data-id");
				var emp_Name = $("#editEmpName").val();
				
				var emp_Age = $("#editEmpAge").val();
				
				var emp_Sex = $("#editEmpSex").val();
				
				var head_Img = $("#editHeadImg").attr("src");
				var city= $("#editCity option:selected").attr("data-id");
				var province= $("#editProvince option:selected").attr("data-id");
				//console.log(emp_Id+","+emp_Name+","+emp_Age+","+emp_Sex+","+head_Img+","+city+","+province);
				console.log("id:"+emp_Id+"姓名："+emp_Name+",年龄："+emp_Age+",性别："+emp_Sex+",头像："+head_Img+",城市："+city+",省份："+province);
				$.ajax({
					async:false,
					url : '/managerSystem/seveEditEmp',
					type : 'PUT',
					data:{empId:emp_Id,empName:emp_Name,empAge:emp_Age,empSex:emp_Sex,empHeadPortrait:head_Img,city:city,province:province},
					success : function(data) {
							alert("修改成功！返回值："+data.list)
							window.location.href="listEmployee";
					},
					error : function() {
						alert("EditCity System error");
					}
				});
			})
			
			function editEmp(index){
				
				var emp_Id = index;
				$.ajax({
					async:false,
					url : '/managerSystem/editEmployee',
					type : 'post',
					data:{empId:emp_Id},
					success : function(data) {	
						var edit_EmpData = data.list;
						var city_Province = data.cityProvince;
						$("#editEmpName").attr("data-id",index);
						$("#editEmpName").val(edit_EmpData.empName);
						$("#editEmpAge").val(edit_EmpData.empAge);
						$("#editEmpSex").val(edit_EmpData.empSex);
						$("#editProvince").val(edit_EmpData.province);
						$("#editCity").val(edit_EmpData.city);
						$("#editHeadImg").attr('src',edit_EmpData.empHeadPortrait);
						$("#editCity").val(edit_EmpData.city);
						$("#editProvince").empty();
						$("#editCity").empty();
						$("#editProvince").append("<option value='"+city_Province.provinceName+"' data-id='"+city_Province.pId+"'>"+city_Province.provinceName+"</option>");
						$("#editCity").append("<option value='"+city_Province.cityName+"' data-id='"+city_Province.cId+"'>"+city_Province.cityName+"</option>");
						GetProvince();
					},
					error : function() {
						alert("EditEmp System error");
					}
				});
			}
			
			function GetProvince(){
				$.ajax({
					async:false,
					url : '/managerSystem/listProvince',
					type : 'post',
					success : function(data) {
						$("#editProvince").empty();
						var prolist = data.list;
						for(var i= 0;prolist.length;i++){
						$("#editProvince").append("<option value='"+prolist[i].provinceName+"' data-id='"+prolist[i].id+"'>"+prolist[i].provinceName+"</option>");
						}
					},
					error : function() {
						alert("Province System error");
					}
				});
				
			}
			
			$("#editProvince").change(function(){
				var option = $("#editProvince option:selected");
				var value = option.data("id")
				console.log("-----"+value+"-----");
				$.ajax({
					async:false,
					url : '/managerSystem/listCity',
					type : 'post',
					data:{id:value},
					success : function(data) {
						$("#editCity").empty();
						$("#editCity").append("<option value= '' data-id='0'>--选择城市--</option>")
						var citylist = data.list;
						for(var i= 0;citylist.length;i++){
						$("#editCity").append("<option value='"+citylist[i].cityName+"' data-id='"+citylist[i].id+"'>"+citylist[i].cityName+"</option>");
						}
							alert(citylist[0].id+":"+citylist[0].cityName)
					},
					error : function() {
						alert("City System error");
					}
				});
			})
			
			$('#submitEmp').click(function(){
				var emp_Name = $("#empName").val();
				var emp_Age = $("#empAge").val();
				var emp_Sex = $("#empSex").val();
				var head_Img = $("#headImg").attr("src");
				var province= $("#province option:selected").attr("data-id");
				var city= $("#city option:selected").attr("data-id");
				console.log("姓名："+empName+",年龄："+empAge+",性别："+empSex+",头像："+headImg+",省份："+province+",城市："+city);
				$.ajax({
					async:false,
					url : '/managerSystem/addEmp',
					type : 'post',
					data:{empName:emp_Name,empAge:emp_Age,empSex:emp_Sex,empHeadPortrait:head_Img,province:province,city:city},
					success : function(data) {		
						if(data.list==1){
							alert("添加成功！返回值："+data.list)
							window.location.href="listEmployee";
						}else{
							alert("添加失败！")
						}
					},
					error : function() {
						alert("City System error");
					}
				});
			})
			
			$('#brandPic').on('change',function(){
			    // 如果没有选择图片 直接退出
			    if(this.files.length <=0){
			        return false;
			    }
			    // 图片上传到服务器
			    var file = this.files[0];
			    var formData = new FormData();
			    // 服务端要求参数是 pic1 
			    formData.append('file',file);
			    $.ajax({
			        url:'/managerSystem/upPic',
			        type:'post',
			        data:formData,
			        cache: false, //上传文件不需要缓存
			        processData: false, // 告诉jQuery不要去处理发送的数据
			        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
			        success:function(data){
			        	console.log(data.list);
			        	//var a = data.list;
			            // 设置图片预览功能
			            $('.head-img').attr('src',data.list);
			        },
			        error : function() {
						alert("upPic System error!！");
					}
			    })
			})
			
			function Province(){
				$("#addEmp").click(function() {
					$.ajax({
						async:false,
						url : '/managerSystem/listProvince',
						type : 'post',
						success : function(data) {
							$("#province").empty();
							$("#province").append("<option value= '' data-id='0'>--选择省份--</option>")
							var prolist = data.list;
							for(var i= 0;prolist.length;i++){
							$("#province").append("<option value='"+prolist[i].provinceName+"' data-id='"+prolist[i].id+"'>"+prolist[i].provinceName+"</option>");
							}
						},
						error : function() {
							alert("Province System error");
						}
					});
				});
				
			}
				$(document).ready(function() {

					Province();
					$("#province").change(function(){
						var option = $("#province option:selected");
						var value = option.data("id")
						console.log("-----"+value+"-----");
						$.ajax({
							async:false,
							url : '/managerSystem/listCity',
							type : 'post',
							data:{id:value},
							success : function(data) {
								$("#city").empty();
								$("#city").append("<option value= '' data-id='0'>--选择城市--</option>")
								var citylist = data.list;
								for(var i= 0;citylist.length;i++){
								$("#city").append("<option value='"+citylist[i].cityName+"' data-id='"+citylist[i].id+"'>"+citylist[i].cityName+"</option>");
								}
									alert(citylist[0].id+":"+citylist[0].cityName)
							},
							error : function() {
								alert("City System error");
							}
						});
					})
				});
				
				
			</script>
</body>
</html>