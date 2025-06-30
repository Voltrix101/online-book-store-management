package com.crni99.bookstore.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.crni99.bookstore.model.Book;
import com.crni99.bookstore.repository.BookRepository;
import com.crni99.bookstore.dto.BookRequest;
import com.crni99.bookstore.dto.BookResponse;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Page<Book> findPaginated(Pageable pageable, String term) {

		return page(pageable, term);
	}

	private Page<Book> page(Pageable pageable, String term) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		ArrayList<Book> books;
		List<Book> list;

		if (term == null) {
			books = (ArrayList<Book>) bookRepository.findAll();
		} else {
			books = (ArrayList<Book>) bookRepository.findByNameContaining(term);
		}

		if (books.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, books.size());
			list = books.subList(startItem, toIndex);
		}

		Page<Book> bookPage = new PageImpl<Book>(list, PageRequest.of(currentPage, pageSize), books.size());

		return bookPage;
	}

	public void save(Book book) {
		bookRepository.save(book);
	}

	public Optional<Book> findBookById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		return book;
	}

	public void delete(Long id) {
		bookRepository.deleteById(id);
	}

	public BookResponse createBook(BookRequest request) {
		Book book = new Book();
		book.setTitle(request.getTitle());
		book.setAuthor(request.getAuthor());
		book.setCategory(request.getCategory());
		book.setPrice(request.getPrice());
		book.setDescription(request.getDescription());
		book.setCoverImageUrl(request.getCoverImageUrl());
		Book saved = bookRepository.save(book);
		return toResponse(saved);
	}

	public BookResponse getBookById(Long id) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		return toResponse(book);
	}

	public BookResponse updateBook(Long id, BookRequest request) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		book.setTitle(request.getTitle());
		book.setAuthor(request.getAuthor());
		book.setCategory(request.getCategory());
		book.setPrice(request.getPrice());
		book.setDescription(request.getDescription());
		book.setCoverImageUrl(request.getCoverImageUrl());
		Book updated = bookRepository.save(book);
		return toResponse(updated);
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	public List<BookResponse> listBooks() {
		return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
				.map(this::toResponse)
				.collect(Collectors.toList());
	}

	private BookResponse toResponse(Book book) {
		return new BookResponse(
				book.getId(),
				book.getTitle(),
				book.getAuthor(),
				book.getCategory(),
				book.getPrice(),
				book.getDescription(),
				book.getCoverImageUrl()
		);
	}

}
