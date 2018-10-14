/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.api;

import rocks.process.pizza.model.OrderDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface DefaultApi {

    @WebMethod
    public OrderDTO createOrder(OrderDTO orderDTO);

    @WebMethod
    public void deleteOrder(String orderId);

    @WebMethod
    public List<OrderDTO> findOrders(String pizza, String curst);

    @WebMethod
    public OrderDTO readOrder(String orderId);

    @WebMethod
    public OrderDTO updateOrder(OrderDTO orderDTO);
}

