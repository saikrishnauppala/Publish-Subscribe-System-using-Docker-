package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "subscribe")
public class subscribe extends HttpServlet
{
    private static final long serialVersionUID = 1L;
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	System.out.println("in subscriber");
	PrintWriter out = response.getWriter();
	out.print(request.getParameter("name") + " subscribed to");
	
	     try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/ds","root","root");
				Statement st = con.createStatement();
				ResultSet rs;
	if (request.getParameter("politics").equals("true"))
	   	    {
	    rs = st.executeQuery("select subscriberlist from distributedhashtable where topic= 'politics';");
		if(rs.next())
		{
		      String psubs= rs.getString("subscriberlist");
		      psubs=psubs+" "+request.getParameter("name");
		      st.executeUpdate("update distributedhashtable set subscriberlist='"+psubs+"'where topic='"+"politics"+"';");
		}
		else 
		{
		    String sql="insert into distributedhashtable (topic,subscriberlist) values(?,?)";
		    PreparedStatement statement = con.prepareStatement(sql);
		    statement.setString(1,"politics");
		    statement.setString(2,request.getParameter("name") );
		    statement.executeUpdate();
		}
	
	    out.print("\n politics");
	    }
	if (request.getParameter("food").equals("true"))
	    { rs = st.executeQuery("select subscriberlist from distributedhashtable where topic='" + "food';");
		if(rs.next())
		{
		      String psubs= rs.getString("subscriberlist");
		      psubs=psubs+" "+request.getParameter("name");
		      st.executeUpdate("update distributedhashtable set subscriberlist='"+psubs+"'where topic='"+ "food';");
		}
		else 
		{
		    String sql="insert into distributedhashtable (topic,subscriberlist) values(?,?)";
		    PreparedStatement statement = con.prepareStatement(sql);
		    statement.setString(1,"food" );
		    statement.setString(2,request.getParameter("name") );
		    statement.executeUpdate();
		}
	    out.print("\nfood");}
	if (request.getParameter("technology").equals("true"))
	    { rs = st.executeQuery("select subscriberlist from distributedhashtable where topic=" + "'technology';");
		if(rs.next())
		{
		      String psubs= rs.getString("subscriberlist");
		      psubs=psubs+" "+request.getParameter("name");
		      st.executeUpdate("update distributedhashtable set subscriberlist='"+psubs+"' where topic='technology';");
		}
		else 
		{
		    String sql="insert into distributedhashtable (topic,subscriberlist) values(?,?)";
		    PreparedStatement statement = con.prepareStatement(sql);
		    statement.setString(1,("technology") );
		    statement.setString(2,request.getParameter("name") );
		    statement.executeUpdate();
		}
	    out.print("\ntechnology");}
	if (request.getParameter("movies").equals("true"))
	{  rs = st.executeQuery("select subscriberlist from distributedhashtable where topic='movies';");
	if(rs.next())
	{
	      String psubs= rs.getString("subscriberlist");
	      psubs=psubs+" "+request.getParameter("name");
	      st.executeUpdate("update distributedhashtable set subscriberlist='"+psubs+"' where topic='movies';");
	}
	else 
	{
	    String sql="insert into distributedhashtable (topic,subscriberlist) values(?,?)";
	    PreparedStatement statement = con.prepareStatement(sql);
	    statement.setString(1,"movies" );
	    statement.setString(2,request.getParameter("name") );
	    statement.executeUpdate();
	}
	    out.print("\nmovies");}
	if (request.getParameter("sports").equals("true"))
	{
	    rs = st.executeQuery("select subscriberlist from distributedhashtable where topic='sports';");
		if(rs.next())
		{
		      String psubs= rs.getString("subscriberlist");
		      psubs=psubs+" "+request.getParameter("name");
		      st.executeUpdate("update distributedhashtable set subscriberlist='"+psubs+"' where topic='sports';");
		}
		else 
		{
		    String sql="insert into distributedhashtable (topic,subscriberlist) values(?,?)";
		    PreparedStatement statement = con.prepareStatement(sql);
		    statement.setString(1,"sports" );
		    statement.setString(2,request.getParameter("name") );
		    statement.executeUpdate();
		}
	  out.print("\nsports");
	}
			}
	catch(Exception e){
		System.out.println("DB Exception"+e);
	}
    }

   
}