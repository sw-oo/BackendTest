package com.be24.api.board;

import com.be24.api.board.model.BoardDto;

public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    // Controller에게 DTO 타입으로 반환
    public BoardDto createPost(BoardDto boardDto) {
        BoardDto returnDto = boardRepository.create(boardDto);
        return returnDto;
    }

    public BoardDto readPost(String boardIdx) {
        BoardDto returnDto = boardRepository.read(boardIdx);
        return returnDto;
    }
}
