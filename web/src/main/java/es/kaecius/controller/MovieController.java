package es.kaecius.controller;


import es.kaecius.util.constant.UrlMapping;
import es.kaecius.util.constant.ViewMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MovieController {

    @RequestMapping(UrlMapping.HOME)
    public String home(HttpSession session) {
        log.info("session = {}", session);
        session.getAttributeNames().asIterator().forEachRemaining(i -> {
            log.info(i);
        });
        return ViewMapping.HOME;
    }

}
