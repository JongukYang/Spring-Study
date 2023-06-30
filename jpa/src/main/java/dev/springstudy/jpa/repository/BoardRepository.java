package dev.springstudy.jpa.repository;

import dev.springstudy.jpa.entity.BoardEntity;
import dev.springstudy.jpa.entity.dto.BoardDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface BoardRepository extends CrudRepository<BoardEntity, Long> { // 두가지 제네릭 타입, 하나는 어떤 엔티티를 위한 것인지, PK가 어떤 타입을 사용하는지 작성
    BoardDto create(BoardDto dto);
    BoardDto read(Long id);
    Collection<BoardDto> readAll();
    boolean update(Long id, BoardDto dto);
    boolean delete(Long id);
}
