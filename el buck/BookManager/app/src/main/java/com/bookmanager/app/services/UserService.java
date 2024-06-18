package com.bookmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.app.domain.Book;
import com.bookmanager.app.domain.User;
import com.bookmanager.app.repository.UserRepository;


@Service
public class UserService implements AppService<User>{

	@Autowired
	UserRepository userRepository;

	@Autowired
	BookService bookService;

	@Override
	public void create(User user) {
		userRepository.save(user);
	}

	@Override
	public User edit(Long id) {
	Optional<User> optionalUser = userRepository.findById(id);
	if (optionalUser.isPresent()) {
		return optionalUser.get();
	} else{
		throw new RuntimeException("No se pudo editar, no se encontro ningun usuario bajo el id: "+id);
	}
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<Book> lendBook(String title, String author, String genre){
		return bookService.findBooks(title, author, genre);
	} 
	
}
