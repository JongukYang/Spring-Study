package dev.springstudy.jpa.service;

import dev.springstudy.jpa.entity.PostEntity;
import dev.springstudy.jpa.entity.dto.PostDto;
import dev.springstudy.jpa.repository.PostRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostRepositoryImpl postRepositoryImpl; // PostDao

    public PostService(@Autowired PostRepositoryImpl postRepositoryImpl) {
        this.postRepositoryImpl = postRepositoryImpl;
    }

    public void createPost(PostDto postDto) {
        this.postRepositoryImpl.createPost(postDto);
    }
    public PostDto readPost(int id) {
        PostEntity postEntity = this.postRepositoryImpl.readPost(id);
        return new PostDto(
                Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null  ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
        );
    }

    public List<PostDto> readPostAll() {
        Iterator<PostEntity> iterator = this.postRepositoryImpl.readPostAll();
        List<PostDto> postDtoList = new ArrayList<>();

        while (iterator.hasNext()) {
            PostEntity postEntity = iterator.next();
            postDtoList.add(new PostDto(
                    Math.toIntExact(postEntity.getId()),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getWriter(),
                    postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId()))
            );
        }
        return postDtoList;
    }
    public void updatePost(int id, PostDto postDto) {
        this.postRepositoryImpl.updatePost(id, postDto);
    }

    public void deletePost(int id) {
        this.postRepositoryImpl.deletePost(id);
    }
}
