package guru.cooperhanke.blog_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LandingController {
    @GetMapping("/landing")
    @ResponseBody
    public String landing() {
        return "This is the landing page!";
    }
}