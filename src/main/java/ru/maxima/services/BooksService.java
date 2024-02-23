package ru.maxima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.model.Book;
import ru.maxima.model.Person;
import ru.maxima.repositories.BooksRepository;
import ru.maxima.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final PeopleRepository peopleRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(PeopleRepository peopleRepository, BooksRepository booksRepository) {
        this.peopleRepository = peopleRepository;
        this.booksRepository = booksRepository;
    }

    public List<Book> findAllBooks() {
        return booksRepository.findAll();
    }

    public Book findOneBook(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    @Transactional
    public void saveBook(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void updateBook(int id, Book updateBook) {
        updateBook.setId(id);
        updateBook.setNameOfBook(updateBook.getNameOfBook());
        updateBook.setAuthorOfBook(updateBook.getAuthorOfBook());
        updateBook.setYearOfWritingBook(updateBook.getYearOfWritingBook());
        booksRepository.save(updateBook);
    }

    @Transactional
    public void deleteBook(int id) {
        booksRepository.deleteById(id);
    }

    public String getWhoHasTheBook(int bookId) {
        return peopleRepository.findPersonFullNameByBookId(bookId);
    }

    public void assignABook(int bookId, Person person) {
        Book book = booksRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));
        book.setPersonId(person.getId());
        booksRepository.save(book);
    }

    public void freeTheBook(int bookId) {
        Book book = booksRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found with id: " + bookId));
        book.setPersonId(0);
        booksRepository.save(book);
    }
}
