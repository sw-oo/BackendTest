package com.be24.api.board;

import com.be24.api.board.model.BoardDto;

public class BoardService {
    // Controller에게 DTO 타입으로 반환
    public BoardDto createPost(BoardDto boardDto) {
        BoardRepository boardRepository = new BoardRepository();
        BoardDto returnDto = boardRepository.create(boardDto);
        return returnDto;
    }
}
