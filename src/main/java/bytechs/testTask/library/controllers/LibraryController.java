package bytechs.testTask.library.controllers;

import bytechs.testTask.library.dao.model.Library;
import bytechs.testTask.library.services.AuthorServices;
import bytechs.testTask.library.services.BookServices;
import bytechs.testTask.library.services.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("library/api")
public class LibraryController {

    @Autowired
    LibraryServices libraryServices;

    @GetMapping(value = "/setLibrary")
    @ResponseStatus(value = HttpStatus.OK)
    public Library createLibrary(@RequestParam(value = "nameLibrary", required = true) String nameLibrary) {
        return libraryServices.createLibrary(nameLibrary);
    }


}
