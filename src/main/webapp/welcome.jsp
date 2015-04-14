<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Welcome Page</title>
</head>
<body>
<div align="center">
    <h3>Welcome!</h3>

    <p>First Name:<s:property value="name"></s:property> <br/>

    <p>Last Name: <s:property value="surname"></s:property><br/>

    <p>Phone: <s:property value="phone"></s:property><br/>

    <p>City: <s:property value="city"></s:property><br/>

    <p>Address: <s:property value="address"></s:property><br/>

    <p>Registration date: <%= new java.util.Date()%> <br/>
</div>
</body>
</html>