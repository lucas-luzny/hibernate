package pl.sdaacademy.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "book" )
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "book_id"))})
public class Book extends BaseModel {

    public static final String TABLE_NAME = "Book";

    private String id;
    @Column(name = "book_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(name = "book_type")

    private BookType bookType;

    public Book() {
    }

    public Book(String name, Author author, BookType bookType) {
        this.name = name;
        this.author = author;
        this.bookType = bookType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author authorId) {
        this.author = authorId;
    }

    @Enumerated(EnumType.STRING)
    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", bookType=" + bookType +
                '}';
    }
}
