package es.kaecius.controller;


import es.kaecius.util.constant.UrlMapping;
import es.kaecius.util.constant.ViewMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MovieController {

    @RequestMapping(UrlMapping.HOME)
    public String home(HttpSession session, Authentication authentication, Model model) {
        return (authentication != null && authentication.isAuthenticated()) ? UrlMapping.MOVIE_REDIRECT : ViewMapping.HOME;
    }

    @GetMapping(UrlMapping.SIGNUP)
    public String signupGet() {
        return ViewMapping.SIGNUP;
    }

}
