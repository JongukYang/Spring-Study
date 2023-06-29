package dev.springstudy.demo.mapper;

import dev.springstudy.demo.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto boardDto);
}
