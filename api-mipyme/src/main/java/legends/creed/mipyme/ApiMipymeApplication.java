package legends.creed.mipyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({ @PropertySource("classpath:queries.properties")})
public class ApiMipymeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMipymeApplication.class, args);
	}

}
