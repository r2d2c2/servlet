package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestHeaderServlet",urlPatterns = "/request-header")
public class RequestHeaderSerblet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        //모든 해더 정보 출력
        req.getHeaderNames().asIterator()
                .forEachRemaining(hname-> System.out.println("hname = " + hname));
    }

    private static void printStartLine(HttpServletRequest req) {
        System.out.println("request start");
        System.out.println("req.getMethod() = " + req.getMethod());
        //GET
        System.out.println("req.getProtocol() = " + req.getProtocol());
        //http 정보 (http 1.1)
        System.out.println("req.getScheme() = " + req.getScheme());
        //http
        System.out.println("req.getRequestURL() = " + req.getRequestURL());
        //현제 웹 주소 전체
        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        ///request-header 뒷 주소 추력
        System.out.println("req.getQueryString() = " + req.getQueryString());
        //파라미터 hello 출력(?username=hello)
        System.out.println("req.isSecure() = " + req.isSecure());
        //https사용 유무
    }
}
