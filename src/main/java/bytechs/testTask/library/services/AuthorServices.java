package bytechs.testTask.library.services;

import bytechs.testTask.library.dao.model.Author;
import bytechs.testTask.library.dao.model.Book;
import bytechs.testTask.library.dao.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("authorServices")
@Transactional("transactionManager")
public class AuthorServices {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookServices bookServices;

    public Author createAuthor(Author author) {

        return authorRepository.saveAndFlush(author);
    }

    public List<Book> returnListBook(String authorBook) {
        return returnAuthor(authorBook).getBooksList();
    }

    public Author returnAuthor(String authorBook) {
        return authorRepository.findByNameAuthor(authorBook);
    }

    public Author addBookInAuthor(String nameAuthor, List<String> listBooks) {
        Author author = returnAuthor(nameAuthor);
        List<Book> bookList = author.getBooksList();
        for (String book : listBooks) {
            bookList.add(bookServices.returnBookByName(book));
        }
        return createAuthor(author);
    }

    public Author createAuthor(String nameAuthor) {
        Author author = new Author();
        author.setNameAuthor(nameAuthor);
        return authorRepository.saveAndFlush(author);
    }

    public List<Author> returnAllAuthor() {
        return authorRepository.findAll();
    }

    public void deleteAuthor(Author author) {
        authorRepository.delete(author);

    }
}
