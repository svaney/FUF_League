<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ page import="model.mainclasses.Lists_DEO" %>
<html>
<head>
    <link rel="icon" href="../images/design/freeuniLogo.png" type="image/x-icon">
	<link rel="stylesheet" href="../css/CreatePlayer.css" />
	<script type="text/javascript" src="../js/CreatePlayer.js"></script> 
</head>
<body>
<form action="" method="post" target="_self" accept-charset="utf-8">
<table>
  <tr>
    <td>სახელი:</td>
    <td><input name="firstName" type="text" placeholder="მოთამაშის სახელი" /></td>
  </tr>
  <tr>
    <td>გვარი:</td>
    <td><input name="lastName" type="text" placeholder="მოთამაშის გვარი" /></td>
  </tr>
  <tr>
    <td>მეტსახელი:</td>
    <td><input name="nickName" type="text" placeholder="მოთამაშის მეტსახელი" /></td>
  </tr>
  <tr>
    <td>დაბადების თარიღი:</td>
    <td><input name="birthDate" type="date"/></td>
  </tr>
  <tr>
    <td>სტატუსი:</td>
    <td><select name="graduated">
			<option value="N">სტუდენტი</option>
			<option value="Y">კურსდამთავრებული</option>
			<option value="Y">ადმინისტრაცია</option>
			<option value="Y">ყოფილი სტუდენტი</option>
		</select>
	</td>
  <tr>
  <tr>
    <td>სკოლა:</td>
    <td><select name="school">
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
    		<option value="2013">2013</option>
    		<%for(int i = 2012; i>1950; i--){ %>
				<option value="<%=i%>"><%=i%></option>
			<%} %>
		</select>
	</td>
  </tr>
  <tr>
    <td>სიმაღლე:</td>
    <td><select name="heigth">
    		<option value="">სანტიმეტრებში</option>
    		<%for(int i = 150; i<211; i++){ %>
				<option value="<%=i%>"><%=i%> სმ.</option>
			<%} %>
		</select>
	</td>
  </tr>
  <tr>
    <td>წონა:</td>
    <td><select name="weigth">
    		<option value="">კილოგრამებში</option>
    		<%for(int i = 50; i<150; i++){ %>
				<option value="<%=i%>"><%=i%> კგ.</option>
			<%} %>
		</select>
	</td>
  </tr>
  <tr>
    <td>დომინანტი ფეხი:</td>
    <td><select name="foot">
    		<option value="R">მარჯვენა</option>
			<option value="L">მარცხენა</option>
		</select>
	</td>
  </tr>
  <tr>
    <td>პოზიცია:</td>
    <td><select name="position">
    		<option value="">უცნობია</option>
    		<%for(int i = 0; i < Lists_DEO.positions().length; i++){ %>
				<option value="<%=Lists_DEO.positions()[i]%>"><%=Lists_DEO.positions()[i]%></option>
			<%} %>
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