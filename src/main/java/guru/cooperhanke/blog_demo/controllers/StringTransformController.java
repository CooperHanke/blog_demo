package guru.cooperhanke.blog_demo.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StringTransformController {
    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverseString(@PathVariable String string) {
        return new StringBuilder(string).reverse().toString();
    }

    @GetMapping("/string/caps/{string}")
    @ResponseBody
    public String stringAllCaps(@PathVariable String string) {
        return StringUtils.upperCase(string);
    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String executeBoth(@PathVariable String string) {
        return reverseString(stringAllCaps(string));
    }
}
