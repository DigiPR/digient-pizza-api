/*
 * Copyright (c) 2019. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.process.pizza.data.MenuRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/api")
public class PizzaAPI {

    @Autowired
    private MenuRepository menuRepository;

    @PostMapping(path = "/pizza", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> postPizza(@RequestBody Pizza pizza) {
        menuRepository.setMenuItem(pizza.getPizzaName());
        return ResponseEntity.accepted().build();
    }

    @GetMapping(path = "/pizza", produces = "application/json")
    public ResponseEntity<Menu> getPizza() {
        return ResponseEntity.ok(new Menu(menuRepository.getMenuItems()));
    }

    @GetMapping(path = "/surprise", produces = "application/json")
    public ResponseEntity<Menu> getSurpriseMenu() {
        return ResponseEntity.ok(new Menu(getRandomMenuItem()));
    }

    static class Pizza {
        private String pizzaName;

        public String getPizzaName() {
            return pizzaName;
        }
    }

    static public class Menu {
        private String menu;

        public Menu(String menu) {
            this.menu = menu;
        }

        public String getMenu() {
            return menu;
        }
    }

    private static String getRandomMenuItem(){
        return getRandomMenuItem(Arrays.asList("pizza", "pasta", "carne", "verdura"));
    }

    private static String getRandomMenuItem(List<String> items) {
        return items.get(new Random().nextInt(items.size()));
    }

}
