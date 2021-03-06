package com.james.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.Desktop;
import java.net.URI;

@RestController
@EnableAutoConfiguration
@EnableScheduling
@EnableEurekaServer
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello")
    String home() {
        return "Hello World!"+"你好世界";
    }

    @Scheduled(fixedDelay=5000)
    public void  scheduledTask() {
        logger.debug("Logger Level ：DEBUG "+"Hello World!");
        logger.info("Logger Level ：INFO "+"163");
        try {
            if(Desktop.isDesktopSupported()){
                logger.warn("Logger Level ：WARN "+"Open browser");
                Desktop.getDesktop().browse(new URI("http://music.163.com/outchain/player?type=0&id=71889585&auto=0&height=430"));
            }
        } catch (Exception e) {
            logger.error("Logger Level ：ERROR "+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(IndexController.class, args);
    }

}
