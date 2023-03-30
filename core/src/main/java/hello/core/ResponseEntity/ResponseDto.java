package hello.core.ResponseEntity;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseDto {
    private HttpStatus status;
    private String name;
    private String content;
    private Object data;
}
