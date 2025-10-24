package org.ssupstart.bookmanagement.exceptions;


public class BookNotFoundException extends RuntimeException { //visrlo hoto

    public BookNotFoundException(Long id) {
        super("Book not find with Id : " + id);
    }
}
