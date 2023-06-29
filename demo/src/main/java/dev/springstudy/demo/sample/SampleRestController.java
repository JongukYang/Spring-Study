package dev.springstudy.demo.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/rest")
public class SampleRestController {
    private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);

    /***
     * @RestController 어노테이션을 사용하면 메서드에 @ResponseBody 어노테이션이 없어도
     * 반환 타입을 JSON으로 Client에게 전송해 줄 수 있음
     */
    @GetMapping("/sample-payload")
    public SamplePayload samplePayload() {
        return new SamplePayload("whddnr", 24, "Developer");
    }

    @GetMapping(
            value = "/sample-image",
            produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] sampleImage() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("");
//        inputStream = new FileInputStream(new File(""));
        return inputStream.readAllBytes();
    }
}
