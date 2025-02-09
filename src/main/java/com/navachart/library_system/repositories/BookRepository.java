package com.navachart.library_system.repositories;

import com.navachart.library_system.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer> {

    List<Book> findAllByName(String name);
}
