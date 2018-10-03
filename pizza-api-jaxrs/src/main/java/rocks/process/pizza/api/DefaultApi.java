/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import rocks.process.pizza.model.OrderRequest;
import rocks.process.pizza.model.OrderResponse;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.List;

/**
 * pizza-api
 *
 * <p>APIML Example
 */
@Path("/")
@Api(value = "/", description = "")
public interface DefaultApi {

    @POST
    @Path("/orders")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = OrderResponse.class)})
    public OrderResponse createOrders(@Valid OrderRequest orderrequest);

    @DELETE
    @Path("/orders/{orderId}")
    @ApiOperation(value = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")})
    public void deleteOrder(@PathParam("orderId") String orderId);

    @GET
    @Path("/orders")
    @Produces({"application/json"})
    @ApiOperation(value = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = OrderResponse.class, responseContainer = "List")})
    public List<OrderResponse> findOrders(@QueryParam("pizza") String pizza, @QueryParam("curst") String curst);

    @GET
    @Path("/orders/{orderId}")
    @Produces({"application/json"})
    @ApiOperation(value = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = OrderResponse.class)})
    public OrderResponse readOrder(@PathParam("orderId") String orderId);

    @PUT
    @Path("/orders/{orderId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @ApiOperation(value = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = OrderResponse.class)})
    public OrderResponse updateOrder(@PathParam("orderId") String orderId, @Valid OrderRequest orderrequest);
}

