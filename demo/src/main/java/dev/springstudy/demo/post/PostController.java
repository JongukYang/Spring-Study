package dev.springstudy.demo.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Deprecated // 더 이상 사용을 하지 않을 예정이라는 뜻
@Controller
@ResponseBody // 클래스 안에 있는 모든 함수들이 @ResponseBody 를 갖는다
@RequestMapping("/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping("/read-all")
    public List<PostDto> readPostAll() {
        logger.info("info read all");
        return this.postService.readPostAll();
    }

    @GetMapping("/read-one")
    public PostDto readPostOne(@RequestParam("id") int id) {
        logger.info("info read one");
        return this.postService.readPost(id);
    }

    @PostMapping("/update")
    public void updatePost(@RequestParam("id") int id,
                           @RequestBody PostDto postDto
    ) {
        logger.info("target id: " + id);
        logger.info("update content: " + postDto);
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id) {
        this.postService.deletePost(id);
    }
}
