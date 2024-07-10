package br.com.bookstore.app.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookstore.app.model.entities.Author;
import br.com.bookstore.app.model.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository repository;
	
	public Optional<Author> findAuthorById(Long id) {
		return repository.findById(id);
	}
	
	public List<Author> findAll() {
		return repository.findAll();
	}
	
	public Author insert(Author obj) {
		return repository.save(obj);
	}
	
	public Author update(Long id, Author obj) {
		Author author = repository.getReferenceById(id);
		updateData(author, obj);
		return repository.save(author);
	}

	private void updateData(Author author, Author obj) {
		author.setName(obj.getName());
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
