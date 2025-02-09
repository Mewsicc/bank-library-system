package com.navachart.library_system.services;

import com.navachart.library_system.models.Book;
import com.navachart.library_system.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book) throws Exception{
        bookRepository.save(book);
    }

    public Optional<Book> findById(Integer id) throws Exception{
        return bookRepository.findById(id);
    }

    public List<Book> findAllByName(String name) throws  Exception{
        return bookRepository.findAllByName(name);
    }

    public void updateBook(Integer id,Book book) throws Exception{
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();

            bookToUpdate.setName(book.getName());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setGenre(book.getGenre());
        } else {
            throw new Exception("Book not found with id: " + id);
        }
    }

    public void deleteById(Integer id) throws Exception{

        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new Exception("Book not found with id: " + id);
        }

    }
}
