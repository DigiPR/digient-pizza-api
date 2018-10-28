/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DefaultAPIConsumer {

    private static Logger logger = LoggerFactory.getLogger(DefaultAPIConsumer.class);

    @Autowired
    private DefaultApi defaultApi;

    @PostConstruct
    private void init()
    {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setPizza("SOAP");
        orderDTO.setCrust("lean");

        orderDTO = defaultApi.createOrder(orderDTO);
        logger.info("Order created with orderId: " + orderDTO.getOrderId() + ".");

        List<OrderDTO> orders = defaultApi.findOrders("SOAP", "");
        logger.info("Order list received with size: " + orders.size() + ".");

        orderDTO.setCrust("update");
        orderDTO = defaultApi.updateOrder(orderDTO);

        orderDTO = defaultApi.readOrder(orderDTO.getOrderId());
        logger.info("Order updated and retrieved with crust: " + orderDTO.getCrust() + ".");

        defaultApi.deleteOrder(orderDTO.getOrderId());
        orders = defaultApi.findOrders("","");
        logger.info("Order deleted and list received with size: " + orders.size() + ".");
    }
}