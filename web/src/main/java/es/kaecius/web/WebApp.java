package es.kaecius.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("es.kaecius")
@Slf4j
public class WebApp {

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class);
    }

}
