package dev.springstudy.jpa.repository;

import dev.springstudy.jpa.entity.BoardEntity;
import dev.springstudy.jpa.entity.dto.BoardDto;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BoardRepositoryImpl implements BoardRepository {
    private Long lastIndex = 0L; // mysql의 pk 값을 auto increment를 위해 사용
    private final Map<Long, BoardDto> memory = new HashMap<>();

    @Override
    public BoardDto create(BoardDto dto) {
        lastIndex++; // 0부터 시작하니까 1로 만들기
        dto.setId(lastIndex);
        memory.put(lastIndex, dto);
        return memory.get(lastIndex);
    }

    @Override
    public BoardDto read(Long id) {
        return memory.getOrDefault(id, null);
    }

    @Override
    public Collection<BoardDto> readAll() {
        return memory.values();
    }

    @Override
    public boolean update(Long id, BoardDto dto) {
        if (memory.containsKey(id)) {
            dto.setId(id);
            memory.put(id, dto);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (memory.containsKey(id)) {
            memory.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public <S extends BoardEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends BoardEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<BoardEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<BoardEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<BoardEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(BoardEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends BoardEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
