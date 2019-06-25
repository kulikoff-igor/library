package bytechs.testTask.library.web.controllers;

import bytechs.testTask.library.dao.model.Book;
import bytechs.testTask.library.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/api/book")
public class BookController {
    @Autowired
    BookServices bookServices;

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public Book createBook(@RequestParam(value = "nameBook", required = true) String nameBook, @RequestParam(value = "nameLibrary", required = true) String nameLibrary) {
        return bookServices.createBook(nameBook, nameLibrary);
    }

    @PostMapping(value = "/addAuthor")
    @ResponseStatus(value = HttpStatus.OK)
    public Book addAuthorBook(@RequestParam(value = "nameBook", required = true) String nameBook, @RequestParam(value = "listAuthor", required = true) List<String> listAuthor) {
        return bookServices.addAuthorInBook(nameBook, listAuthor);
    }

    @PostMapping(value = "/edit")
    @ResponseStatus(value = HttpStatus.OK)
    public Book editBook(@RequestBody Book book) {
        return bookServices.createBook(book);
    }

    @PostMapping(value = "/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBook(@RequestBody Book book) {
        bookServices.deleteBook(book);
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Book> getAllBook() {
        return bookServices.returnAllBook();
    }

    @GetMapping(value = "/getByName")
    @ResponseStatus(value = HttpStatus.OK)
    public Book getBookByName(@RequestParam(value = "nameBook", required = true) String nameBook) {
        return bookServices.returnBookByName(nameBook);
    }

}
