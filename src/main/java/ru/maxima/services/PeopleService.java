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
public class PeopleService {

    private final PeopleRepository peopleRepository;
    private final BooksRepository booksRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository, BooksRepository booksRepository) {
        this.peopleRepository = peopleRepository;
        this.booksRepository = booksRepository;
    }

    public List<Person> findAllPeople() {
        return peopleRepository.findAll();
    }

    public Person findOnePerson(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void savePerson(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void updatePerson(int id, Person updatePerson) {
        updatePerson.setId(id);
        updatePerson.setYearOfBirth(updatePerson.getYearOfBirth());
        updatePerson.setFullName(updatePerson.getFullName());
        peopleRepository.save(updatePerson);
    }

    @Transactional
    public void deletePerson(int id) {
        peopleRepository.deleteById(id);
    }

    public List<Book> showBooksOnTheHands(int personId) {
        return booksRepository.findBooksByPersonId(personId);
    }

}
