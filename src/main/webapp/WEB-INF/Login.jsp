<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户登陆与用户信息错误重新登陆</title>
	
</head>
  <body>
  	<form method="POST" action="login">
  	<center>${message}</center>
    <table align="center">
    	<tr>
    		<td>用户名：</td>
   		  <td><input name="username" type="text"></td>
    	</tr>
    	<tr>
    		<td>密&nbsp;&nbsp;码：</td>
   		  <td><input name="password" type="password"></td>
    	</tr>
    	
    	<tr>
    	<br/><br/>
    		<td>验证码：</td>
                <td>
              	    <input	type="text" name="checkCode" />
					<img src="<%=basePath%>/verifyCode" onclick=flushCheckCode(this) alt="点击刷新验证码" style="cursor: hand" />
                </td>
		<br/><br/>
		</tr>
				
		<tr>
    		<td colspan="2" align="center">
    			<input type="submit" value="登录">
    			<input type="reset" value="重置">
   		    </td>
    	</tr>
    </table>
    </form>
    
    <script type="text/javascript">
		function flushCheckCode(obj) {
			obj.src = (obj.src + '?' + new Date())
		}
	</script>
  </body>
</html>
