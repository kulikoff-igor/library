package bytechs.testTask.library.web.controllers;

import bytechs.testTask.library.dao.model.Author;
import bytechs.testTask.library.services.AuthorServices;
import bytechs.testTask.library.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/api/author")
public class AuthorController {

    @Autowired
    BookServices bookServices;
    @Autowired
    AuthorServices authorServices;

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public Author createAuthor(@RequestParam(value = "nameAuthor", required = true) String nameAuthor) {
        return authorServices.createAuthor(nameAuthor);
    }

    @PostMapping(value = "/addBook")
    @ResponseStatus(value = HttpStatus.OK)
    public Author addBookAuthor(@RequestParam(value = "nameAuthor", required = true) String nameAuthor, @RequestParam(value = "listBook", required = true) List<String> listBook) {
        return authorServices.addBookInAuthor(nameAuthor, listBook);
    }

    @PostMapping(value = "/edit")
    @ResponseStatus(value = HttpStatus.OK)
    public Author editAuthor(@RequestBody Author author) {
        return authorServices.createAuthor(author);
    }

    @PostMapping(value = "/delete")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteAuthor(@RequestBody Author author) {
        authorServices.deleteAuthor(author);
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Author> getAllAuthor() {
        return authorServices.returnAllAuthor();
    }

    @GetMapping(value = "/getByName")
    @ResponseStatus(value = HttpStatus.OK)
    public Author getAuthorByName(@RequestParam(value = "nameAuthor", required = true) String nameAuthor) {
        return authorServices.returnAuthor(nameAuthor);
    }
}
