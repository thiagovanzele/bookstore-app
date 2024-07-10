package br.com.bookstore.app.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bookstore.app.model.entities.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{

}
