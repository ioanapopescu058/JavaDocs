package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ioana.Popescu on 7/19/2017.
 */
public class HelloWorldServletForward extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object attributeValue = request.getAttribute("testAttribute");

        PrintWriter out = response.getWriter();
        out.write("Hello <b>" + request.getParameter("user") + " " + "</b> from the Forward Servlet! " + attributeValue + " ");
    }
}
