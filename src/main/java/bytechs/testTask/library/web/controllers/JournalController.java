package bytechs.testTask.library.web.controllers;

import bytechs.testTask.library.dao.model.Journal;
import bytechs.testTask.library.services.JournalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("library/api/journal")
public class JournalController {
    @Autowired
    JournalServices journalServices;

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.OK)
    public Journal addItemJournal(@RequestParam(value = "nameBook", required = true) String nameBook, @RequestParam(value = "nameLibrary", required = true) String nameLibrary, @RequestParam(value = "login", required = true) String login, @RequestParam(value = "dateBooking", required = true) Date dateBooking) {
        return journalServices.createJournal(login, nameBook, dateBooking, nameLibrary);
    }

    @PostMapping(value = "/edit")
    @ResponseStatus(value = HttpStatus.OK)
    public Journal addItemJournal(@RequestParam(value = "journalId", required = true) Integer journalId, @RequestParam(value = "bookIsBsk", required = true) Boolean bookIsBsk, @RequestParam(value = "nameBook", required = true) String nameBook, @RequestParam(value = "nameLibrary", required = true) String nameLibrary, @RequestParam(value = "login", required = true) String login, @RequestParam(value = "dateBooking", required = true) Date dateBooking) {
        return journalServices.updateJournal(journalId, login, nameBook, dateBooking, bookIsBsk, nameLibrary);
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Journal> getAllJournals() {
        return journalServices.getAllJournal();
    }

}
