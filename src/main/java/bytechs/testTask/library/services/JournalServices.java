package bytechs.testTask.library.services;

import bytechs.testTask.library.dao.model.Journal;
import bytechs.testTask.library.dao.repository.JournalRepository;
import bytechs.testTask.library.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service("journalServices")
@Transactional("transactionManager")
public class JournalServices {
    @Qualifier("journalRepository")
    @Autowired
    JournalRepository journalRepository;
    @Autowired
    UserServices userServices;
    @Autowired
    BookServices bookServices;
    @Autowired
    LibraryServices libraryServices;

    public Journal createJournal(String login, String nameBook, Date dateBooking, String nameLibrary) {
        Journal journal = new Journal(userServices.rerunUserByLogin(login), bookServices.returnBookByName(nameBook), dateBooking, true, libraryServices.returnLibraryByName(nameLibrary));
        return journalRepository.saveAndFlush(journal);
    }

    public Journal updateJournal(Integer journalId, String login, String nameBook, Date dateBooking, Boolean bookIsBsk, String nameLibrary) {
        Journal journal = journalRepository.findByJournalId(journalId);
        journal.setUser(userServices.rerunUserByLogin(login));
        journal.setBook(bookServices.returnBookByName(nameBook));
        journal.setStartDate(dateBooking);
        journal.setBookIsBack(bookIsBsk);
        journal.setLibrary(libraryServices.returnLibraryByName(nameLibrary));
        return journalRepository.saveAndFlush(journal);
    }

    public List<Journal> getAllJournal() {
        return journalRepository.findAll();
    }

}
