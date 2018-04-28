package guru.cooperhanke.blog_demo.controllers;

import guru.cooperhanke.blog_demo.models.User;
import guru.cooperhanke.blog_demo.repositories.UserRepository;
import guru.cooperhanke.blog_demo.services.UserServices;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    private UserServices usrSvc;

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @PostMapping("/login")
    public String loginUser() {
        User user = usrSvc.loggedInUser();
        System.out.println("user logged in successfully: " + user.getUsername());
        return "redirect: /posts";
    }
}