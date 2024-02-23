package ru.maxima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.maxima.model.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    @Query("SELECT p.fullName FROM Person p JOIN p.books b WHERE b.id = :bookId")
    String findPersonFullNameByBookId(@Param("bookId") Integer bookId);
}
