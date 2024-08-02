package by.tms.homework25.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"OperationServlet"})
public class OperationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String type = req.getParameter("type");

        if (type.equals("sum") || type.equals("sub") || type.equals("mul") || type.equals("div")) {
            req.setAttribute("num1", Double.parseDouble(req.getParameter("num1")));
            req.setAttribute("num2", Double.parseDouble(req.getParameter("num2")));
            req.setAttribute("type", type);

            chain.doFilter(req, res);
        } else {
            res.setStatus(400);
        }
    }
}