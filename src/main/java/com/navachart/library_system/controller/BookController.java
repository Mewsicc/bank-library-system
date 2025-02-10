package com.navachart.library_system.controller;

import com.navachart.library_system.models.Book;
import com.navachart.library_system.models.JsonResp;
import com.navachart.library_system.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);


    @PostMapping("/books")
    public JsonResp saveBook(@RequestBody Book book){

        String msg = "save successfully";
        try{
            bookService.saveBook(book);
        } catch (Exception e) {
            logger.error("message: {}",e.getMessage());
            msg = "saving error";
        }

        return new JsonResp(msg);
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findBookById(  @PathVariable("id")Integer id){

        Optional<Book> book = null ;
        try {
             book = bookService.findById(id);
        } catch (Exception e) {
            logger.error("message: {}",e.getMessage());
        }

        return book;
    }

    @GetMapping("/books/name/{name}")
    public List<Book> findBookByName(@PathVariable("name")String name){

        List<Book> books = null ;
        try {
            books = bookService.findAllByName(name);
        } catch (Exception e) {
            logger.error("message: {}",e.getMessage());
        }

        return books;
    }

    @PutMapping("books/{id}")
    public JsonResp updateBook(@PathVariable("id")Integer id, @RequestBody Book book){

        String msg = "update successfully";

        try{
           bookService.updateBook(id,book);
        }catch (Exception e){
            logger.error("message: {}",e.getMessage());
            msg = "updating error";
        }

        return new JsonResp(msg);
    }

    @DeleteMapping("books/{id}")
    public JsonResp deleteBookById(@PathVariable("id")Integer id){

        String msg = "delete successfully";

        try{
            bookService.deleteById(id);
        }catch (Exception e){
            logger.error("message: {}",e.getMessage());
            msg = "deleting error";
        }

        return new JsonResp(msg);
    }
}
