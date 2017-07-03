package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lcrit_Z on 2017/5/4.
 */

@WebServlet("/test")
public class testServlet extends HttpServlet {
    private String message;
    @Override
    public void init() throws ServletException{
        message = "hello this from servlet";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(302);
        response.setHeader("Location","/RMSystem/login/test.html");
    }

    //@Override
    public void destory(){
        super.destroy();
    }
}
