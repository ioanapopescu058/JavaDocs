package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;
import sun.rmi.log.ReliableLog;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Ioana.Popescu on 7/19/2017.
 */
public class HeadersLogFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                    String currentHeader = headerNames.nextElement();
                    LogFileWriter.logHeader(currentHeader, httpRequest.getHeader(currentHeader));
            }
        }

        chain.doFilter(httpRequest, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
