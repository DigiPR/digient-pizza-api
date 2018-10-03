/*
 * Copyright (c) 2018. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rocks.process.pizza.data.domain.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findPizzaOrdersByPizza(@Param("pizza") String pizza);
    List<Order> findPizzaOrdersByCrust(@Param("crust") String crust);
    List<Order> findPizzaOrdersByPizzaAndCrust(@Param("pizza") String pizza, @Param("crust") String crust);
}
