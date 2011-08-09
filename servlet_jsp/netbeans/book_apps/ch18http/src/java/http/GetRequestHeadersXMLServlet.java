package http;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;

public class GetRequestHeadersXMLServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        StringBuilder returnString = new StringBuilder();
        Enumeration headerNames = request.getHeaderNames();
        returnString.append("<?xml version='1.0' encoding='UTF-8'?>"
                          + "<!-- Request Header Information-->"
                          + "<headers>");
        while (headerNames.hasMoreElements())
        {
            String name = (String) headerNames.nextElement();
            String value = request.getHeader(name);
            returnString.append("<header>"
                              + "<name>" + name + "</name>"
                              + "<value>" + value + "</value>"
                              + "</header>");
        }
        returnString.append("</headers>");
        response.setContentType("text/xml");

        PrintWriter out = response.getWriter();
        out.println(returnString);
    }
}