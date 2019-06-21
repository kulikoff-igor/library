package bytechs.testTask.library.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Library")
public class Library {
    private int libraryId;
    private String nameLibrary;
    private List<Book> bookList;
    private List<User> userList;
    private List<Journal> journalList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "libraryId", nullable = false)
    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "library")
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library")
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library")
    public List<Journal> getJournalList() {
        return journalList;
    }

    public void setJournalList(List<Journal> journalList) {
        this.journalList = journalList;
    }

    @Column(name = "nameLibrary", nullable = false, length = 100)
    public String getNameLibrary() {
        return nameLibrary;
    }

    public void setNameLibrary(String nameLibrary) {
        this.nameLibrary = nameLibrary;
    }
}
