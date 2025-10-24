package org.ssupstart.bookmanagement.controller;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ssupstart.bookmanagement.dummylocalentity.Book;
import org.ssupstart.bookmanagement.service.BookManagementService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")  // visarlo hoto
public class BookManagementController {

    private final BookManagementService bookManagementService;  // final visrlo hoto

    public BookManagementController(BookManagementService bookManagementService) {
        this.bookManagementService = bookManagementService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookManagementService.getAllBooks();
    };


    @GetMapping("/{id}")  // visrlo hoto
    public Book getBookById(@PathVariable("id") Long id) {  //Eth chukun pathparam vaprla hota check difference
        return bookManagementService.getBookById(id);
    };

    @PostMapping
    public ResponseEntity<Book> createNewBookEntry(@Valid @RequestBody Book book) { //@Valid visarlelo ani ResponseEntity visrlelo
        Book saved = bookManagementService.saveBook(book);
        return ResponseEntity.created(URI.create("saved books " + saved.getId())).body(saved); // check this return
    }

    @PutMapping
    public Book updateBook(@Valid @RequestBody Book book) {
        return bookManagementService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookManagementService.deleteBook(id);
    }

    @GetMapping("/recent")
    public List<Book> getLatestBooks() {
        return bookManagementService.getLatestBooks();
    }

}
