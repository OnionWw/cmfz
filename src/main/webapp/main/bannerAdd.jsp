<%@ page pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function(){
		//初始化用户名框
		$("#addBannerFormTitle").textbox({
			required:true,
		});
		//初始化邮箱框
		$("#addBannerFormStatus").textbox({
			required:true,
		});
		$("#addBannerFormPubDate").datebox({
			editable:false,
			formatter:function(date){
				var y = date.getFullYear();
				var m = date.getMonth()+1;
				var d = date.getDate();
				var h = date.getHours();
				var t = date.getMinutes();
				var e = date.getSeconds();
				return y+"-"+m+"-"+d+" "+h+":"+t+":"+e;
			},
			parser:function(s){
				var t = Date.parse(s);
				if (!isNaN(t)){
					return new Date(t);
				} else {
					return new Date();
				}
			} 
		});
        $("#addBannerFormDescription").textbox({
            required:true,
        });
		$("#addUserFormSumbitBTN").linkbutton({
			iconCls:"icon-add",
			onClick:function(){
				$("#addBannerForm").form("submit",{
					url:"${pageContext.request.contextPath}/banner/insert",
					onSubmit:function(){
						return $("#addBannerForm").form("validate");
					},
					success:function(){
						$("#addBannerDialog").dialog("close");
						$.messager.show({
							title:"标题",
							msg:"保存成功！"
						});
						$("#dg").datagrid("load");
					}
				});
			},
		});
	});
</script>
<form id="addBannerForm" method="post" enctype="multipart/form-data">
	<input id="addBannerFormTitle" name="title"><br/>
	<input type="file" name="file1"/><br/>
	<input id="addBannerFormStatus" name="status"><br/>
	<input id="addBannerFormPubDate" name="pubDate"/><br/>
	<input id="addBannerFormDescription" name="description"/><br/>
	<a id="addUserFormSumbitBTN">提交</a>
</form>