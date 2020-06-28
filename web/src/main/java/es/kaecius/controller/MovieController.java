package es.kaecius.controller;


import es.kaecius.model.User;
import es.kaecius.service.UserService;
import es.kaecius.util.constant.UrlMapping;
import es.kaecius.util.constant.ViewMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MovieController {

    private final UserService userService;

    @Autowired
    public MovieController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(UrlMapping.HOME)
    public String home(HttpSession session, Authentication authentication, Model model) {
        return (authentication != null && authentication.isAuthenticated()) ? UrlMapping.MOVIE_REDIRECT : ViewMapping.HOME;
    }

    @GetMapping(UrlMapping.SIGNUP)
    public ModelAndView signupGet(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User(-1));
        modelAndView.setViewName(ViewMapping.SIGNUP);
        return modelAndView;
    }

    @PostMapping(UrlMapping.SIGNUP)
    public String signupPost(User user) {
        userService.createUser(user);
        return UrlMapping.HOME_REDIRECT;
    }


}
