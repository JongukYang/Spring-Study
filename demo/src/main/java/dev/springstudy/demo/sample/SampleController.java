package dev.springstudy.demo.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping(
            value = "/hello",
            method = RequestMethod.GET
    )
    public String hello(@RequestParam(
            name = "id", required = false, defaultValue = "") String id
    ) {
        logger.info("Path: Hello");
        logger.info("Query Param id : " + id);
        return "/hello.html";
    }

    @GetMapping(value = "/hello/{id}")
    public String helloPath(@PathVariable("id") String id) {
        logger.info(id);
        return "/hello.html";
    }

    /***
     * 클래스가 @Controller 어노테이션을 가지고 있을 때
     * response 메소드에 @ResponseBody 어노테이션을 붙이지 않으면
     * JSON으로 클라이언트에게 전달 불가
     * @ResponseBody 어노테이션을 붙이게 되면 View Resolver 를 거치지 않음
     */
    @GetMapping("/get-profile")
    public @ResponseBody SamplePayload getProfile() {
        return new SamplePayload("whddnr", 24, "Developer");
    }
}

