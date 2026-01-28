package com.be24.api.board;


import com.be24.api.common.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Routing처리를 Appconfig에서 전부 처리하기 위해서 주석처리
// @WebServlet(urlPatterns = {"/board/create"})
public class BoardController implements Controller {

    @Override
    public String process(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("BoardController 실행");
        return "";
    }
}
