<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="model.mainclasses.Lists_DEO" %>
<html>
<head>
<script
   type='text/javascript'
   src='js/ManagePlayer.js'>
</script>
<title>მოთამაშის მართვა</title>
</head>
<body>
<section>
<form action="EditPlayer" method=post>
<select id="selectedPlayer" name="selectedPlayer" size="<%=Lists_DEO.players().length%>">
<%for(int i = 0; i < Lists_DEO.players().length; i++){%>
	<option value=<%=Lists_DEO.players()[i][0]%>><%=Lists_DEO.players()[i][1]%></option>
<%} %>
</select>
<button type="submit">შესწორება</button>
</form>
<button type="button" onclick="addPlayerForm()">ახალი..</button>
</section>
<div id="addPlayer" style="display:none">
	<section>
		<%@include file="CreatePlayer.jsp" %>
	</section>
	<button type="button" onclick="addPlayerCancel()">გაუქმება</button>
</div>
</body>
</html>