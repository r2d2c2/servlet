package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet",urlPatterns = "/hello")//서블릿 사용
public class HelloServlet extends HttpServlet {//서블릿 사용

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //값 보네기
        response.setContentType("text/plain");//문자 설정
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello "+username);
        //http body에 추가
    }
}
