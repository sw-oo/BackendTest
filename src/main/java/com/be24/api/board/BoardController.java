package com.be24.api.board;

import com.be24.api.board.model.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/board/create"})
public class BoardController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        BoardDto boardDto = BoardDto.toDto(req);
        BoardService boardService = new BoardService();
        boardService.createPost(boardDto);
    }
}
