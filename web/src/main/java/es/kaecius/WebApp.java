package es.kaecius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"es.kaecius.core","es.kaecius.web"})
public class WebApp {

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class);
    }

}
