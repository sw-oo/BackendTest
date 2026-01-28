package com.be24.api.board;

import com.be24.api.board.model.BoardDto;

public interface BoardRepository {
    public BoardDto read(String boardIdx);
    public BoardDto create(BoardDto dto);
}
