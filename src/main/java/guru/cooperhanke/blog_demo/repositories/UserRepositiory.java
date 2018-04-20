package guru.cooperhanke.blog_demo.repositories;

import guru.cooperhanke.blog_demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositiory extends CrudRepository<User, Long> {
}
