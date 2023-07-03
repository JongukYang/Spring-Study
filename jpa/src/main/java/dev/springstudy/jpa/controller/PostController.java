package dev.springstudy.jpa.controller;

import dev.springstudy.jpa.entity.dto.PostDto;
import dev.springstudy.jpa.repository.PostRepository;
import dev.springstudy.jpa.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
    // 인터페이스를 가져오는 이유는 인터페이스를 통해 PostRepositoryImpl 구현체에 접근할 수 있기 때문에 구현체가 바뀌면 컨트롤러도 바뀌는 상황을 방지하기 위함.
    private final PostRepository postRepository;

    public PostController(@Autowired PostService postService,@Autowired PostRepository postRepository) { // spring ioc container 에서 bean 을 요구함
        this.postService = postService;
        this.postRepository = postRepository;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto) {
        this.postService.createPost(postDto);
    }

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        return this.postService.readPost(id);
    }

    @GetMapping("")
    public List<PostDto> readPostAll() {
        return this.postService.readPostAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDto postDto) {
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED) // 실패했을 때는 뭐가 전송?
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }
}
