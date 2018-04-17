package guru.cooperhanke.blog_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String post(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        Post post2 = new Post();
        post1.setTitle("First Test");
        post2.setTitle("Second Test");
        post1.setBody("From arraylist");
        post2.setBody("From arraylist");
        model.addAttribute("post1", post1);
        model.addAttribute("post2", post2);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable int id, Model model) {
        Post post = new Post();
        post.setTitle("Test Post " + id);
        post.setBody("Body of test post " + id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String sendPost() {
        return "create a new post\n";
    }
}
