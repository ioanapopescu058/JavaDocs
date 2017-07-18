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
public class InfoHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        response.setContentType("text/plain");

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.write("Header Name: " + headerName);
            Enumeration<String> headers = request.getHeaders(headerName);

            while (headers.hasMoreElements()) {
                String headerValue = headers.nextElement();
                out.write("\t" + headerValue);
                out.write("\n");
            }
        }

        out.write("Method: " + request.getMethod() + "\n");

        out.write("QueryString: " + request.getQueryString() + "\n");

        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            out.write("Parameter Name: " + parameterName);
            String parameter = request.getParameter(parameterName);
            out.write(" Value: " + parameter);
            out.write("\n");
        }

        Cookie[] cookies = request.getCookies();

        for (Cookie c : cookies) {
            out.write(c.getComment() + " ");
            out.write(c.getDomain()+ " ");
            out.write(c.getName() + " ");
            out.write(c.getValue() + "\n");
        }

    }
}
