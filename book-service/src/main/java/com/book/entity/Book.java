package com.book.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="book_table")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	@NotBlank(message = "logo cannot be blank")
	private String logo;
	
	@NotBlank(message = "title cannot be blank")
	private String title;
	
	@NotBlank(message = "category cannot be blank")
	private String category;
	
	@Min(value = 1, message = "price cannot be less than 1")
	private int price;
	

	@NotBlank(message = "publisher cannot be blank")
	private String publisher;
	
	@NotNull(message = "Date cannot be blank")
	@DateTimeFormat(style = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate publishedDate;
	
	@NotBlank(message = "content cannot be blank")
	private String content;
	
	@NotNull
	private Boolean active;
	
	@NotBlank(message ="author name is mandatory*")
	private String authorName;
	@NotBlank(message ="reader name should not be blank")
	private String readerMailId;
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getReaderMailId() {
		return readerMailId;
	}
	public void setReaderMailId(String readerMailId) {
		this.readerMailId = readerMailId;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", logo=" + logo + ", title=" + title + ", category=" + category + ", price="
				+ price + ", publisher=" + publisher + ", publishedDate=" + publishedDate + ", content=" + content
				+ ", active=" + active + ", authorName=" + authorName + ", readerMailId=" + readerMailId + "]";
	}
	public Book(int bookId, @NotBlank(message = "logo cannot be blank") String logo,
			@NotBlank(message = "title cannot be blank") String title,
			@NotBlank(message = "category cannot be blank") String category,
			@Min(value = 1, message = "price cannot be less than 1") int price,
			@NotBlank(message = "publisher cannot be blank") String publisher,
			@NotNull(message = "Date cannot be blank") LocalDate publishedDate,
			@NotBlank(message = "content cannot be blank") String content, @NotNull Boolean active,
			@NotBlank(message = "author name is mandatory*") String authorName,
			@NotBlank(message = "reader name should not be blank") String readerMailId) {
		super();
		this.bookId = bookId;
		this.logo = logo;
		this.title = title;
		this.category = category;
		this.price = price;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.active = active;
		this.authorName = authorName;
		this.readerMailId = readerMailId;
	}
	
	
	public Book() {
		
	}
}
