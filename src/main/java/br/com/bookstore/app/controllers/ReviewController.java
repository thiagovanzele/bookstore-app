package br.com.bookstore.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bookstore.app.model.entities.Review;
import br.com.bookstore.app.model.services.ReviewService;

@RestController()
@RequestMapping("/reviews")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Review>> findReviewById(@PathVariable Long id) {
		Optional<Review> review = service.findReviewById(id);
		return ResponseEntity.ok().body(review);
	}
	
	@GetMapping
	public ResponseEntity<List<Review>> findAll() {
		List<Review> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Review> insert(@RequestBody Review obj) {
		Review newReview = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newReview);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Review> update(@PathVariable Long id,@RequestBody Review obj) {
		obj = service.updateReview(id, obj);
		return ResponseEntity.ok(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
