/*
 * Copyright (c) 2019. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class MenuRepository{
    private List<String> menuItems = new ArrayList<>();

    public String getMenuItems() {
        return String.join(", ",  menuItems);
    }

    public void setMenuItem(String menuItem) {
        if(!menuItem.isEmpty())
            menuItems.add(menuItem);
    }

    public String getRandomMenuItem() {
        return menuItems.get(new Random().nextInt(menuItems.size()));
    }
}
