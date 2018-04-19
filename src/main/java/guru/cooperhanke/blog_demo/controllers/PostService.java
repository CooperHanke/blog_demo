package guru.cooperhanke.blog_demo.controllers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {
    private ArrayList<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public ArrayList<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId((long) (posts.size() + 1));
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int) (id - 1));
    }

    private void createPosts() {
        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();

        post1.setTitle("First Post of the ArrayList!!!");
        post2.setBody("We are now looking at the first post from the new service that created it!");
        save(post1);

        post2.setTitle("And this is just the beginning");
        post2.setBody("While we are working on this second item in the arraylist!!");
        save(post2);

        post3.setTitle("And this will be our final test");
        post3.setBody("So I probably should have gotten some real Lorem Ipsum");
        save(post3);
    }
}
