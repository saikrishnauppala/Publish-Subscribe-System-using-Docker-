package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "broker1")
public class broker1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	}
	 public static void pr(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	    {if(request.getParameter("topic").equals("politics") ||request.getParameter("topic").equals("food") ||request.getParameter("topic").equals("technology") ){
		 System.out.println("in broker 1 ");
	     String topi=request.getParameter("topic");
	     try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("after class.forname");
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/ds","root","root");
			Statement st = con.createStatement();
			System.out.println("Topic in broker"+topi);
			ResultSet rs = st.executeQuery("select subscriberlist from distributedhashtable where topic='"+topi+"';");
			if(rs.next())
			{
			      String subs= rs.getString("subscriberlist");
			      subs=subs.replaceAll(" ", "\n");
			      System.out.println(subs);
			      out.print(subs+"");
			      out.print("\n Notified by broker 1");
			}
		}
		catch(Exception e){
			System.out.println("DB Exception"+e);
			e.printStackTrace();
		}
	 
	    }
}}
