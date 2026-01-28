package com.be24.api.board;

import com.be24.api.board.model.BoardDto;
import com.be24.api.common.BaseResponse;
import com.be24.api.utils.JsonParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/board/create"})
public class BoardController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        // 클라이언트가 전달한 요청 Deserialize -> DTO에 저장
        BoardDto boardDto = JsonParser.from(req, BoardDto.class);

        // BoardService 싱글톤 인스턴스 반환
        BoardService boardService = BoardService.getInstance();

        // 응답 DTO객체 생성 후 값 저장
        BoardDto returnDto = boardService.createPost(boardDto);

        BaseResponse res = BaseResponse.success(returnDto);
        resp.getWriter().write(JsonParser.from(res));
    }
}
