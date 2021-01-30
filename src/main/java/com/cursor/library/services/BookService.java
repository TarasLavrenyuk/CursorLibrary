package com.cursor.library.services;

import com.cursor.library.daos.BookDao;
import com.cursor.library.exceptions.BadIdException;
import com.cursor.library.exceptions.BookNameIsNullException;
import com.cursor.library.exceptions.BookNameIsTooLongException;
import com.cursor.library.models.Book;
import com.cursor.library.models.CreateBookDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService {

    public final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public Book getById(final String bookId) {
        if (bookId == null || bookId.isBlank()) {
            throw new BadIdException();
        }
        return bookDao.getById(bookId);
    }

    public Book createBook(final CreateBookDto createBookDto) {
        final Book newBook = new Book(UUID.randomUUID().toString());
        newBook.setName(getValidatedBookName(createBookDto.getName()));
        newBook.setDescription(createBookDto.getDescription());
        newBook.setAuthors(createBookDto.getAuthors());
        newBook.setNumberOfWords(createBookDto.getNumberOfWords());
        newBook.setRating(createBookDto.getRating());
        newBook.setYearOfPublication(createBookDto.getYearOfPublication());

        return bookDao.addBook(newBook);
    }

    public String getValidatedBookName(final String name) {
        if (name == null) {
            throw new BookNameIsNullException();
        }
        if (name.length() > 1000) {
            throw new BookNameIsTooLongException();
        }
        return name.trim();
    }
}
