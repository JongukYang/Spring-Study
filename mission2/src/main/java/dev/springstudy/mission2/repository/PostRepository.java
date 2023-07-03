package dev.springstudy.mission2.repository;

import dev.springstudy.mission2.model.PostDto;

import java.util.Collection;

public interface PostRepository {
    PostDto create(Long boardId, PostDto dto);
    PostDto read(Long boardId, Long postId);
    Collection<PostDto> readAll(Long boardId);
    boolean update(Long boardId, Long postId, PostDto dto);
    boolean delete(Long boardId, Long postId, String password);

}