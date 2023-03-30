package hello.core.ResponseEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;

@RestController
@RequiredArgsConstructor
public class ResponseEntityController {
    @GetMapping("/response")
    public ResponseEntity<ResponseDto> responseEntityTest(HttpServletRequest request) {
        ResponseDto responseDto = new ResponseDto();

        String name = request.getParameter("name");
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setName(name);
        responseDto.setContent("응답 성공 테스트 입니다.");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

//        return new ResponseEntity<>(responseDto, headers, HttpStatus.OK);
//        return ResponseEntity.ok().headers(headers).body(responseDto);
        return ResponseEntity.badRequest().headers(headers).body(responseDto);
    }
}
