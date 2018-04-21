package guru.cooperhanke.blog_demo.controllers;

import guru.cooperhanke.blog_demo.models.Post;
import guru.cooperhanke.blog_demo.models.User;
import guru.cooperhanke.blog_demo.repositories.PostRepository;
import guru.cooperhanke.blog_demo.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(
            PostRepository postDao,
            UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String post(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        System.out.println("post user: " + post.getUser().getEmail());
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String submitEdit(@PathVariable long id, @ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts/{id}";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "/posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String submitDelete(@PathVariable long id, @ModelAttribute Post post) {
        postDao.delete(post);
        return "redirect:/posts";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "/posts/about";
    }
}
