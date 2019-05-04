/*
 * Copyright (c) 2019. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.process.pizza.data.MenuRepositoryDB;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/api")
public class PizzaAPI {

    @Autowired
    private MenuRepositoryDB menuRepositoryDB;

    @GetMapping(path = "/pizza", produces = "application/json")
    public ResponseEntity<Menu> getPizza(@RequestParam(value = "tenantId", required = false, defaultValue = "") String tenantId) {
        return ResponseEntity.ok(new Menu(menuRepositoryDB.getMenuItemsDB(tenantId)));
    }

    @GetMapping(path = "/surprise", produces = "application/json")
    public ResponseEntity<Menu> getSurpriseMenu() {
        return ResponseEntity.ok(new Menu(getRandomMenuItem()));
    }

    @PostMapping(path = "/pizza", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> postPizza(@RequestParam(value = "tenantId", required = false, defaultValue = "") String tenantId, @RequestBody Pizza pizza) {
        menuRepositoryDB.setMenuItem(tenantId, pizza.getPizzaName());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/pizza")
    public ResponseEntity<Void> flushPizza(@RequestParam(value = "tenantId", required = false, defaultValue = "") String tenantId) {
        menuRepositoryDB.flushMenuItems(tenantId);
        return ResponseEntity.ok().build();
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
