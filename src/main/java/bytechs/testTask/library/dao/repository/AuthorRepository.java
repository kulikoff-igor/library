package bytechs.testTask.library.dao.repository;

import bytechs.testTask.library.dao.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("")
public interface AuthorRepository extends JpaRepository<Author, Integer> {
   Author findByNameAuthor(String nameAuthor);

}
