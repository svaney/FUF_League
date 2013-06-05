<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="model.mainclasses.Lists_DEO" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>თავისუფალი უნივერსიტეტი - ფეხბურთი</title>

<body>
<%for(int i = 0; i < Lists_DEO.players().length; i++){%>
	<p><a href="PlayerProfileServlet?playerID=<%=Lists_DEO.players()[i][0]%>"> <input name="player<%=i%>" type=button value="<%=Lists_DEO.players()[i][1]%>"></input></a></p>
<%} %>
</body>
</html>