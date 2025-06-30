package com.crni99.bookstore.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	@NotBlank(message = "{book.title.notBlank}")
	private String title;

	@Column(name = "author", nullable = false)
	@NotBlank(message = "{book.author.notBlank}")
	private String author;

	@Column(name = "category", nullable = false)
	@NotBlank(message = "{book.category.notBlank}")
	private String category;

	@Column(name = "price", nullable = false)
	@NotNull(message = "{book.price.notBlank}")
	private BigDecimal price;

	@Column(name = "description", length = 2000)
	private String description;

	@Column(name = "cover_image_url")
	private String coverImageUrl;

	@Column(name = "isbn", nullable = false)
	@NotBlank(message = "{book.isbn.notBlank}")
	@Pattern(regexp = "\\d{10}|\\d{13}", message = "{book.isbn.size}")
	private String isbn;

	@Column(name = "publisher", nullable = false)
	@NotBlank(message = "{book.publisher.notBlank}")
	private String publisher;

	@Column(name = "published_on", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "{book.date.notNull}")
	private LocalDate publishedOn;

	public Book() {
	}

	public Book(Long id, String title, String author, String category, BigDecimal price, String description,
			String coverImageUrl, String isbn, String publisher, LocalDate publishedOn) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.description = description;
		this.coverImageUrl = coverImageUrl;
		this.isbn = isbn;
		this.publisher = publisher;
		this.publishedOn = publishedOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public LocalDate getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(LocalDate publishedOn) {
		this.publishedOn = publishedOn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category + ", price="
				+ price + ", description=" + description + ", coverImageUrl=" + coverImageUrl + ", isbn=" + isbn
				+ ", publisher=" + publisher + ", publishedOn=" + publishedOn + "]";
	}

}
