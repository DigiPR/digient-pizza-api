/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.model;

public class OrderResponse {

    private String orderId = null;
    private String pizza = null;
    private String crust = null;

    public OrderResponse() {
    }

    public OrderResponse(String orderId, String pizza, String crust) {
        this.orderId = orderId;
        this.pizza = pizza;
        this.crust = crust;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }
}

