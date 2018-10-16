/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rocks.process.pizza.api.DefaultApi;
import rocks.process.pizza.business.service.PizzaService;
import rocks.process.pizza.data.domain.Order;
import rocks.process.pizza.model.OrderRequest;
import rocks.process.pizza.model.OrderResponse;

import java.util.ArrayList;
import java.util.List;


/**
 * pizza-api
 *
 * <p>APIML Example
 */
@Component
public class DefaultApiServiceImpl implements DefaultApi {

    @Autowired
    private PizzaService pizzaService;

    public OrderResponse createOrder(OrderRequest orderrequest) {
        Order order = pizzaService.createOrderWithPizzaAndCrust(orderrequest.getPizza(), orderrequest.getCrust());
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setPizza(order.getPizza());
        orderResponse.setCrust(order.getCrust());
        orderResponse.setOrderId(order.getOrderId().toString());
        return orderResponse;
    }

    public void deleteOrder(String orderId) {
        pizzaService.deleteOrderById(orderId);
    }

    public List<OrderResponse> findOrders(String pizza, String curst) {
        List<Order> orders = pizzaService.findOrdersByPizzaOrCurst(pizza, curst);
        List<OrderResponse> orderResponseList = new ArrayList<>();
        OrderResponse orderResponse = null;
        for (Order order : orders) {
            orderResponse = new OrderResponse();
            orderResponse.setPizza(order.getPizza());
            orderResponse.setCrust(order.getCrust());
            orderResponse.setOrderId(order.getOrderId().toString());
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }

    public OrderResponse readOrder(String orderId) {
        Order order = pizzaService.readOrderById(orderId);
        if(order!=null) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setPizza(order.getPizza());
            orderResponse.setCrust(order.getCrust());
            orderResponse.setOrderId(order.getOrderId().toString());
            return orderResponse;
        }
        return null;
    }

    public OrderResponse updateOrder(String orderId, OrderRequest orderrequest) {
        Order order = pizzaService.updateOrderByIdWithPizzaAndCrust(orderId, orderrequest.getPizza(), orderrequest.getCrust());
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setPizza(order.getPizza());
        orderResponse.setCrust(order.getCrust());
        orderResponse.setOrderId(order.getOrderId().toString());
        return orderResponse;
    }

}

