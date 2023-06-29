package dev.springstudy.demo.dao;

import dev.springstudy.demo.dto.PostDto;
import dev.springstudy.demo.mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao {
    private final SqlSessionFactory sessionFactory;

    public PostDao(@Autowired SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int createPost(PostDto dto) {
//        // 데이터베이스와 연결하기 위한 세션 설정
//        SqlSession session = sessionFactory.openSession(); // default = true
//        PostMapper mapper = session.getMapper(PostMapper.class);
//        int rowAffected = mapper.createPost(dto);
//
//        // 메모리 낭비를 막기 위해 close
//        session.close();
//        return rowAffected;

        // try resource 문법 : 중괄호 내부가 try문 수행 후 Close됨
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            int rowAffected = mapper.createPost(dto);
            return rowAffected;
        }
    }

    /***
     * thread safe 하지 않은 세션 펙토리
     * 따라서 계속 열고 닫기 해주는거임
     */
    public PostDto readPost(int id) {
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }

    public List<PostDto> readPostAll() {
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
        }
    }

    public int updatePost(PostDto postDto) {
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(postDto);
        }
    }

    public int deletePost(int id) {
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
        }
    }
}
