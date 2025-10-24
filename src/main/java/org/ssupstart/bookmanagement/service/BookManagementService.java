package org.ssupstart.bookmanagement.service;


import org.springframework.stereotype.Service;
import org.ssupstart.bookmanagement.dummylocalentity.Book;
import org.ssupstart.bookmanagement.exceptions.BookNotFoundException;
import org.ssupstart.bookmanagement.repository.BookManagementRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookManagementService {

    private final BookManagementRepository bookManagementRepository;

    public BookManagementService(BookManagementRepository bookManagementRepository) {
        this.bookManagementRepository = bookManagementRepository;
    }

    public List<Book> getAllBooks() {
        return bookManagementRepository.getAllBoooks();  // or we can use findAll method of JPA
    }

    public Book getBookById(Long id) {
        return bookManagementRepository.getBookById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book saveBook(Book book) {
        book.setCreatedAt(LocalDateTime.now());
        return bookManagementRepository.save(book);
    }

    public Book updateBook(Book book) {
       Book existingBook = getBookById(book.getId());

       existingBook.setTitle(book.getTitle());
       existingBook.setAuthor(book.getAuthor());
       existingBook.setIsbn(book.getIsbn());
       existingBook.setPublishedDate(book.getPublishedDate());
       return bookManagementRepository.save(book);
    }

    public void deleteBook(Long id) {
        getBookById(id);
        bookManagementRepository.deleteBook(id);
    }

    public List<Book> getLatestBooks() {
        return bookManagementRepository.getLatestBook();
    }
}
