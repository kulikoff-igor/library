package bytechs.testTask.library.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Author")
public class Author {
    private int authorId;
    private String nameAuthor;
    private List<Book> booksList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authorId", nullable = false)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int id) {
        this.authorId = id;
    }

    @Column(name = "nameAuthor", nullable = false, length = 100)
    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }
}
