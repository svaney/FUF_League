<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ page import="model.mainclasses.Player_DEO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%Player_DEO card = (Player_DEO) request.getAttribute(request.getParameter("playerID"));%>
<body>
<table>
  <tr>
    <td class="CardLeftSide">
    <table width="100%">
  <tr>
    <td><img src="images/players/<%=card.getAvatar() %>" height="320" width="240"/></td>
  </tr>
  <tr>
    <td><table width="100%">
  <tr>
    <td><img alt="logo_001" src="images/teams/logo_001.png" height="42" width="42"></td>
    <td class="TableCentreText">მფრინავი ჰოლანდიელი</td>
  </tr>
</table>
</td>
  </tr>
</table>
</td>
    <td class="CardRigthSide">
      <table class="CardDefaultInfo" width="100%">
        <tr>
          <td>სახელი:</td>
          <td><strong><%=card.getFirstName()+" "+card.getLastName() %></strong></td>
        </tr>
        <tr>
        <%if(card.hasNickname()){%>
          <td>მეტსახელი:</td>
          <td><%=card.getNickname() %></td>
        </tr>
        <tr>
        <%} %>
          <td>დაბადების თარიღი:</td>
          <td><%=card.getBirthDate()%> (<%=card.getAge()%> წლის)</td>
        </tr>
        <tr>
          <td>სკოლა:</td>
          <td><%=card.getSchool() %></td>
        </tr>
        <tr>
        <%if(card.isStudent()){%>
          <td>კურსი:</td>
          <td><%=card.getUniCurrentCourseString() %></td>
        </tr>
        <tr>
          <td>ჩაბარების წელი:</td>
          <td><%=card.getUniStartYear() %></td>
        </tr>
        <tr>
        <%} %>
          <td>სიმაღლე:</td>
          <td><%=card.getHeightString() %></td>
        </tr>
        <tr>
          <td>წონა:</td>
          <td><%=card.getWeightString() %></td>
        </tr>
        <tr>
          <td>დომინანტი ფეხი:</td>
          <td><%=card.getFoot() %></td>
        </tr>
        <tr>
          <td>პოზიცია:</td>
          <td><%=card.getPosition() %></td>
        </tr>
        <tr>
          <td>ნომერი:</td>
          <td>10</td>
        </tr>
    </table>
</table>
</body>
</html>