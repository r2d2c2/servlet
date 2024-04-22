package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.frontcontroller.v3.ContollerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {//해당 주소의 하위 값이면 무조건 서블릿 호출
    private Map<String , ContollerV3> controllerV1Map=new HashMap<>();
    public FrontControllerServletV3() {
        controllerV1Map.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        controllerV1Map.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        controllerV1Map.put("/front-controller/v3/members",new MemberListControllerV3());
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = req.getRequestURI();//주소 받기
        ContollerV3 controllerV3 = controllerV1Map.get(requestURI);
        if(controllerV3==null){//없는 주소면(null)404
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String ,String> paramMap=new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(p->paramMap.put(p,req.getParameter(p)));

        ModelView mv = controllerV3.process(paramMap);//해당 뷰로 넘기기
        String viewName = mv.getViewName();
        MyView view = new MyView("/WEB-INF/views/" + viewName + ".jps");
        view.render(mv.getModel(), req,resp);
    }
}
