package com.cursor.library.daos;

import com.cursor.library.models.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.stream.Collectors;

@Component
public class BookDao {

    private final Map<String, Book> books;

    public BookDao() {
        books = new HashMap<>();

        books.put("random_id_value_1", new Book("random_id_value_1", "Anna Karenina", "", List.of("Leo Tolstoy"), 1877, 864368, 8));
        books.put("random_id_value_2", new Book("random_id_value_1", "Robinson Crusoe", "", List.of("Daniel Defoe"), 1719, 864368, 10));
        books.put("random_id_value_3", new Book("random_id_value_3", "Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future", "", List.of("Ashlee Vance"), 2017, 865874, 10));
        books.put("random_id_value_4", new Book("random_id_value_4", "Brave New World", "", List.of("Aldous Huxley"), 1932, 325874, 10));
        books.put("random_id_value_5", new Book("random_id_value_5", "7 habits of highly effective", "", List.of("Stephen R Covey "), 1989, 464368, 10));
    }

    public List<Book> getAll() {
        return books.values().stream().sorted(Comparator.comparing(Book::getName)).collect(Collectors.toList());
    }

    public Book getById(String bookId) {
        return books.get(bookId);
    }

    public Book deleteById(String bookId) {
        return books.remove(bookId);
    }

    public Book addBook(Book book) {
        return books.put(book.getBookId(), book);
    }
}
