<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="model.mainclasses.Player_DEO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%Player_DEO card = (Player_DEO) request.getAttribute(request.getParameter("playerID"));%>
<body>
		<table>
 			<tr>
 				<td>
     <table class="excel1">
        <tr><img src="images/players/avatar_001.png" height="320" width="240"/></tr>
        <tr style="height:15.75pt;">
          <td style="height:15.75pt;"><img alt="logo_001" src="images/teams/logo_001.png" height="42" width="42"></td>
          <td class="excel5">მფრინავი ჰოლანდიელი</td>
        </tr>
      </table>
 	</td>
 	<td>
     <table class="excel1">
        <tr style="height:18.75pt;">
          <td class="excel2" width="162" style="width:122pt;">სახელი:</td>
          <td class="excel4" width="125" style="width:94pt;"><%=card.getFirstName()+" "+card.getLastName()%></td>
        </tr>
        <tr style="height:18.75pt;">
          <td class="excel2" style="height:18.75pt;">მეტსახელი:</td>
          <td class="excel3"><%=card.getNickname()%></td>
        </tr>
        <tr style="height:18.75pt;">
          <td class="excel2" style="height:18.75pt;">დაბადების თარიღი:</td>
          <td class="excel3" align="right"><%=card.getBirthDate()%></td>
        </tr>
        <tr style="height:18.75pt;">
          <td class="excel2" style="height:18.75pt;">სკოლა:</td>
          <td class="excel3"><%=card.getSchool()%></td>
        </tr>
        <tr style="height:18.75pt;">
          <td class="excel2" style="height:18.75pt;">კურსი:</td>
          <td class="excel3" align="right"><%=card.getUniCurrentCourse()%></td>
        </tr>
        <tr style="height:18.75pt;">
          <td class="excel2" style="height:18.75pt;">ჩაბარების წელი:</td>
          <td class="excel3" align="right"><%=card.getUniStartYear()%></td>
        </tr>
        <tr style="height:18.75pt;">
          <td class="excel3" style="height:18.75pt;">სიმაღლე:</td>
          <td class="excel2" align="right"><%=card.getHeight()%></td>
        </tr>
        <tr style="height:18.75pt;">
          <td class="excel2" style="height:18.75pt;">წონა:</td>
          <td class="excel3" align="right"><%=card.getWeight()%></td>
        </tr>
        <tr style="height:15.75pt;">
          <td class="excel2" style="height:15.75pt;">პოზიცია:</td>
          <td class="excel3"><%=card.getPosition()%></td>
        </tr>
        <tr style="height:15.75pt;">
          <td class="excel2" style="height:15.75pt;">ნომერი</td>
          <td class="excel3" align="right">10</td>
        </tr>
        <tr style="height:15.0pt;">
          <td style="height:15.0pt;"></td>
          <td></td>
        </tr>
        <tr style="height:7.5pt;">
          <td style="height:7.5pt;"></td>
          <td></td>
        </tr>
        <tr style="height:31.5pt;">
          <td style="height:31.5pt;"></td>
          <td></td>
        </tr>
        <tr style="height:15.0pt;">
          <td style="height:15.0pt;"></td>
          <td></td>
        </tr>
      </table> 				
 				</td>
 			</tr>
 		</table>
</body>
</html>