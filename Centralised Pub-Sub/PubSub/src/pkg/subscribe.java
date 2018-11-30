package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






@WebServlet(name="subscribe")
public class subscribe
  extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  public static HashMap<String, LinkedList<String>> h = new HashMap();
  public static LinkedList<String> l1 = new LinkedList();
  public static LinkedList<String> l2 = new LinkedList();
  public static LinkedList<String> l3 = new LinkedList();
  public static LinkedList<String> l4 = new LinkedList();
  public static LinkedList<String> l5 = new LinkedList();
  
  public subscribe() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { if (request.getParameter("politics").equals("true"))
      l1.add(request.getParameter("name"));
    h.put("politics", l1);
    if (request.getParameter("food").equals("true"))
      l2.add(request.getParameter("name"));
    h.put("food", l2);
    if (request.getParameter("technology").equals("true"))
      l3.add(request.getParameter("name"));
    h.put("technology", l3);
    if (request.getParameter("movies").equals("true"))
      l4.add(request.getParameter("name"));
    h.put("movies", l4);
    if (request.getParameter("sports").equals("true"))
      l5.add(request.getParameter("name"));
    h.put("sports", l5);
    



    PrintWriter out = response.getWriter();
    out.print(request.getParameter("name") + " subscribed to");
    if (request.getParameter("politics").equals("true"))
      out.print("\npolitics");
    if (request.getParameter("food").equals("true"))
      out.print("\nfood");
    if (request.getParameter("technology").equals("true"))
      out.print("\ntechnology");
    if (request.getParameter("movies").equals("true"))
      out.print("\nmovies");
    if (request.getParameter("sports").equals("true"))
      out.print("\nsports");
  }
  
  public static void pr(HttpServletRequest request, HttpServletResponse response, PrintWriter out) { if (h.containsKey(request.getParameter("topic")))
    {
      String su = "";
      for (String s : (LinkedList)h.get(request.getParameter("topic"))) {
        su = su + "\n" + s;
      }
      out.print(" " + su);
    }
  }
}