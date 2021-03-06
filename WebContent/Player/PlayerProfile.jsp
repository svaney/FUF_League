<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ page import="model.mainclasses.Player_DEO" %>
<!doctype html>
<html>
<head>
    <link rel="icon" href="images/design/freeuniLogo.png" type="image/x-icon">
	<link rel="stylesheet" href="css/PlayerProfile.css" />
	<%Player_DEO player = (Player_DEO) request.getAttribute(request.getParameter("playerID"));%> <!-- სერვლეტი უნდა გადმოსცემდეს ამას -->
<head>
<title><%=player.getFirstName()+" "+player.getLastName()%></title>
</head>
<body>
<div class="container">
  <header>
  <p>ჰედერი</p>
   </header>
  <div>
    <aside>
    <h4>Side L</h4>
      <p> Side L</p>
    </aside>
 </div>
 <div>
  <article class="content">
  <div style="text-indent: 8px;">
    <h1><%=player.getFirstName()+" "+player.getLastName()%></h1>
  </div>
  <div>
    <section>
	<%@include file="PlayerCard.jsp" %>
    </section>
  </div>
	<%if(player.hasRatingBar()){ %>
	 	<div>
	    <section>
	 	<%@include file="PlayerRating.jsp" %>
	    </section>
	    </div>
 	<%} %>
    <div>
        <section>
      <h2>ბიოგრაფია</h2>
      <p>ტექსტი</p>
    </section>
    </div>
</article>
</div>
<div>
  <aside>
    <h4>Side R</h4>
    <p>Side R.</p>
  </aside>
 </div>
 <div>
  <footer>
    <p>ფუტერი</p>
  </footer>
  </div>
 </div>
</body>
</html>