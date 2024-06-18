package com.bookmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.app.domain.Book;
import com.bookmanager.app.repository.BookRepository;


@Service
public class BookService implements AppService<Book>{

	@Autowired
	private BookRepository bookRepository; 

	@Override
	public void create(Book book) {
		bookRepository.save(book);
	}

	@Override
	public Book edit(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
			if (optionalBook.isPresent()) {
				return optionalBook.get();
			} else {
				throw new RuntimeException("No se encontro ningún libro con el id: "+id);
			}
	}

	@Override
	public List<Book> findAll(){
		return bookRepository.findAll();
	}

	public void delete(Long id){
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
		} else {
			throw new RuntimeException("No eliminó, no existe el libro en el repositorio bajo id: "+id);
		}
	}

	public void update(Book book){
		if (bookRepository.existsById(book.getId())) {
			bookRepository.save(book);
		} else {
			throw new RuntimeException("No actualizo, no existe el libro en el repositorio bajo id: "+book.getId());
		}
	}

	public List<Book> findBooks(String title, String author, String genre) {
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContaining(title);
        } else if (author != null && !author.isEmpty()) {
            return bookRepository.findByAuthorContaining(author);
        } else if (genre != null && !genre.isEmpty()) {
            return bookRepository.findByGenreContaining(genre);
        } else {
            return findAll();
        }
    }
	
}
