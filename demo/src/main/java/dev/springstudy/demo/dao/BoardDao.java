package dev.springstudy.demo.dao;
// DAO : Data Access Object
// Repo의 데이터를 주고받기 위해, 접근할 수 있게 하기 위한 목적

import dev.springstudy.demo.dto.BoardDto;
import dev.springstudy.demo.mapper.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
    private final SqlSessionFactory sessionFactory;

    public BoardDao(@Autowired SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int createBoard(BoardDto boardDto) {
        try (SqlSession session = sessionFactory.openSession()) {
            BoardMapper mapper = session.getMapper(BoardMapper.class);
            return mapper.createBoard(boardDto);
        }
    }
}
