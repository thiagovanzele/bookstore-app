package br.com.bookstore.app.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookstore.app.model.entities.Book;
import br.com.bookstore.app.model.entities.Publisher;
import br.com.bookstore.app.model.repositories.BookRepository;
import br.com.bookstore.app.model.repositories.PublisherRepository;
import jakarta.transaction.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Autowired
	private PublisherService publisherService;

	public Optional<Book> findById(Long id) {
		return repository.findById(id);
	}

	public List<Book> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Book insert(Book obj) {
		if (obj.getPublisher() != null) {
			Publisher publisher = obj.getPublisher();
			publisher.addBook(obj);
			publisherService.update(publisher.getId(), publisher);
		}
		return repository.save(obj);
	}

	@Transactional
	public Book update(Long id, Book obj) {
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

		updateData(book, obj);
		return repository.save(book);
	}

	private void updateData(Book book, Book obj) {
		book.setTitle(obj.getTitle());
		book.setReview(obj.getReview());

		if (obj.getPublisher() != null) {
			Publisher publisher = publisherService.findById(obj.getPublisher().getId())
					.orElseThrow(() -> new RuntimeException("Publisher not found"));
			publisher.addBook(book); // Atualiza a referência do livro no publisher
		} else {
			if (book.getPublisher() != null) {
				book.getPublisher().getBooks().remove(book);
				book.setPublisher(null);
			}
		}
	}
}
