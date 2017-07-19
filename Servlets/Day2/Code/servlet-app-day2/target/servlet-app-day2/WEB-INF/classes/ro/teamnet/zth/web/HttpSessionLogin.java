package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ioana.Popescu on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        Cookie[] cookies = request.getCookies();

        if (user.equals("admin") && pass.equals("admin")) {
            response.getWriter().write("Welcome back " + user + "!" + "\n");

            for (Cookie c : cookies) {
                response.getWriter().write(c.getName() + ":" + c.getValue() + "\n");
            }

            response.getWriter().write(request.getSession().getId());

        } else {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("session", request.getSession());
            response.sendRedirect("views/loginFail.jsp");
        }
    }
}
