package com.bos.source.log;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogBack {

    @RequestMapping("/logback")
    public String loog(){

        for (int i = 0; i <10 ; i++) {
            log.info("logging.....测试.."+i);
        }

        return  "loging-test";
    }
}
