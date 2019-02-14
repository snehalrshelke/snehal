package com.first.four.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class Book {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String psvn;
    private String publisher;
    @ManyToMany
            @JoinTable(name="authors_books",
                    joinColumns = @JoinColumn(name="books_id"),
                    inverseJoinColumns = @JoinColumn(name="authors_id"))
    Set<Author>authors=new HashSet<>();

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", psvn='" + psvn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    Book()
    {

    }

    public Book(String title, String psvn, String publisher) {
        this.title = title;
        this.psvn = psvn;
        this.publisher = publisher;
    }

    public Book(String title, String psvn, String publisher, Set<Author> authors) {
        this.title = title;
        this.psvn = psvn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPsvn() {
        return psvn;
    }

    public void setPsvn(String psvn) {
        this.psvn = psvn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
