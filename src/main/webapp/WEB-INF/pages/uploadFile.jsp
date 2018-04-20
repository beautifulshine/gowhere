<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>上传单个文件示例</title>  
  
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css" />  
</head>  
<body>  
<div align="center">  
  
<h1>上传附件</h1>  
<form method="post" action="./doUpload" enctype="multipart/form-data">  
<input type="file" name="file"/>  
<button type="submit" >提交</button>  
</form> 

<form name="serForm" action="./fileUpload" method="post"  enctype="multipart/form-data">
<h1>采用流的方式上传文件</h1>
<input type="file" name="file">
<input type="submit" value="upload"/>
</form>
 
<form name="Form2" action="./fileUpload2" method="post"  enctype="multipart/form-data">
<h1>采用multipart提供的file.transfer方法上传文件</h1>
<input type="file" name="file">
<input type="submit" value="upload"/>
</form>
 
<form name="Form2" action="./springUpload" method="post"  enctype="multipart/form-data">
<h1>使用spring mvc提供的类的方法上传文件</h1>
<input type="file" name="file">
<input type="submit" value="upload"/>
</form> 
</div>  
</body>  
</html>  