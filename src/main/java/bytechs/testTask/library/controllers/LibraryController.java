package bytechs.testTask.library.controllers;

import bytechs.testTask.library.model.Author;
import bytechs.testTask.library.model.Book;
import bytechs.testTask.library.model.Library;
import bytechs.testTask.library.services.AuthorServices;
import bytechs.testTask.library.services.BookServices;
import bytechs.testTask.library.services.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("library/api")
public class LibraryController {

    @Autowired
    LibraryServices libraryServices;
    @Autowired
    BookServices bookServices;
    @Autowired
    AuthorServices authorServices;
    @GetMapping(value = "/setLibrary")
    @ResponseStatus(value = HttpStatus.OK)
    public Library createLibrary(@RequestParam(value = "nameLibrary", required = true) String nameLibrary) {
        Library library=new Library();
        library.setNameLibrary(nameLibrary);
        return libraryServices.createLibrary(library);
    }

    @GetMapping(value = "/setBook")
    @ResponseStatus(value = HttpStatus.OK)
    public Book createBook(@RequestParam(value = "nameBook", required = true) String nameBook, @RequestParam(value = "nameLibrary", required = true) String nameLibrary) {
        Book book=new Book();
        book.setBookName(nameBook);
        book.setLibrary(libraryServices.returnLibraryByName(nameLibrary));
        return bookServices.createBook(book);
    }

    @GetMapping(value = "/setAuthor")
    @ResponseStatus(value = HttpStatus.OK)
    public Author createAuthor( @RequestParam(value = "nameAuthor", required = true) String nameAuthor, @RequestParam(value = "nameBook", required = true) String nameBook) {
        Author author=new Author();
        author.setNameAuthor(nameAuthor);
        author.setBooksList(new ArrayList<Book>(Arrays.asList(bookServices.returnBookByName(nameBook))));
        return authorServices.createAuthor(author);
    }

}
