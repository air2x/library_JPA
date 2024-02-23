package ru.maxima.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(rs.getInt("id"));
        book.setNameOfBook(rs.getString("name_of_book"));
        book.setAuthorOfBook(rs.getString("author_of_book"));
        book.setYearOfWritingBook(rs.getInt("year_of_writing_book"));
        book.setPersonId(rs.getInt("person_id"));

        return book;
    }
}
