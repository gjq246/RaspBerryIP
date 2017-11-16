<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>树莓派IP自动发现服务</title>
    </head>
    <body>

       <#include "/header.ftl" >
        
       <table border="1" align="center">
       <tr>
         <th>设备名称</th><th>设备IP</th><th>登录时间</th>
       <tr>
       <#list devicelist as device>
       <tr>
         <td>${device.DeviceName}</td><td>${device.DeviceIp}</td><td>${device.LoginTime}</td>
       </tr>
       </#list>
       </table>
      
      
       <#include "/footer.ftl" >
       
       <script type="text/javascript">  
		$(function(){         
		    //alert("Jquery 运行成功！");  
		});   
		 
		</script>
	
    </body>
</html>