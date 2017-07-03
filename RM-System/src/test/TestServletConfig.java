package test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Lcrit_Z on 2017/5/4.
 */
@WebServlet(urlPatterns = "/testconfig",name = "TestServletConfig",initParams = {@WebInitParam(name = "name",value = "zxh"),@WebInitParam(name = "server",value = "tomcat")})
public class TestServletConfig extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = this.config.getInitParameter("name");
        response.getWriter().println(param);
        Enumeration<String> e = config.getInitParameterNames();
        while (e.hasMoreElements()){
            String name = e.nextElement();
            String value = config.getInitParameter(name);
            response.getWriter().print(name+"="+value+"\n");

        }
    }
}
