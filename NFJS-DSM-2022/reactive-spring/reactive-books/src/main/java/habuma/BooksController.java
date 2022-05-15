package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BooksController {

	private BookRepository repo;

	public BooksController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public Flux<Book> books() {
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Book> byId(@PathVariable("id") Long id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public Mono<Book> save(@RequestBody Book book) {
		return repo.save(book);
	}
	
}
