package rocks.process.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PizzaEurekaApiJaxrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaEurekaApiJaxrsApplication.class, args);
    }
}
