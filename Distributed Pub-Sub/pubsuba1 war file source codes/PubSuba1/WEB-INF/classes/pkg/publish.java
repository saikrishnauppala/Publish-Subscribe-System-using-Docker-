package pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "publish")
public class publish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	   System.out.println("in pulish");
		PrintWriter out=response.getWriter();
	       		out.print("Topic:      "+request.getParameter("topic")+"\n");
			out.print("Message:    "+request.getParameter("message"));
			out.print("\nSent to Subscribers \n");
			System.out.println("topic is"+request.getParameter("topic"));
			if(request.getParameter("topic").equals("politics") ||request.getParameter("topic").equals("food") ||request.getParameter("topic").equals("technology") ){
		broker1.pr(request,response,out);}
			else{
				broker2.pr(request, response, out);
			}
		
	}
}