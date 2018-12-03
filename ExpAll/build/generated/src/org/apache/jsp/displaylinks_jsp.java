package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import mypack.*;
import java.util.*;

public final class displaylinks_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ExpAll</title>\n");
      out.write("    </head>\n");
      out.write("    <a href=\"displaylinks.jsp\"></a>\n");
      out.write("    <body>\n");
      out.write("        <h1><center>Search Query Results</center></h1>\n");
      out.write("        \n");
      out.write("        ");

            String q = request.getParameter("query");
            //java code    
            Search obj=new Search();
            ArrayList <String> links=obj.extract(q);
            for(String a: links)
            {
            
      out.write("\n");
      out.write("     \n");
      out.write("        <p> <a href=\"");
      out.print( a);
      out.write('"');
      out.write('>');
      out.print( a);
      out.write(" </a></p>\n");
      out.write("        ");

        }
        if(links.isEmpty())
            {
      out.write("\n");
      out.write("            <p> OOPS you seem to have entered a wrong query!!! go back and query again!!!</p>\n");
      out.write("            \n");
      out.write(" ");

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expall?autoReconnect=true&useSSL=false", "root","");
    Statement st = con.createStatement();
    int i=st.executeUpdate("insert into query_ans(keyword)values('"+q+"')");
out.println("Your query has been successfully recorded!! ");

      out.write("\n");
      out.write("  \n");
      out.write("            ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
