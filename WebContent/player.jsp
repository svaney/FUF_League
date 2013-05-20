<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="model.mainclasses.Player" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<%
	//ტემპლეიტი, ცხადია, არ არის საბოლოო.
	String id =  request.getParameter("id");
	String name = Player.getName(id);
	String family = Player.getFamily(id);
	double max = 10;
%>

<title><%=name+" "+family %></title>
<style type="text/css">
<!--
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background-color: #666666;
	/* [disabled]margin: 0; */
	padding: 0;
	color: #000;
	font-size: 15px;
	background-image: url();
	background-repeat: no-repeat;
}
/* ~~ Element/tag selectors ~~ */
ul, ol, dl { /* Due to variations between browsers, it's best practices to zero padding and margin on lists. For consistency, you can either specify the amounts you want here, or on the list items (LI, DT, DD) they contain. Remember that what you do here will cascade to the .nav list unless you write a more specific selector. */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* removing the top margin gets around an issue where margins can escape from their containing block. The remaining bottom margin will hold it away from any elements that follow. */
	padding-right: 15px;
	padding-left: 15px; /* adding the padding to the sides of the elements within the blocks, instead of the block elements themselves, gets rid of any box model math. A nested block with side padding can also be used as an alternate method. */
}
a img { /* this selector removes the default blue border displayed in some browsers around an image when it is surrounded by a link */
	border: none;
}
/* ~~ Styling for your site's links must remain in this order - including the group of selectors that create the hover effect. ~~ */
a:link {
	color: #42413C;
	text-decoration: underline; /* unless you style your links to look extremely unique, it's best to provide underlines for quick visual identification */
}
a:visited {
	color: #6E6C64;
	text-decoration: underline;
}
a:hover, a:active, a:focus { /* this group of selectors will give a keyboard navigator the same hover experience as the person using a mouse. */
	text-decoration: none;
}
/* ~~ This fixed width container surrounds all other blocks ~~ */
.container {
	width: 960px;
	background-color: #FFFFFF;
	margin: 0 auto; /* the auto value on the sides, coupled with the width, centers the layout */
}
/* ~~ The header is not given a width. It will extend the full width of your layout. ~~ */
header {
	background-color: #990000;
}
/* ~~ These are the columns for the layout. ~~ 

1) Padding is only placed on the top and/or bottom of the block elements. The elements within these blocks have padding on their sides. This saves you from any "box model math". Keep in mind, if you add any side padding or border to the block itself, it will be added to the width you define to create the *total* width. You may also choose to remove the padding on the element in the block element and place a second block element within it with no width and the padding necessary for your design.

2) No margin has been given to the columns since they are all floated. If you must add margin, avoid placing it on the side you're floating toward (for example: a right margin on a block set to float right). Many times, padding can be used instead. For blocks where this rule must be broken, you should add a "display:inline" declaration to the block element's rule to tame a bug where some versions of Internet Explorer double the margin.

3) Since classes can be used multiple times in a document (and an element can also have multiple classes applied), the columns have been assigned class names instead of IDs. For example, two sidebar blocks could be stacked if necessary. These can very easily be changed to IDs if that's your preference, as long as you'll only be using them once per document.

4) If you prefer your nav on the left instead of the right, simply float these columns the opposite direction (all left instead of all right) and they'll render in reverse order. There's no need to move the blocks around in the HTML source.

*/
.sidebar1 {
	float: left;
	width: 180px;
	background-color: #0033CC;
	padding-bottom: 10px;
}
.content {
	padding: 10px 0;
	width: 600px;
	float: left;
	border-bottom: solid 1px;
	border-top: solid 2px;
}
aside {
	float: left;
	width: 180px;
	background-color: #003399;
	padding: 10px 0;
}

/* ~~ This grouped selector gives the lists in the .content area space ~~ */
.content ul, .content ol {
	padding: 0 15px 15px 40px; /* this padding mirrors the right padding in the headings and paragraph rule above. Padding was placed on the bottom for space between other elements on the lists and on the left to create the indention. These may be adjusted as you wish. */
}

/* ~~ The navigation list styles (can be removed if you choose to use a premade flyout menu like Spry) ~~ */
ul.nav {
	list-style: none; /* this removes the list marker */
	border-top: 1px solid #666; /* this creates the top border for the links - all others are placed using a bottom border on the LI */
	margin-bottom: 15px; /* this creates the space between the navigation on the content below */
}
ul.nav li {
	border-bottom: 1px solid #666; /* this creates the button separation */
}
ul.nav a, ul.nav a:visited { /* grouping these selectors makes sure that your links retain their button look even after being visited */
	padding: 5px 5px 5px 15px;
	display: block; /* this gives the link block properties causing it to fill the whole LI containing it. This causes the entire area to react to a mouse click. */
	width: 160px;  /*this width makes the entire button clickable for IE6. If you don't need to support IE6, it can be removed. Calculate the proper width by subtracting the padding on this link from the width of your sidebar container. */
	text-decoration: none;
	background-color: #C6D580;
}
ul.nav a:hover, ul.nav a:active, ul.nav a:focus { /* this changes the background and text color for both mouse and keyboard navigators */
	background-color: #ADB96E;
	color: #FFF;
}

/* ~~ The footer ~~ */
footer {
	padding: 10px 0;
	background-color: #CCC49F;
	position: relative;/* this gives IE6 hasLayout to properly clear */
	clear: both; /* this clear property forces the .container to understand where the columns end and contain them */
}
/* ~~ Miscellaneous float/clear classes ~~ */
.fltrt {  /* this class can be used to float an element right in your page. The floated element must precede the element it should be next to on the page. */
	float: right;
	margin-left: 8px;
}
.fltlft { /* this class can be used to float an element left in your page. The floated element must precede the element it should be next to on the page. */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* this class can be placed on a <br /> or empty block element as the final element following the last floated block (within the .container) if the footer is removed or taken out of the .container */
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}

#progressbar1 {
  background-color: grey;
  border-radius: 13px;
  padding: 3px;
}

#progressbar1 div {
<% double div1 = (Player.getSpeed(id)/max)*100;%>
   background-color: <%if(div1>=85){%>green<%}else if(div1>=70){%>yellow<%}else if(div1>=50){%>orange<%}else{%>red<%}%>;
   width: <%=div1%>%;
   height: 20px;
   border-radius: 10px;
}

#progressbar2 {
  background-color: grey;
  border-radius: 13px;
  padding: 3px;
}

#progressbar2 div {
<% double div2 = (Player.getControl(id)/max)*100;%>
   background-color: <%if(div2>=85){%>green<%}else if(div2>=70){%>yellow<%}else if(div2>=50){%>orange<%}else{%>red<%}%>;
   width: <%=div2%>%;
   height: 20px;
   border-radius: 10px;
}

#progressbar3 {
  background-color: grey;
  border-radius: 13px;
  padding: 3px;
}

#progressbar3 div {
<% double div3 = (Player.getHeading(id)/max)*100;%>
   background-color: <%if(div3>=85){%>green<%}else if(div3>=70){%>yellow<%}else if(div3>=50){%>orange<%}else{%>red<%}%>;
   width: <%=div3%>%;
   height: 20px;
   border-radius: 10px;
}

/*HTML 5 support - Sets new HTML 5 tags to display:block so browsers know how to render the tags properly. */
header, section, footer, aside, article, figure {
	display: block;
}
-->
</style><!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]--></head>

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
 <table class="designLayout">
    <tr>
        <td>
            <div>
                <img src="images/<%out.print(Player.getAvatar(id)); %>" id="avatar" width="211" height="236"/>
            </div>
        </td>
        <td>
            <div>
                <table >
                  <tr><td class="Label">სახელი:</td>
			      <td class="Value"><strong><%=name+" "+family %></strong></td>
			      <%if(Player.getNick(id)!=null){%>
			      <tr><td class="Label">მეტსახელი:</td>
			      <td class="Value"><%=Player.getNick(id) %></td></tr>
			      <%}%>
			      <tr><td class="Label">დაბადების თარიღი:</td>
			      <td class="Value"><%=Player.getBirth(id) %></td></tr>
			  	  <tr><td class="Label">სკოლა:</td>
			      <td class="Value"><%=Player.getSchool(id) %></td></tr>   
			  	  <tr><td class="Label">კურსი:</td>
			      <td class="Value"><%=Player.getLevel(id) %></td></tr>   
			      <tr><td class="Label">სიმაღლე:</td>
			      <td class="Value"><%=Player.getHeigth(id) %> სმ.</td></tr>
			      <tr><td class="Label">წონა:</td>
			      <td class="Value"><%=Player.getWeight(id) %> კგ.</td></tr>
			      <tr><td class="Label">პოზიცია:</td>
			      <td class="Value"><%=Player.getPosition(id) %></td></tr>
			      <tr><td class="Label">ნომერი:</td>
			      <td class="Value"><%=Player.getNumber(id) %></td></tr>   
			      <%if(Player.getPage(id)!=null){%>
			      <tr><td></td><td class="Value"><a href="<%=Player.getPage(id) %>" target="new">ოფიციალური გვერდი</a></td></tr>
			      <%}%>      
          </table>
        </div>
    </td>
</tr>
</table>
</article>
            <div>
            <%//გუნდის ლოგო მაქვს პირდაპირ მითითებული. დასრულებულ ვერსიაში კი გუნდის ლოგოს უნდა ვიძახებდე გუნდის სახელის მიხედვით%>
              <a href="homepage.jsp"><img src="images/team_000.png" width="60" height="60" /><%=Player.getTeam(id) %></a>
      </div>
</section>
<br></br>
    <section>
      <h2>მოთამაშის რეიტინგი</h2>
      <table>
        <tr>
          <td width="180"><p>სისწრაფე</p></td>          
          <td width="318"> <div id="progressbar1"><div></div></div></td>
          <td width="59"><blockquote>
            <p><%=Player.getSpeed(id)%></p>
          </blockquote></td>
        </tr>
        <tr>
          <td><p>ბურთის ფლობა</p></td>
          <td width="318"> <div id="progressbar2"><div></div></div></td>
          <td width="59"><blockquote>
            <p><%=Player.getControl(id) %></p>
          </blockquote></td>
        </tr>
        <tr>
          <td><p>თავით თამაში</p></td>
          <td width="318"> <div id="progressbar3"><div></div></div></td>
          <td width="59"><blockquote>
            <p><%=Player.getHeading(id) %></p>
          </blockquote></td>
        </tr>
      </table>
    </section>
    <section>
      <h2>ფეხბურთელის შესახებ</h2>
      <p>აქ დაიდება დოსიე (მე შევადგენ, ძირითადად ლაზღანდარული ხასიათისაა), ცხადია, თუ არსებობს</p>
      <p>[გასაკეთებელი!]</p>  
    </section>
    <section>
      <h3>სტატისტიკა</h3>
      <p>აქ დაიდება სტატისტიკა, ცხადია, თუ არსებობს</p>
      <p>[გასაკეთებელი]</p>    
    </section>
 </article>
  <aside>
    <h4><%=Player.getTeam(id)%></h4>
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