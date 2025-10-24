package org.ssupstart.bookmanagement.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    @Column(unique = true)  //@uniqueElements mainly work for collection not database related uniqueness
    private String isbn;

    private LocalDate publishedDate;

    @CurrentTimestamp
    private String createdAt;
}
