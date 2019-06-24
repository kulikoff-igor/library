package bytechs.testTask.library.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Journal")
public class Journal {
    private int journalId;
    private User user;
    private Book book;
    private String startDate;
    private Boolean bookIsBack;
    private Library library;

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
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
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
