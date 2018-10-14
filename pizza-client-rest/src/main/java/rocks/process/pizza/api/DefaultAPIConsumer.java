/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rocks.process.pizza.model.OrderRequest;
import rocks.process.pizza.model.OrderResponse;

import java.util.List;

@RestController
public class DefaultAPIConsumer {

    private static Logger logger = LoggerFactory.getLogger(DefaultAPIConsumer.class);

    @Value("${pizza-api.url}")
    private String pizzaAPIURL;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    private void testPizzaOrder()
    {
        OrderRequest orderRequest = new OrderRequest("REST", "lean");
        OrderResponse orderResponse = restTemplate.postForObject(pizzaAPIURL + "/orders", new HttpEntity<>(orderRequest), OrderResponse.class);
        logger.info("Order created with orderId: " + orderResponse.getOrderId() + ".");

        List<OrderResponse> orderResponses = restTemplate.exchange(pizzaAPIURL + "/orders" + "?pizza=REST", HttpMethod.GET, null, new ParameterizedTypeReference<List<OrderResponse>>(){}).getBody();
        logger.info("Order list received with size: " + orderResponses.size() + ".");

        orderRequest.setCrust("update");
        restTemplate.put(pizzaAPIURL + "/orders/" + orderResponse.getOrderId(), new HttpEntity<>(orderRequest));

        orderResponse = restTemplate.getForObject(pizzaAPIURL + "/orders/" + orderResponse.getOrderId(), OrderResponse.class);
        logger.info("Order updated and retrieved with crust: " + orderResponse.getCrust() + ".");

        restTemplate.delete(pizzaAPIURL + "/orders/" + orderResponse.getOrderId());

        orderResponses = restTemplate.exchange(pizzaAPIURL + "/orders", HttpMethod.GET, null, new ParameterizedTypeReference<List<OrderResponse>>(){}).getBody();
        logger.info("Order deleted and list received with size: " + orderResponses.size() + ".");
    }

}
