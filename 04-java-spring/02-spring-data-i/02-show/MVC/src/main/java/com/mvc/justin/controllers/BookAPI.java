package com.mvc.justin.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.justin.models.Book;
import com.mvc.justin.services.BookService;

public class BookAPI {
	 private final BookService bookService;
	 
	 public BookAPI(BookService bookService){
	     this.bookService = bookService;
	 }
	 
	 @RequestMapping("/api/books")
	 public List<Book> index() {
	     return bookService.allBooks();
	 }
	 
	 @RequestMapping(value="/api/books", method=RequestMethod.POST)
	 public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	     Book book = new Book(title, desc, lang, numOfPages);
	     return bookService.createBook(book);
	 }
	 
	 @RequestMapping("/api/books/{id}")
	 public Book show(@PathVariable("id") Long id) {
	     Book book = bookService.findBook(id);
	     return book;
	 }
}
