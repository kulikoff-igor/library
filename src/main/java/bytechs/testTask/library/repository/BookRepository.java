package bytechs.testTask.library.repository;

import bytechs.testTask.library.model.Author;
import bytechs.testTask.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookRepository  extends JpaRepository<Book, Integer> {
    Book findByBookName(String bookName);
}
