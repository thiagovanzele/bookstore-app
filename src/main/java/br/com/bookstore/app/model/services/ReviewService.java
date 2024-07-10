package br.com.bookstore.app.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookstore.app.model.entities.Review;
import br.com.bookstore.app.model.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	public Optional<Review> findReviewById(Long id) {
		return repository.findById(id);
	}
	
	public List<Review> findAll() {
		return repository.findAll();
	}
	
	public Review insert(Review review) {
		return repository.save(review);
	}
	
	public Review updateReview(Long id, Review obj) {
		Review review = repository.getReferenceById(id);
		updateData(review, obj);
		return repository.save(review);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void updateData(Review review, Review obj) {
		review.setComment(obj.getComment());
		review.setBook(review.getBook());
	}
	
	

	
}
