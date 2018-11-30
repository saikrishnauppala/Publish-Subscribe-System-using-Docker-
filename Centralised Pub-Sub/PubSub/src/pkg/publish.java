package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet(name="publish")
public class publish extends javax.servlet.http.HttpServlet
{
  private static final long serialVersionUID = 1L;
  
  public publish() {}
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.print("Topic:      " + request.getParameter("topic") + "\n");
    out.print("Message:    " + request.getParameter("message"));
    out.print("\nSent to Subscribers ");
    subscribe.pr(request, response, out);
  }
}