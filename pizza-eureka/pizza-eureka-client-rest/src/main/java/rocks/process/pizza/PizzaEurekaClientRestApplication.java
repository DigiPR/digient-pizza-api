package rocks.process.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PizzaEurekaClientRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaEurekaClientRestApplication.class, args);
    }
}
