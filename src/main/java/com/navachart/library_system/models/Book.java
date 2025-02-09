package com.navachart.library_system.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence_generator")
    @SequenceGenerator(name = "book_sequence_generator", sequenceName = "book_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private String author;
    private String genre;
}
