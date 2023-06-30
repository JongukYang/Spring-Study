package dev.springstudy.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "post") // mysql 등 DB 에 표현되는 테이블명을 따로 클래스 이름이 아닌 다른 이름을 지정해 줄 수 있음
public class PostEntity extends BaseEntity {
    @Id // pk 값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 테이블을 생성하면서 auto increment 어노테이션
    private Long id;
    private String title;
    private String content;
    private String writer;

    // 포스트가 여러개이지만 보드는 하나 즉 1:N 관계 -> N을 구성하는 측에 ManyToOne 작성
    @ManyToOne(targetEntity = BoardEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name="board_id")
    private BoardEntity boardEntity;

    public PostEntity() {
    }

    public PostEntity(Long id, String title, String content, String writer, BoardEntity boardEntity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardEntity = boardEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }

    public void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", boardEntity=" + boardEntity +
                '}';
    }
}
