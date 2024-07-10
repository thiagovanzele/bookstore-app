package br.com.bookstore.app.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bookstore.app.model.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
