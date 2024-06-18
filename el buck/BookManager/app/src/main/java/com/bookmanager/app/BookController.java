package com.bookmanager.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanager.app.domain.Book;
import com.bookmanager.app.services.BookService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService; 

	@PostMapping
	public void addBook(@RequestBody Book book){
		bookService.create(book);
	}

	@PutMapping("/{id}")
	public void updateBook(@PathVariable Long id, @RequestBody Book book) {
		book.setId(id);
		bookService.update(book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id){
		bookService.delete(id);
	}
	
	@GetMapping("")
	public List<Book> getAllBooks() {
		return bookService.findAll();
	}

	@GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author,
                                  @RequestParam(required = false) String genre) {
        return bookService.findBooks(title, author, genre);
    }
	
	
}
