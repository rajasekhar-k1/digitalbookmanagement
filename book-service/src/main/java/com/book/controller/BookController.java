package com.book.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookController {

	@Autowired
	private BookService bookService;
	
	//get All Books
	@GetMapping("/allBooks")
	public ResponseEntity<Book> findAllBooks(){
		List<Book> book=bookService.getAllBooks();
		ResponseEntity<Book> response;
		if(book==null) {
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			response=new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	@GetMapping("/readers/{emailId}/books/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable String emailId, @PathVariable Integer bookId) {
		
		ResponseEntity<Book> response;
		Book book = bookService.getBookById(bookId);
		if(book == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			response = new ResponseEntity<>(book, HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/readers/{emailId}/{bookId}")
	public Book findBook(@PathVariable Integer bookId, @PathVariable String emailId) {
		return bookService.readBook(emailId, bookId);
	}
	
	@PostMapping("/author/books")
	public Integer addBook(@Valid @RequestBody Book book) {
		bookService.addBook(book);
		return book.getBookId();
	}
}
