package bytechs.testTask.library.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Book")
public class Book {
    private int bookId;
    private String bookName;
    private Set<Author> authorsList;
    private Library library;
    private Boolean status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookId", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int id) {
        this.bookId = id;
    }

    @Column(name = "bookName", nullable = false, length = 100)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "booksList")
    public Set<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(Set<Author> authorsList) {
        this.authorsList = authorsList;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "libraryId", nullable = false)
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Column(name = "status", nullable = false, precision = 0)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
