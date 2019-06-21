package bytechs.testTask.library.services;

import bytechs.testTask.library.model.Author;
import bytechs.testTask.library.model.Book;
import bytechs.testTask.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service("authorServices")
@Transactional("transactionManager")
public class AuthorServices {
    @Autowired
    AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.saveAndFlush(author);
    }

    public List<Book> returnListAuthor(String authorBook) {
        return authorRepository.findByNameAuthor(authorBook);
    }
}
