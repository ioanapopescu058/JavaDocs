package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Ioana.Popescu on 7/18/2017.
 */
public class ZeroToHeroServlet extends HttpServlet {

    private String handleRequest(HttpServletRequest req) {

        String response = "Hello <b>" + req.getParameter("firstName") + " " + req.getParameter("lastName") + "</b>!" +
                "Enjoy Zero To Hero!!!";

        return response;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter pw = response.getWriter();

        pw.write(handleRequest(request));
    }

}
