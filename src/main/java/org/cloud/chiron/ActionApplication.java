package org.cloud.chiron;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.cloud.chiron.system.mapper")
public class ActionApplication {
    private final static Logger logger = LoggerFactory.getLogger("o.c.c.Main");

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ActionApplication.class);
        application.run(args);
        logger.info("============= SpringBoot Start Success =============");
    }
}
