//package dev.springstudy.jpa;
//
//import dev.springstudy.jpa.entity.BoardEntity;
//import dev.springstudy.jpa.entity.PostEntity;
//import dev.springstudy.jpa.repository.BoardRepository;
//import dev.springstudy.jpa.repository.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TestComponent {
//    public TestComponent(
//            @Autowired BoardRepository boardRepository,
//            @Autowired PostRepository postRepository
//    ) {
//        BoardEntity boardEntity = new BoardEntity();
//        boardEntity.setName("new board");
//
//        BoardEntity newBoardEntity = boardRepository.save(boardEntity);
//        System.out.println(newBoardEntity.getName());
//
//        PostEntity postEntity = new PostEntity();
//        postEntity.setTitle("orm");
//        postEntity.setContent("created by hibernate");
//        postEntity.setWriter("whddnr");
//        postEntity.setBoardEntity(newBoardEntity);
//
//        PostEntity newPostEntity = postRepository.save(postEntity);
//        System.out.println(newPostEntity);
//
//        System.out.println("findAllByWriter: " + postRepository.findAllByWriter("whddnr").size());
//
////        boardRepository.
//    }
//}
