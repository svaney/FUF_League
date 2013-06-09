<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ page import="model.mainclasses.Player_DEO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<%Player_DEO rating = (Player_DEO) request.getAttribute(request.getParameter("playerID"));%>
<body>
     <h2>მოთამაშის რეიტინგი</h2>
     <table class="ratingAtr">
     <tr>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">სისწრაფე</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getSpeed()%>%; background-color: <%if(rating.getSpeed()<40){%>#f27011<%}else if(rating.getSpeed()<75){%>#f2b01e<%}else if(rating.getSpeed()<85){%>#f2d31b<%}else if(rating.getSpeed()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getSpeed() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">დრიბლინგი</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getDribbling()%>%; background-color: <%if(rating.getDribbling()<40){%>#f27011<%}else if(rating.getDribbling()<75){%>#f2b01e<%}else if(rating.getDribbling()<85){%>#f2d31b<%}else if(rating.getDribbling()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getDribbling() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">თავით თამაში</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getHeading()%>%; background-color: <%if(rating.getHeading()<40){%>#f27011<%}else if(rating.getHeading()<75){%>#f2b01e<%}else if(rating.getHeading()<85){%>#f2d31b<%}else if(rating.getHeading()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getHeading() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">ართმევა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getTackling()%>%; background-color: <%if(rating.getTackling()<40){%>#f27011<%}else if(rating.getTackling()<75){%>#f2b01e<%}else if(rating.getTackling()<85){%>#f2d31b<%}else if(rating.getTackling()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getTackling() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     <tr>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">გამძლეობა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getDurability()%>%; background-color: <%if(rating.getDurability()<40){%>#f27011<%}else if(rating.getDurability()<75){%>#f2b01e<%}else if(rating.getDurability()<85){%>#f2d31b<%}else if(rating.getDurability()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getDurability() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">მოგერიება</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getShotStopping()%>%; background-color: <%if(rating.getShotStopping()<40){%>#f27011<%}else if(rating.getShotStopping()<75){%>#f2b01e<%}else if(rating.getShotStopping()<85){%>#f2d31b<%}else if(rating.getShotStopping()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getShotStopping() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">დარტყმა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getShooting()%>%; background-color: <%if(rating.getShooting()<40){%>#f27011<%}else if(rating.getShooting()<75){%>#f2b01e<%}else if(rating.getShooting()<85){%>#f2d31b<%}else if(rating.getShooting()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getShooting() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">სიმულაცია</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getDiving()%>%; background-color: <%if(rating.getDiving()<40){%>#f27011<%}else if(rating.getDiving()<75){%>#f2b01e<%}else if(rating.getDiving()<85){%>#f2d31b<%}else if(rating.getDiving()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getDiving() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     <tr>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">ძალა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getStrength()%>%; background-color: <%if(rating.getStrength()<40){%>#f27011<%}else if(rating.getStrength()<75){%>#f2b01e<%}else if(rating.getStrength()<85){%>#f2d31b<%}else if(rating.getStrength()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getStrength() %></td>
				</tr>
		     </table>	     
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">კრეატიულობა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getCreativity()%>%; background-color: <%if(rating.getCreativity()<40){%>#f27011<%}else if(rating.getCreativity()<75){%>#f2b01e<%}else if(rating.getCreativity()<85){%>#f2d31b<%}else if(rating.getCreativity()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getCreativity() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">შიშის ფაქტორი</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getFearFactor()%>%; background-color: <%if(rating.getFearFactor()<40){%>#f27011<%}else if(rating.getFearFactor()<75){%>#f2b01e<%}else if(rating.getFearFactor()<85){%>#f2d31b<%}else if(rating.getFearFactor()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getFearFactor() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">ფინიში</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getKillerInstinct()%>%; background-color: <%if(rating.getKillerInstinct()<40){%>#f27011<%}else if(rating.getKillerInstinct()<75){%>#f2b01e<%}else if(rating.getKillerInstinct()<85){%>#f2d31b<%}else if(rating.getKillerInstinct()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getKillerInstinct() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     <tr>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">მოედნის ხედვა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getVision()%>%; background-color: <%if(rating.getVision()<40){%>#f27011<%}else if(rating.getVision()<75){%>#f2b01e<%}else if(rating.getVision()<85){%>#f2d31b<%}else if(rating.getVision()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getVision() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">პასები</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getPassing()%>%; background-color: <%if(rating.getPassing()<40){%>#f27011<%}else if(rating.getPassing()<75){%>#f2b01e<%}else if(rating.getPassing()<85){%>#f2d31b<%}else if(rating.getPassing()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getPassing() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">პენალტი</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getDurability()%>%; background-color: <%if(rating.getPenalty()<40){%>#f27011<%}else if(rating.getPenalty()<75){%>#f2b01e<%}else if(rating.getPenalty()<85){%>#f2d31b<%}else if(rating.getPenalty()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getPenalty() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">ლიდერობა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getLidership()%>%; background-color: <%if(rating.getLidership()<40){%>#f27011<%}else if(rating.getLidership()<75){%>#f2b01e<%}else if(rating.getLidership()<85){%>#f2d31b<%}else if(rating.getLidership()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getLidership() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     <tr>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">მუშაობის ხარისხი</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getWorkRate()%>%; background-color: <%if(rating.getWorkRate()<40){%>#f27011<%}else if(rating.getWorkRate()<75){%>#f2b01e<%}else if(rating.getWorkRate()<85){%>#f2d31b<%}else if(rating.getWorkRate()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getWorkRate() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">პოზიციის შერჩევა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getPositioning()%>%; background-color: <%if(rating.getPositioning()<40){%>#f27011<%}else if(rating.getPositioning()<75){%>#f2b01e<%}else if(rating.getPositioning()<85){%>#f2d31b<%}else if(rating.getPositioning()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getPositioning() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">გუნდის ერთგულება </td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getClubLoyalty()%>%; background-color: <%if(rating.getClubLoyalty()<40){%>#f27011<%}else if(rating.getClubLoyalty()<75){%>#f2b01e<%}else if(rating.getClubLoyalty()<85){%>#f2d31b<%}else if(rating.getClubLoyalty()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getClubLoyalty() %></td>
				</tr>
		     </table>
	     </td>
	     <td width="25%">
		     <table>
		     	<tr>
		     		<td width="85%">შეცდომის სიხშირე</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=rating.getMistakeFactor()%>%; background-color: <%if(rating.getMistakeFactor()<40){%>#f27011<%}else if(rating.getMistakeFactor()<75){%>#f2b01e<%}else if(rating.getMistakeFactor()<85){%>#f2d31b<%}else if(rating.getMistakeFactor()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=rating.getMistakeFactor() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     </table>
</body>
</html>