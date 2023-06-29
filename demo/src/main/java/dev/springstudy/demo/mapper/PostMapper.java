package dev.springstudy.demo.mapper;

import dev.springstudy.demo.dto.PostDto;

import java.util.List;

public interface PostMapper {
    int createPost(PostDto postDto);
    int createPostAll(List<PostDto> postDtoList);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    PostDto readPostQuery(PostDto postDto);
    int updatePost(PostDto postDto); // int id 필요없나?
    int deletePost(int id);

}
