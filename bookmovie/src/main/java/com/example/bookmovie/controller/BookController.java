package com.example.bookmovie.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.RestController;

import com.example.bookmovie.model.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class BookController {
//     Method	URL	               Work
// POST	/book/add	            Add Book
// GET	/book/all	            Show All Books
// GET	/book/{id}	            Search Book
// PUT	/book/update/{id}	    Update Book
// DELETE	/book/delete/{id}	Delete Book

   List<Book> book = new ArrayList<>();

   BookController(){
    book.add(new Book(101,"Money","jessie", 990));
    book.add(new Book(102, "Wisdom", "Pinkman", 340));
    book.add(new Book(103, "Clarity", "Peter", 789.40));
    book.add(new Book(104, "Try", "Sutherland", 345));
   }

   @PostMapping("/book/add")
   public String addBook(@RequestBody Book b) {
       book.add(b);
       return "book added";
   }
   
   @GetMapping("/book/all")
   List<Book> getBook() {
       return book;
   }

   @GetMapping("/book/{bid}")
   Book searchById(@PathVariable int bid) {
    for(Book b : book){
        if(b.getBookId() == bid){
            return b;
        }
    }
    return null;
   }
   
   @PutMapping("/book/update/{bid}")
   public Book updateBook(@PathVariable int bid, @RequestBody Book updatedBook) {
    for (Book b : book) {
        if (b.getBookId() == bid) {
            b.setBookName(updatedBook.getBookName());
            b.setAuthor(updatedBook.getAuthor());
            b.setPrice(updatedBook.getPrice());
            return b;
        }
    }
    return null;
   }

   @DeleteMapping("/book/{bid}")
   public Book deleteBook(@PathVariable int bid){
    for(Book b : book){
        if(b.getBookId() == bid){
            book.remove(b);
            return b;
        }
    }
    return null;
   }
   
   
    
}
