package guru.cooperhanke.blog_demo.repositories;

import guru.cooperhanke.blog_demo.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

    Post findById(long id);
}
