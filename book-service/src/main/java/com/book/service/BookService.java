package com.book.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repo.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBookById(Integer bookId){
		Book book=null;
		Optional<Book> bopt=bookRepository.findById(bookId);
		if(bopt.isPresent()) {
			book=bopt.get();
		}
		return book;
	}
	
	public Book readBook(String readerMailId, Integer bookId) {
		Book book=null;
		Stream<Book> readBook=bookRepository.findAll().stream().filter(r->r.getReaderMailId().equalsIgnoreCase(readerMailId));
		if(readBook!=null) {
			book=bookRepository.findById(bookId).get();
		}
		return book;
	}
	
	
}
