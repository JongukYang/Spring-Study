package dev.springstudy.demo;

import dev.springstudy.demo.dao.BoardDao;
import dev.springstudy.demo.dao.PostDao;
import dev.springstudy.demo.dto.BoardDto;
import dev.springstudy.demo.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestComponent {
    private final PostDao postDao;
    private final BoardDao boardDao;

    public TestComponent(@Autowired PostDao postDao, @Autowired BoardDao boardDao) {
        this.postDao = postDao;
        this.boardDao = boardDao;

        // Post 테스트
        PostDto newPost = new PostDto();
        newPost.setTitle("kfjkj");
        newPost.setContent("hslkerhlkhrlkh");
        newPost.setWriter("lhwhdndnr");
        newPost.setBoard(1);
        System.out.println(this.postDao.createPost(newPost));

        List<PostDto> postDtoList = this.postDao.readPostAll();
        System.out.println(postDtoList.get(postDtoList.size() - 1));

        PostDto firstPost = postDtoList.get(0);
        firstPost.setContent("Update");
        postDao.updatePost(firstPost);

        System.out.println(this.postDao.readPost(firstPost.getId()));

        // board 테스트
        BoardDto boardDto = new BoardDto();
        boardDto.setName("new board");
        this.boardDao.createBoard(boardDto);
        System.out.println(boardDto.getId());
        System.out.println(boardDto.getName());
    }
}
