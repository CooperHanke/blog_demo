package guru.cooperhanke.blog_demo.controllers;

import guru.cooperhanke.blog_demo.models.Post;
import guru.cooperhanke.blog_demo.models.User;
import guru.cooperhanke.blog_demo.repositories.PostRepository;
import guru.cooperhanke.blog_demo.repositories.UserRepository;
import guru.cooperhanke.blog_demo.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final UserServices usrSvc;

    public PostController(
            PostRepository postDao,
            UserRepository userDao,
            UserServices usrSvc) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.usrSvc = usrSvc;
    }

    @GetMapping("/posts")
    public String post(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
        Post post = postDao.findById(id);
        User user = usrSvc.loggedInUser();
        model.addAttribute("post", post);
        model.addAttribute("isOwnedBy", usrSvc.isOwnedBy(post.getUser()));
        model.addAttribute("isLoggedIn", usrSvc.isLoggedIn());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        post.setUser(usrSvc.loggedInUser());
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
        post.setUser(usrSvc.loggedInUser());
        postDao.save(post);
        return "redirect:/posts/{id}";
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
