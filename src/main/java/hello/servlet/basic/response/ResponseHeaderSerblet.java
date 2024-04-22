package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderSerblet",urlPatterns = "/response-header")
public class ResponseHeaderSerblet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);//200 ok

        //해더 설정
        //resp.setHeader("Content-Type","text/plain;setCharacterEncoding=utf-8");
        //혹은
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        //캐시나 쿠키도 해더로 만들수 있으나 따로 객체가 있어 더 편하게 만들수 있다
        resp.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        resp.setHeader("Pragma","no-cache");
        resp.setHeader("my-header","hello");//입이의 해더 추가
        cookie(resp);
        redirect(resp);

        PrintWriter writer=resp.getWriter();
        writer.println("ok");
    }

    private void redirect(HttpServletResponse resp) throws IOException {
        //302에러를 보네고 다음"주소로 웹페이지 이동"
        resp.sendRedirect("/basic/hello-form.html");
    }

    private void cookie(HttpServletResponse response){
        Cookie cookie=new Cookie("mycookie","good");
        cookie.setMaxAge(600);//600초
        response.addCookie(cookie);
    }
}
