package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ContollerV3 {
    ModelView process(Map<String,String > paramMap);
}
