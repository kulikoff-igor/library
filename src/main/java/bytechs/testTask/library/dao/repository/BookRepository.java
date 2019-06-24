package bytechs.testTask.library.dao.repository;

import bytechs.testTask.library.dao.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("bookRepository")
public interface BookRepository  extends JpaRepository<Book, Integer> {
    Book findByBookName(String bookName);
}
