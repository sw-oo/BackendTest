package com.be24.api.board;

import com.be24.api.board.model.BoardDto;

public class BoardService {
    // BoardService 클래스 싱글톤 디자인 패턴 적용
    public BoardService() {
    }

    private static class SingletonHolder {
        private static final BoardService instance = new BoardService();
    }

    public static BoardService getInstance() {
        return SingletonHolder.instance;
    }

    // Controller에게 DTO 타입으로 반환
    public BoardDto createPost(BoardDto boardDto) {
        // BoardRepository의 싱글톤 인스턴스 반환
        BoardRepository boardRepository = BoardRepository.getInstance();
        BoardDto returnDto = boardRepository.create(boardDto);
        return returnDto;
    }
}
