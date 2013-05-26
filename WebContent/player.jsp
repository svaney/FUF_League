<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="model.mainclasses.Player_DEO" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<%
	//ტემპლეიტი, ცხადია, არ არის საბოლოო.
	int playerID =  Integer.parseInt(request.getParameter("id"));
	Player_DEO player = new Player_DEO(playerID);
	String name = player.getFirstName();
	String family = player.getLastName();
	double max = 100;
%>
    <link href="PlayerProfile.css" rel="stylesheet" />
    <link rel="icon" href="images/design/freeuniLogo.png" type="image/x-icon">
<title><%=name+" "+family%></title>
<body>

<div class="container">
  <header>
	<h1>ეს არის "ჰედერი", რომელიც ჩვენი საიტის ყველა გვერდისთვის საერთო იქნება, ამიტომ მე ხელს არ ვახლებ</h1>
  	<br></br>
  </header>
  <div class="sidebar1">
    <ul class="nav">
      <li><a href="#"></a></li>
      <li><a href="#">სეზონი 2011</a></li>
      <li><a href="#">სეზონი 2012</a></li>
      <li><a href="#">სეზონი 2013</a></li>
    </ul>
    <aside>
      <p> ამ პანელს, ლბათ, გამოვიყენებთ რამეში</p>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
    </aside>
  <!-- end .sidebar1 --></div>
  <article class="content">
    <h1><%=name+" "+family%></h1>
  <section>
   	<article class="content">
		<table><tr>
			<td>
				<table>
					<tr>
						<td><img alt="avatar_001" src="/images/avatar_001.png" height="320" width="240"></td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
								   <td class="tableC12" width="42" style="height:31.5pt;width:32pt;">
								   	<img alt="logo_001" src="/images/logo_001.png" height="42" width="42">
								   </td>
								   <td class="tableC13" width="176" style="width:132pt;">მფრინავი ჰოლანდიელი</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
			<td style="width: 327.56px; height: 385.53px;">
				<table class="tableC21" style="position: relative; right: 0px; top: -55px;">
				  <col width="151" style="width:113pt;" />
				  <col width="114" style="width:86pt;" />
				  <tr style="height:16.5pt;">
					<td class="tableC22" width="151" style="height:16.5pt;width:113pt;">სახელი:</td>
					<td class="tableC23" width="114" style="width:86pt;">დავით გოჩავა</td>
				  </tr>
				  <tr style="height:16.5pt;">
					<td class="tableC22" style="height:16.5pt;">მეტსახელი:</td>
					<td class="tableC22">DEO</td>
				  </tr>
				  <tr style="height:16.5pt;">
					<td class="tableC22" style="height:16.5pt;">დაბადების თარიღი:</td>
					<td class="tableC22">3 მაისი, 1992</td>
				  </tr>
				  <tr style="height:16.5pt;">
					<td class="tableC22" style="height:16.5pt;">სკოლა:</td>
					<td class="tableC22">ESM</td>
				  </tr>
				  <tr style="height:16.5pt;">
					<td class="tableC22" style="height:16.5pt;">კურსი:</td>
					<td class="tableC22">მე-3 კურსი</td>
				  </tr>
				  <tr style="height:16.5pt;">
					<td class="tableC22" style="height:16.5pt;">ჩაბარების წელი:</td>
					<td class="tableC22">2010</td>
				  </tr>
				  <tr style="height:16.5pt;">
					<td class="tableC22" style="height:16.5pt;">სიმაღლე:</td>
					<td class="tableC22">172 სმ</td>
				  </tr>
				  <tr style="height:16.5pt;">
					<td class="tableC22" style="height:16.5pt;">წონა:</td>
					<td class="tableC22">58 კგ</td>
				  </tr>
				  <tr style="height:16.5pt;">
					<td class="tableC22" style="height:16.5pt;">პოზიცია:</td>
					<td class="tableC22">თავდამსხმელი</td>
				  </tr>
				  <tr style="height:16.5pt;">
					<td class="tableC22" style="height:16.5pt;">ნომერი გუნდში:</td>
					<td class="tableC22">10</td>
				  </tr>
				</table>
			</td>
		</tr>
		</table>
	</article>
            <div>
            
              <a href="homepage.jsp"><img src="images/team_000.png" width="60" height="60" />not implimented</a>
      </div>
</section>
</article>
  <aside>
    <h4><%="not implimented"%></h4>
    <p>აქ იქნება მოთამაშის გუნდის შემადგენლობა. აქედან შესაძლებელი უნდა იყოს გუნდელების პროფილში გადასვლა</p>
    <p>[გასაკეთებელი]</p>      
  </aside>
  <footer>
    <p>აქ ჩვეულებრივ საიტის შესახებ არის ინფორმაცია :შ ყველა გვერდისთვის საერთო იქნება</p>
    <address>
      Freeuni Football
    </address>
  </footer>
</div>
</body>
</html>