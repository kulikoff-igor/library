package bytechs.testTask.library.repository;

import bytechs.testTask.library.model.UserDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDescriptionRepository extends JpaRepository<UserDescription, Integer> {
}
