package habuma;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RandomHealthIndicator 
	implements HealthIndicator {

	@Override
	public Health health() {
		double random = Math.random();
		if (random > 0.5) {
			//healthy
			return Health.up()
					.withDetail("reason", "The value is large enough: " + random)
					.build();
		}
		
		//unhealthy
		return Health.down()
				.withDetail("reason", "The value is too low: " + random)
				.build();
	}
	
}
