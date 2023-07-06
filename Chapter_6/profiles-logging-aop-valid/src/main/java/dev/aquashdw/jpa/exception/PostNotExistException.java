package dev.aquashdw.jpa.exception;

public class PostNotExistException extends BaseException {

    public PostNotExistException() {
        super("taget post does not exist");
    }
}
