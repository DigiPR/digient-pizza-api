/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.api.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.process.pizza.api.DefaultApi;
import rocks.process.pizza.business.service.PizzaService;
import rocks.process.pizza.data.domain.Order;
import rocks.process.pizza.model.OrderDTO;

import javax.jws.WebService;
import java.lang.reflect.Type;
import java.util.List;

@Service
@WebService(endpointInterface = "rocks.process.pizza.api.DefaultApi")
public class DefaultApiServiceImpl implements DefaultApi {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = pizzaService.createOrderWithPizzaAndCrust(orderDTO.getPizza(), orderDTO.getCrust());
        modelMapper.map(order, orderDTO);
        return orderDTO;
    }

    public void deleteOrder(String orderId) {
        pizzaService.deleteOrderById(orderId);
    }

    public List<OrderDTO> findOrders(String pizza, String curst) {
        List<Order> orders = pizzaService.findOrdersByPizzaOrCurst(pizza, curst);
        Type orderTypeList = new TypeToken<List<OrderDTO>>() {}.getType();
        return modelMapper.map(orders, orderTypeList);
    }

    public OrderDTO readOrder(String orderId) {
        Order order = pizzaService.readOrderById(orderId);
        OrderDTO orderDTO = new OrderDTO();
        modelMapper.map(order, orderDTO);
        return orderDTO;
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        Order order = pizzaService.updateOrderByIdWithPizzaAndCrust(orderDTO.getOrderId(), orderDTO.getPizza(), orderDTO.getCrust());
        modelMapper.map(order, orderDTO);
        return orderDTO;
    }
}