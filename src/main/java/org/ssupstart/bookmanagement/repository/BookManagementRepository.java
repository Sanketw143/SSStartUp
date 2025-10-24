package org.ssupstart.bookmanagement.repository;


import org.springframework.stereotype.Repository;
import org.ssupstart.bookmanagement.dummylocalentity.Book;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

//Note this class represents in memory database management
@Repository
public class BookManagementRepository {

    private final Map<Long, Book> books = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public List<Book> getAllBoooks() {
        return books.values().stream().toList();
    }

    //cross check this once again
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(idGenerator.incrementAndGet());
        }
        books.put(book.getId(), book);
        return book;
    }

    public Optional<Book> updateBook(Book book) {
        return Optional.ofNullable(books.get(book.getId()));
    }

    public void deleteBook(Long id) {
        books.remove(id);
    }

    public List<Book> getLatestBook() {
        return books.values().stream().sorted(Comparator.comparing(Book :: getCreatedAt).reversed()).limit(10).toList();
    }
}
