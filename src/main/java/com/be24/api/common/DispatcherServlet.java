package com.be24.api.common;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// 모든 요청은 DispatcherServlet을 통해서 처리
@WebServlet(urlPatterns = "/")
public class DispatcherServlet extends HttpServlet {

    private AppConfig appConfig;

    // Servlet이 init 될 때 AppConfig 객체 생성
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.appConfig = new AppConfig();
    }

    // get, post 어떤 요청 메소드든 service() 메소드 실행
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 클라이언트가 요청한 주소를 가져옴
        String uri = req.getRequestURI();
        // appConfig 통해서 해당 주소에 등록되어 있는 컨트롤러를 반환
        Controller controller = appConfig.getController(uri);


        if(controller == null) {
            // 컨트롤러가 없으면 404로 에러 처리
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 컨트롤러가 있으면 컨트롤러의 작업을 실행
        controller.process(req, resp);
    }
}
