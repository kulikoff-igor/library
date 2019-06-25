package bytechs.testTask.library.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Journal")
public class Journal {
    private int journalId;
    private User user;
    private Book book;
    private Date startDate;
    private Boolean bookIsBack;
    private Library library;

    public Journal() {
    }

    public Journal(User user, Book book, Date startDate, Boolean bookIsBack, Library library) {
        this.user = user;
        this.book = book;
        this.startDate = startDate;
        this.bookIsBack = bookIsBack;
        this.library = library;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "journalId", nullable = false)
    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
    }

    @OneToOne()
    @JoinColumn(name = "userId", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne()
    @JoinColumn(name = "bookId", nullable = false)
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Column(name = "startDate", nullable = false, length = 100)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "bookIsBack", nullable = false, precision = 0)
    public Boolean getBookIsBack() {
        return bookIsBack;
    }

    public void setBookIsBack(Boolean bookIsBack) {
        this.bookIsBack = bookIsBack;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "libraryId", nullable = false)
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
