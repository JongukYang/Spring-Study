package dev.springstudy.demo.dto;
// DTO : Data Transfer Object
// 데이터를 담기 위한 오브젝트
public class BoardDto {
    private int id;
    private String name;

    public BoardDto() {
    }

    public BoardDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
