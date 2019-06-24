package bytechs.testTask.library.services;

import bytechs.testTask.library.dao.model.Author;
import bytechs.testTask.library.dao.model.Book;
import bytechs.testTask.library.dao.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("bookServices")
@Transactional("transactionManager")
public class BookServices {
    @Autowired
    LibraryServices libraryServices;
    @Qualifier("bookRepository")
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorServices authorServices;

    public Book createBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public Book createBook(String nameBook, String nameLibrary) {
        Book book = new Book();
        book.setBookName(nameBook);
        book.setLibrary(libraryServices.returnLibraryByName(nameLibrary));
        book.setStatus(false);
        return bookRepository.saveAndFlush(book);
    }

    public Book returnBookByName(String nameBook) {
        return bookRepository.findByBookName(nameBook);
    }

    public List<Book> returnAllBook() {
        return bookRepository.findAll();
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public Book addAuthorInBook(String nameBook, List<String> listAuthor) {
        Book book = returnBookByName(nameBook);
        Set<Author> authorList;
        try{
            authorList = book.getAuthorsList();}
        catch (NullPointerException e){
            authorList =new HashSet<>();
        }
        for (String author : listAuthor) {
            authorList.add(authorServices.returnAuthor(author));
        }

        return createBook(book);
    }
}
