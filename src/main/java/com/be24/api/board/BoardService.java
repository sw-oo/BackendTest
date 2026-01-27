package com.be24.api.board;

import com.be24.api.board.model.BoardDto;

public class BoardService {
    public void createPost(BoardDto boardDto) {
        BoardRepository boardRepository = new BoardRepository();
        boardRepository.create(boardDto);
    }
}
