package dev.aquashdw.jpa.handler;

import dev.aquashdw.jpa.exception.BaseException;
import dev.aquashdw.jpa.exception.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class PostControllerAdvice {
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseDto handleException(BaseException exception) {
        return new ErrorResponseDto(exception.getMessage());
    }

    // validator와 함께 사용할 때
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDto handleValidateException(
            MethodArgumentNotValidException exception
    ) {
        return new ErrorResponseDto((exception.getMessage()));
    }
}
