package ru.maxima.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_of_book")
    @NotEmpty(message = "Назавние не должно быть пустым")
    private String nameOfBook;

    @Column(name = "author_of_book")
    @NotEmpty(message = "Автор не должен быть пустым")
    private String authorOfBook;

    @Column(name = "year_of_writing_book")
    private int yearOfWritingBook;

    @Column(name = "person_id")
//    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Integer personId;

    public Book() {
    }

    public Book(int id, String nameOfBook, String authorOfBook, int yearOfWritingBook, int personId) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.authorOfBook = authorOfBook;
        this.yearOfWritingBook = yearOfWritingBook;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public int getYearOfWritingBook() {
        return yearOfWritingBook;
    }

    public void setYearOfWritingBook(int yearOfWritingBook) {
        this.yearOfWritingBook = yearOfWritingBook;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
