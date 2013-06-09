package controller.matches;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.mainclasses.Lists_DEO;
import model.mainclasses.Team;
import model.mainclasses.Team_Ruska;

/**
 * Servlet implementation class MatchList
 */
@WebServlet("/MatchList")
public class MatchList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<model.mainclasses.Match> matches =  Lists_DEO.getAllMatches();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\""
		+ " \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
		out.println("<head>");
		out.println("<title>List of Matches</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>List of Matches By Date</h1><br>");
		for(int i=0;i<matches.size();i++){
			out.println("<li>");
			int[] teamIDs = matches.get(i).getTeamIDs();
//			 es unda iyos wesit
//			model.mainclasses.Team team1 = new model.mainclasses.Team_Ruska(teamIDs[0]);
//			model.mainclasses.Team team2 = new model.mainclasses.Team_Ruska(teamIDs[1]);
//			out.println("<a href=\""+request.getContextPath()+"/EditMatch?id="+matches.get(i).getMatchID()+"\">"+matches.get(i).getDate()+" "+team1.getName()+" vs "+team2.getName()+"</a>");
// es wasashlelia
			out.println("<a href=\""+request.getContextPath()+"/EditMatch?id="+matches.get(i).getMatchID()+"\">"+matches.get(i).getDate()+" "+teamIDs[0]+" vs "+teamIDs[1]+"</a>");
			out.println("</li>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
