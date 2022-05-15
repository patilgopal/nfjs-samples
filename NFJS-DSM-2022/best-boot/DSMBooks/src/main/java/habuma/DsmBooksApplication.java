package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DsmBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsmBooksApplication.class, args);
	}

	@Bean
	public ApplicationRunner loader(BookRepository repo) {
		return args -> {
			repo.save(new Book("1111122222", "Knitting with Dog Hair", "Kendall Crolius"));
			repo.save(new Book("3333344444", "Crafting with Cat Hair", "Kaori Tsutaya"));
		};
	}
	
}
