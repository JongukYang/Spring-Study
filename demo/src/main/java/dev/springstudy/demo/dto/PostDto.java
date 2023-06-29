package dev.springstudy.demo.dto;

public class PostDto {
    private int id;
    private String title;
    private String content;
    private String writer;
    private int board;
    // application.yml 에 map-underscore-to-camel-case: true 로 설정해 두었기 때문에
    // mybatis 가 자동으로 camel-case(공백이 올 위치 다음 글자를 대문자형식으로 치환하여 연결하는 형태) 형태로 바꿔준다

    public PostDto() {

    }
    public PostDto(int id, String title, String content, String writer, int board) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.board = board;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getBoard() {
        return board;
    }

    public void setBoard(int board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", board=" + board +
                '}';
    }
}
