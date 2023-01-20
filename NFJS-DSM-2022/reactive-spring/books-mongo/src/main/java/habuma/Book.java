package habuma;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cappedDsmBooks")
public record Book(
		@Id String id, 
		String isbn, 
		String title, 
		String author) {}