package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ImportResource("classpath:/db_dao.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
