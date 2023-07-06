package dev.aquashdw.jpa;

import dev.aquashdw.jpa.exception.BaseException;
import dev.aquashdw.jpa.exception.ErrorResponseDto;
import dev.aquashdw.jpa.exception.PostNotInBoardException;
import dev.aquashdw.jpa.exception.PostNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("except")
public class ExceptTestController {
    @GetMapping("{id}")
    public void throwException(@PathVariable("id") int id) {
        switch (id) {
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoardException();
            default:
                throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
    }

    // 지정된 예외에 대해서 처리해주는 함수
//    @ExceptionHandler(BaseException.class)
////    @ResponseStatus(HttpStatus.BAD_REQUEST) -> HttpServletResponse response 대신 사용할 수 있음
//    public ErrorResponseDto handleException(BaseException exception, HttpServletResponse response) {
//        return new ErrorResponseDto(exception.getMessage());
//    }

//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST) // -> HttpServletResponse response 대신 사용할 수 있음
//    public ErrorResponseDto handleException(BaseException exception) {
//        return new ErrorResponseDto(exception.getMessage());
//    }
}
