<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<%int a=92; int b=40;%>
<body>
     <h2>მოთამაშის რეიტინგი</h2>
     <table class="ratingAtr">
     <tr>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">სისწრაფე</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getSpeed()%>%; background-color: <%if(player.getSpeed()<40){%>#f27011<%}else if(player.getSpeed()<75){%>#f2b01e<%}else if(player.getSpeed()<85){%>#f2d31b<%}else if(player.getSpeed()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getSpeed() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">დრიბლინგი</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getDribbling()%>%; background-color: <%if(player.getDribbling()<40){%>#f27011<%}else if(player.getDribbling()<75){%>#f2b01e<%}else if(player.getDribbling()<85){%>#f2d31b<%}else if(player.getDribbling()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getDribbling() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">თავით თამაში</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getHeading()%>%; background-color: <%if(player.getHeading()<40){%>#f27011<%}else if(player.getHeading()<75){%>#f2b01e<%}else if(player.getHeading()<85){%>#f2d31b<%}else if(player.getHeading()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getHeading() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">ართმევა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getTackling()%>%; background-color: <%if(player.getTackling()<40){%>#f27011<%}else if(player.getTackling()<75){%>#f2b01e<%}else if(player.getTackling()<85){%>#f2d31b<%}else if(player.getTackling()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getTackling() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     <tr>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">გამძლეობა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getDurability()%>%; background-color: <%if(player.getDurability()<40){%>#f27011<%}else if(player.getDurability()<75){%>#f2b01e<%}else if(player.getDurability()<85){%>#f2d31b<%}else if(player.getDurability()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getDurability() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">მოგერიება</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getShotStoping()%>%; background-color: <%if(player.getShotStoping()<40){%>#f27011<%}else if(player.getShotStoping()<75){%>#f2b01e<%}else if(player.getShotStoping()<85){%>#f2d31b<%}else if(player.getShotStoping()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getShotStoping() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">დარტყმა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getShooting()%>%; background-color: <%if(player.getShooting()<40){%>#f27011<%}else if(player.getShooting()<75){%>#f2b01e<%}else if(player.getShooting()<85){%>#f2d31b<%}else if(player.getShooting()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getShooting() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">სიმულაცია</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getDiving()%>%; background-color: <%if(player.getDiving()<40){%>#f27011<%}else if(player.getDiving()<75){%>#f2b01e<%}else if(player.getDiving()<85){%>#f2d31b<%}else if(player.getDiving()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getDiving() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     <tr>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">ძალა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getStrength()%>%; background-color: <%if(player.getStrength()<40){%>#f27011<%}else if(player.getStrength()<75){%>#f2b01e<%}else if(player.getStrength()<85){%>#f2d31b<%}else if(player.getStrength()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getStrength() %></td>
				</tr>
		     </table>	     
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">კრეატიულობა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getCreativity()%>%; background-color: <%if(player.getCreativity()<40){%>#f27011<%}else if(player.getCreativity()<75){%>#f2b01e<%}else if(player.getCreativity()<85){%>#f2d31b<%}else if(player.getCreativity()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getCreativity() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">შიშის ფაქტორი</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getFearFactor()%>%; background-color: <%if(player.getFearFactor()<40){%>#f27011<%}else if(player.getFearFactor()<75){%>#f2b01e<%}else if(player.getFearFactor()<85){%>#f2d31b<%}else if(player.getFearFactor()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getFearFactor() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">ფინიში</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getKillerInstinct()%>%; background-color: <%if(player.getKillerInstinct()<40){%>#f27011<%}else if(player.getKillerInstinct()<75){%>#f2b01e<%}else if(player.getKillerInstinct()<85){%>#f2d31b<%}else if(player.getKillerInstinct()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getKillerInstinct() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     <tr>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">მოედნის ხედვა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getVision()%>%; background-color: <%if(player.getVision()<40){%>#f27011<%}else if(player.getVision()<75){%>#f2b01e<%}else if(player.getVision()<85){%>#f2d31b<%}else if(player.getVision()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getVision() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">პასები</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getPassing()%>%; background-color: <%if(player.getPassing()<40){%>#f27011<%}else if(player.getPassing()<75){%>#f2b01e<%}else if(player.getPassing()<85){%>#f2d31b<%}else if(player.getPassing()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getPassing() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">პენალტი</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getDurability()%>%; background-color: <%if(player.getPenalty()<40){%>#f27011<%}else if(player.getPenalty()<75){%>#f2b01e<%}else if(player.getPenalty()<85){%>#f2d31b<%}else if(player.getPenalty()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getPenalty() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">ლიდერობა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getLidership()%>%; background-color: <%if(player.getLidership()<40){%>#f27011<%}else if(player.getLidership()<75){%>#f2b01e<%}else if(player.getLidership()<85){%>#f2d31b<%}else if(player.getLidership()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getLidership() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     <tr>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">მუშაობის ხარისხი</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getWorkRate()%>%; background-color: <%if(player.getWorkRate()<40){%>#f27011<%}else if(player.getWorkRate()<75){%>#f2b01e<%}else if(player.getWorkRate()<85){%>#f2d31b<%}else if(player.getWorkRate()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getWorkRate() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">პოზიციის შერჩევა</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getPositioning()%>%; background-color: <%if(player.getPositioning()<40){%>#f27011<%}else if(player.getPositioning()<75){%>#f2b01e<%}else if(player.getPositioning()<85){%>#f2d31b<%}else if(player.getPositioning()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getPositioning() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">გუნდის ერთგულება </td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getClubLoyalty()%>%; background-color: <%if(player.getClubLoyalty()<40){%>#f27011<%}else if(player.getClubLoyalty()<75){%>#f2b01e<%}else if(player.getClubLoyalty()<85){%>#f2d31b<%}else if(player.getClubLoyalty()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getClubLoyalty() %></td>
				</tr>
		     </table>
	     </td>
	     <td>
		     <table>
		     	<tr>
		     		<td width="85%">შეცდომის სიხშირე</td>
		     	</tr>
		     	<tr>
		     		<td>
		     			<div class="progress"><div class="progress-bar" style="width: <%=player.getMistakeFactor()%>%; background-color: <%if(player.getMistakeFactor()<40){%>#f27011<%}else if(player.getMistakeFactor()<75){%>#f2b01e<%}else if(player.getMistakeFactor()<85){%>#f2d31b<%}else if(player.getMistakeFactor()<90){%>#86e01e<%}else{%>#0C0<%}%>;"></div></div>
					</td>
						<td width="14%"><%=player.getMistakeFactor() %></td>
				</tr>
		     </table>
	     </td>
     </tr>
     </table>
</body>
</html>