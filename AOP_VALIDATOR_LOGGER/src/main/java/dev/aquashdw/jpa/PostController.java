package dev.aquashdw.jpa;

import dev.aquashdw.jpa.aspect.LogArguments;
import dev.aquashdw.jpa.aspect.LogExecutionTime;
import dev.aquashdw.jpa.aspect.LogResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(
            @Autowired PostService postService
    ) {
        this.postService = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@Valid @RequestBody PostDto dto){
        this.postService.createPost(dto);
    }

    @GetMapping("{id}")
    public PostDto readPost(
            @PathVariable("id") int id
    ){
        logger.info("readOnePost, id:{}", id);
        return this.postService.readPost(id);
    }

    @LogArguments
    @LogExecutionTime
    @LogResults
    @GetMapping("")
    public List<PostDto> readPostAll() {
        return this.postService.readPostAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto dto
    ){
        logger.info("updatePost, id:{}", id);
        this.postService.updatePost(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("id") int id
    ){
        logger.info("deletePost, id:{}", id);
        this.postService.deletePost(id);
    }

    @GetMapping("test-log")
    public void testLog(){
        logger.trace("TRACE Log Message");
        logger.debug("DEBUG Log Message");
        logger.info("INFO Log Message");
        logger.warn("WARN Log Message");
        logger.error("ERROR Log Message");
        logger.info("현재 로거의 루트: ", logger.getName());
    }

    @PostMapping("test-valid")
    public void testValid(@Valid @RequestBody ValidTestDto dto) {
        logger.warn(dto.toString());
    }
}
