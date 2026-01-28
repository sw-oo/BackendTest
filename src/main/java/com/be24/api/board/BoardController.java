package com.be24.api.board;


import com.be24.api.board.model.BoardDto;
import com.be24.api.common.BaseResponse;
import com.be24.api.common.Controller;
import com.be24.api.utils.JsonParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Routing처리를 Appconfig에서 전부 처리하기 위해서 주석처리
// @WebServlet(urlPatterns = {"/board/create"})
public class BoardController implements Controller {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {
        BoardDto returnDto = null;

        if (req.getRequestURI().contains("create") && req.getMethod().equals("POST")) {
            BoardDto dto = JsonParser.from(req, BoardDto.class);
            returnDto = boardService.createPost(dto);
        } else if (req.getRequestURI().contains("read") && req.getMethod().equals("GET")) {
            String boardIdx = req.getParameter("idx");
            returnDto = boardService.readPost(boardIdx);
        }

        return BaseResponse.success(returnDto);
    }
}

