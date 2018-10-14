package rocks.process.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PizzaEurekaRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaEurekaRegistryApplication.class, args);
    }
}
