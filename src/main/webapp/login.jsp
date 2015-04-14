<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%-- Using Struts2 Dojo Ajax Tags --%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>

<html>
<head>
    <sx:head/>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Page</title>
</head>
<body>
<div align="center">
    <h3>Welcome User, please login below</h3>
    <s:form action="login" validate="true">
        <s:textfield name="name" label="First Name"></s:textfield>
        <s:textfield name="surname" label="Last Name"></s:textfield>
        <s:textfield name="phone" label="Phone"> </s:textfield>
        <s:textfield name="city" label="City"> </s:textfield>
        <s:textfield name="address" label="Address"> </s:textfield>

        <sx:datetimepicker name="dateBirthday" label="Format (dd-MMM-yyyy)"
                           displayFormat="dd-MMM-yyyy" value="todayDate">
        </sx:datetimepicker>

        <s:submit value="Sign up"></s:submit>
    </s:form>
</div>
</body>
</html>