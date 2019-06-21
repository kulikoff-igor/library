package bytechs.testTask.library.services;

import bytechs.testTask.library.model.Author;
import bytechs.testTask.library.model.Book;
import bytechs.testTask.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service("bookServices")
@Transactional("transactionManager")
public class BookServices {
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public Book returnBookByName(String nameBook) {
        return bookRepository.findByBookName(nameBook);
    }

}
