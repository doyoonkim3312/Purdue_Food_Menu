package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "Item")
public class Item {

    @Element(name = "ID")
    private String itemId;

    @Element (name = "Name")
    private String itemName;

    @Element (name = "IsVegetarian")
    private boolean isVegetarian;

    @Element (name = "Allergens", required = false)
    private Allergens allergens;

    public String getItemName() {
        return itemName;
    }

    public boolean vegetarianStatus() {
        return isVegetarian;
    }

    public Allergens getAllergens() {
        return allergens;
    }

}
