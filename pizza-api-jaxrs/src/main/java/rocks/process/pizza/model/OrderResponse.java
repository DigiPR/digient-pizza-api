/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class OrderResponse {

    @ApiModelProperty(value = "")
    private String orderId = null;

    @ApiModelProperty(value = "")
    private String pizza = null;

    @ApiModelProperty(value = "")
    private String crust = null;

    /**
     * Get orderId
     *
     * @return orderId
     **/
    @JsonProperty("orderId")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderResponse orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * Get pizza
     *
     * @return pizza
     **/
    @JsonProperty("pizza")
    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public OrderResponse pizza(String pizza) {
        this.pizza = pizza;
        return this;
    }

    /**
     * Get crust
     *
     * @return crust
     **/
    @JsonProperty("crust")
    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public OrderResponse crust(String crust) {
        this.crust = crust;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OrderResponse {\n");

        sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("    pizza: ").append(toIndentedString(pizza)).append("\n");
        sb.append("    crust: ").append(toIndentedString(crust)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

