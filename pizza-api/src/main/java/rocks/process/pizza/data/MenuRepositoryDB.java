/*
 * Copyright (c) 2019. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.pizza.data;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MenuRepositoryDB {
    private Map<String, List<String>> menuItemsDB = new HashMap<>();

    public String getMenuItemsDB(String id) {
        id = Objects.toString(id, "");
        if(menuItemsDB.containsKey(id)){
            return String.join(", ", menuItemsDB.get(id));
        }
        return null;
    }

    public void setMenuItem(String id, String menuItem) {
        id = Objects.toString(id, "");
        if(!menuItemsDB.containsKey(id)){
            menuItemsDB.put(id, new ArrayList<>());
        }
        if(!menuItem.isEmpty())
            menuItemsDB.get(id).add(menuItem);
    }

}
