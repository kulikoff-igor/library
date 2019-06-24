package bytechs.testTask.library.dao.repository;

import bytechs.testTask.library.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
