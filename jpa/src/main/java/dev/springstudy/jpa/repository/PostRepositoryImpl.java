package dev.springstudy.jpa.repository;

import dev.springstudy.jpa.entity.PostEntity;
import dev.springstudy.jpa.entity.dto.PostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

// postDao 와 같다
@Repository
public class PostRepositoryImpl {
    private static final Logger logger = LoggerFactory.getLogger(PostRepositoryImpl.class);
    private final PostRepository postRepository;

    public PostRepositoryImpl(@Autowired @Lazy PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(PostDto postDto) {
        // todo: PostEntity를 새로 생성하는 이유??
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContent(postDto.getContent());
        postEntity.setWriter(postDto.getWriter());
        postEntity.setBoardEntity(null);
        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(int id) {
        // null pointer exception 에러를 방지하기 위해 Optional 사용 -> optional은 null을 허용함
        Optional<PostEntity> postEntity = this.postRepository.findById((long) id);
        if (postEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();
    }

    public Iterator<PostEntity> readPostAll() {
        // Iterator을 사용해서 전부 찾기
        return this.postRepository.findAll().iterator();
    }

    public void updatePost(int id, PostDto postDto) {
        Optional<PostEntity> targetEntity = postRepository.findById((long) id);
        PostEntity postEntity = targetEntity.get();
        postEntity.setTitle(
                postEntity.getTitle() == null ? postEntity.getTitle() : postDto.getTitle());
        postEntity.setContent(
                postDto.getContent() == null ? postEntity.getContent() : postDto.getContent());
//        postEntity.setWriter(
//                postDto.getWriter() == null ? postEntity.getWriter() : postDto.getWriter());
        this.postRepository.save(postEntity);
    }

    public void deletePost(int id) {
        // 1번
//        this.postRepository.deleteById((long) id);
        // 2번
        Optional<PostEntity> targetEntity = this.postRepository.findById((long) id);
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());
    }
}
