package guru.cooperhanke.blog_demo.controllers.repositories;

import guru.cooperhanke.blog_demo.controllers.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

    Post findById(long id);
}
