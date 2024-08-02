package by.tms.homework25.servlet;

import by.tms.homework25.model.Operation;
import by.tms.homework25.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", urlPatterns = "/calc")
public class CalculateServlet extends HttpServlet {
    private final OperationService operationService = new OperationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = (Double) req.getAttribute("num1");
        double num2 = (Double) req.getAttribute("num2");
        String type = (String) req.getAttribute("type");

        Operation execute = operationService.execute(new Operation(num1, num2, type));
        resp.getWriter().println(execute.toString());
    }
}


//localhost:8080/calc?num1=2&num2=2&type=sum
//localhost:8080/calc?num1=2&num2=2&type=sub
//localhost:8080/calc?num1=2&num2=2&type=mul
//localhost:8080/calc?num1=2&num2=2&type=div