package bytechs.testTask.library.repository;

import bytechs.testTask.library.model.Author;
import bytechs.testTask.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Book> findByNameAuthor(String nameAuthor);

}
