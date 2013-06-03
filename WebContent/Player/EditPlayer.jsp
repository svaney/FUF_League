<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ page import="model.mainclasses.Player_DEO" %>
<html>
<head>
    <link rel="icon" href="../images/design/freeuniLogo.png" type="image/x-icon">
	<link rel="stylesheet" href="../css/CreatePlayer.css" />
	<%Player_DEO player = new Player_DEO(2); %>
</head>
<body>
<form action="" method="post" target="_self" accept-charset="utf-8">
<table>
  <tr>
    <td>სახელი:</td>
    <td><input name="firstName" type="text" placeholder="მოთამაშის სახელი" value=<%=player.getFirstName()%> /></td>
  </tr>
  <tr>
    <td>გვარი:</td>
    <td><input name="lastName" type="text" placeholder="მოთამაშის გვარი" value=<%=player.getLastName()%> /></td>
  </tr>
  <tr>
    <td>მეტსახელი:</td>
    <td><input name="nickName" type="text" placeholder="მოთამაშის მეტსახელი" value=<%if(player.getNickname()!=null){%>"<%=player.getNickname()%>"<%}else{%>""<%} %> /></td>
  </tr>
  <tr>
    <td>დაბადების თარიღი:</td>
    <td><input name="birthDate" type="date" value="<%=player.birthDate()%>"/></td>
  </tr>
  <tr>
    <td>სტატუსი:</td>
    <td><select name="graduated">
    		<%if(player.isStudent()){ %>
				<option value="N">სტუდენტი</option>
				<option value="Y">კურსდამთავრებული</option>
			<%}else{ %>
				<option value="Y">კურსდამთავრებული</option>
				<option value="N">სტუდენტი</option>
			<%} %>
			<option value="Y">ადმინისტრაცია</option>
			<option value="Y">ყოფილი სტუდენტი</option>
		</select>
	</td>
  <tr>
  <tr>
    <td>სკოლა:</td>
    <td><select name="school">
    		<option value="<%=player.getSchool()%>"><%=player.getSchool()%></option>
			<option value="ESM">ESM - მენეჯმენტი</option>
			<option value="LAW">LAW - სამართალი</option>
			<option value="ASIA-AFRICA">ASIA-AFRICA - აზია-აფრიკა</option>
			<option value="MACS">MACS - კომპიუტერული მეცნიერებები</option>
			<option value="PHYSICS">PHYSICS - ფიზიკა</option>
			<option value="LIBERAL ART">LIBERAL ART - მართვა</option>
			<option value="STAF">STAF - ადმინისტრაცია</option>
		</select>
	</td>
  <tr>
    <td>კურსი:</td>
    <td><select name="course">
    		<%if(player.isStudent()){%>
    			<option value="<%=player.getUniCurrentCourse()%>">
    			<%if(player.getUniCurrentCourse()==1){%>პირველი
    			<%}else if(player.getUniCurrentCourse()==2){%>მეორე
    			<%}else if(player.getUniCurrentCourse()==3){%>მესამე
    			<%}else {%>მეოთხე<%} %></option>
    		<%}else{ %>
    			<option value="" selected>არ ეხება</option>
    		<%}%>
			<option value="1">პირველი</option>
			<option value="2">მეორე</option>
			<option value="3">მესამე</option>
			<option value="4">მეოთხე</option>
		</select>
	</td>
  </tr>
  <tr>
    <td>ჩაბარების წელი:</td>
    <td><select name="course">
		<%for(int i = 2013; i>1950; i--){ %>
			<option value="<%=i%>"  <%if(i==player.getUniStartYear()){%>SELECTED<%} %>><%=i%></option>
		<%} %>
		</select>
	</td>
  </tr>
  <tr>
    <td>სიმაღლე:</td>
    <td><select name="heigth">
    		<option value="">სანტიმეტრებში</option>
    		<%for(int i = 150; i<211; i++){ %>
				<option value="<%=i%>" <%if(i==player.getHeight()){%>SELECTED<%} %>><%=i%> სმ.</option>
			<%} %>
		</select>
	</td>
  </tr>
  <tr>
    <td>წონა:</td>
    <td><select name="weigth">
    		<option value="">კილოგრამებში</option>
    		<%for(int i = 50; i<150; i++){ %>
				<option value="<%=i%>" <%if(i==player.getWeight()){%>SELECTED<%} %>><%=i%> კგ.</option>
			<%} %>
		</select>
	</td>
  </tr>
  <tr>
    <td>დომინანტი ფეხი:</td>
    <td><select name="foot">
    		<option value="R" <%if(player.getFoot().equals("მარჯვენა")){%>SELECTED<%} %>>მარჯვენა</option>
			<option value="L" <%if(player.getFoot().equals("მარცხენა")){%>SELECTED<%} %>>მარცხენა</option>
		</select>
	</td>
  </tr>
  <tr>
    <td>პოზიცია:</td>
    <td><select name="position">
    		<option value="">უცნობია</option>
			<option value="value">ჩასვი პოზიციების სია</option>
		</select>
	</td>
  </tr>
  <tr>
    <td>ნომერი:</td>
    <td><select name="number">
    		<option value="">არ აქვს</option>
			<%for(int i = 0; i<100; i++){ %>
				<option value="<%=i%>"><%=i%></option>
			<%} %>
		</select>
	</td>
  </tr>
  <tr>
    <td>გუნდი:</td>
    <td><select name="teamID"><option value="">თავისუფალი აგენტი</option>
			<option value="value">ჩასვი გუნდების სია</option>
		</select>
	</td>
  </tr>
</table>
</form>
</body>
</html>