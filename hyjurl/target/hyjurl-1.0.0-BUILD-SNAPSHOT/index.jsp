<%@ page language="java" contentType="text/HTML;charset=UTF-8" pageEncoding="UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<form method="post">

<h1>Shortening URL</h1>
<B>변환 전 URL : </B><input type="text" id="f_url" size="100" />
<button onclick="fnBtnClick()">변환</button>
<br/><br/>
<B>변환 후 URL : </B><input type="text" id="s_url" size="100" />


<script>
	function fnBtnClick()
	{
		
		alert("1");
	}
</script>
</form>
</body>
</html>
