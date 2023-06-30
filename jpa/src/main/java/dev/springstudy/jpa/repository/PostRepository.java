package dev.springstudy.jpa.repository;

import dev.springstudy.jpa.entity.BoardEntity;
import dev.springstudy.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByWriter(String writer);
    List<PostEntity> findAllByWriterAndBoardEntity(String writer, BoardEntity boardEntity); // where writer = ? and board_eneity_id = ?
    List<PostEntity> findAllByWriterContaining(String writer); // writer를 포함하는 내용을 알아오기
}
