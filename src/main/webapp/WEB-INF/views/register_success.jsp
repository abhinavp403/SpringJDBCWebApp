<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertion Successful</title>
<style type="text/css">
	span {
		display: inline-block;
		width: 200px;
		text-align: left;
	}
</style>
</head>
<body>
	<div align="center">
		<h2>Insertion Successful</h2>
		<span>Name: </span><span>${user.name}</span><br/>
		<span>Email: </span><span>${user.email}</span><br/>
		<span>Profession: </span><span>${user.profession}</span><br/>
		<span>Gender: </span><span>${user.gender}</span><br/>
		<span>Married? </span><span>${user.married}</span><br/>
	</div>
</body>
</html>