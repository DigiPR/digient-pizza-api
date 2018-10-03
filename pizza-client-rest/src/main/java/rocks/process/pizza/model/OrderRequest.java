/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.model;

public class OrderRequest {

    private String pizza;
    private String crust;

    public OrderRequest() {
    }

    public OrderRequest(String pizza, String crust) {
        this.pizza = pizza;
        this.crust = crust;
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

