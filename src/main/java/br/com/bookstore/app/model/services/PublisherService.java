package br.com.bookstore.app.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.bookstore.app.model.entities.Publisher;
import br.com.bookstore.app.model.repositories.PublisherRepository;

@Service
public class PublisherService {

	private PublisherRepository repository;
	
	public Optional<Publisher> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<Publisher> findAll() {
		return repository.findAll();
	}
	
	public Publisher insert(Publisher obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Publisher update(Long id, Publisher obj) {
		Publisher publisher = repository.getReferenceById(id);
		updateData(publisher, obj);
		return publisher;
	}

	private void updateData(Publisher publisher, Publisher obj) {
		publisher.setName(obj.getName());
	}
}
