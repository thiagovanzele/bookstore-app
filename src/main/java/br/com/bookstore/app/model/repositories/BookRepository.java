package br.com.bookstore.app.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bookstore.app.model.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book findBookByTitleContainingIgnoreCase(String title);
}
