package dev.springstudy.jpa.repository;

import dev.springstudy.jpa.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BoardRepository extends CrudRepository<BoardEntity, Long> { // 두가지 제네릭 타입, 하나는 어떤 엔티티를 위한 것인지, PK가 어떤 타입을 사용하는지 작성
    
}
