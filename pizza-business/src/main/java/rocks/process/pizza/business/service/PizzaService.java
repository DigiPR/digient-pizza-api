/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.process.pizza.data.domain.Order;
import rocks.process.pizza.data.repository.OrderRepository;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrderWithPizzaAndCrust(String pizza, String crust) {
        Order order = new Order(pizza, crust);
        return orderRepository.save(order);
    }

    public void deleteOrderById(String orderId) {
        orderRepository.deleteById(Long.parseLong(orderId));
    }

    public List<Order> findOrdersByPizzaOrcrust(String pizza, String crust) {
        if((pizza != null && !"".equals(pizza)) && (crust != null && !"".equals(crust)))
            return orderRepository.findPizzaOrdersByPizzaAndCrust(pizza,crust);
        else if (pizza != null && !"".equals(pizza))
            return orderRepository.findPizzaOrdersByPizza(pizza);
        else if (crust != null && !"".equals(crust))
            return orderRepository.findPizzaOrdersByCrust(crust);
        return orderRepository.findAll();
    }

    public Order readOrderById(String orderId) {
        return orderRepository.findById(Long.parseLong(orderId)).orElse(null);
    }

    public Order updateOrderByIdWithPizzaAndCrust(String orderId, String pizza, String crust) {
        Order order = new Order(pizza, crust);
        order.setOrderId(Long.parseLong(orderId));
        return orderRepository.save(order);
    }

}
