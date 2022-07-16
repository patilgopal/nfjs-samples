package habuma;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class CountController {

	@GetMapping(path="/count", produces="application/stream+json")
	public Flux<CountItem> counter() {
		return Flux.interval(Duration.ofSeconds(1))
//				.take(10)
				.map(c -> new CountItem(c, System.currentTimeMillis()));
	}
	
}
