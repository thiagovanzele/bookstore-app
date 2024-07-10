package br.com.bookstore.app.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bookstore.app.model.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
