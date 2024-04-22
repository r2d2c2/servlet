package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v1.ControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2",urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {//해당 주소의 하위 값이면 무조건 서블릿 호출
    private Map<String , ControllerV2> controllerV1Map=new HashMap<>();
    public FrontControllerServletV2() {
        controllerV1Map.put("/front-controller/v2/members/new-form",new MemberFormControllerV2());
        controllerV1Map.put("/front-controller/v2/members/save",new MemberSaveControllerV2());
        controllerV1Map.put("/front-controller/v2/members",new MemberListControllerV2());
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        String requestURI = req.getRequestURI();//주소 받기
        ControllerV2 controllerV2 = controllerV1Map.get(requestURI);
        if(controllerV2==null){//없는 주소면(null)404
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView view = controllerV2.process(req, resp);//해당 뷰로 넘기기
        view.render(req,resp);
    }
}
