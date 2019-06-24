package bytechs.testTask.library.dao.repository;

import bytechs.testTask.library.dao.model.UserDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userDescriptionRepository")
public interface UserDescriptionRepository extends JpaRepository<UserDescription, Integer> {
}
