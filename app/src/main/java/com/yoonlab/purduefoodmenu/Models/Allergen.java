package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "Allergen")
public class Allergen {

    @Element (name = "Name")
    private String ingredientName;

    @Element(name = "Value")
    private boolean allergenStatus;

    public String getIngredientName() {
        return ingredientName;
    }

    public boolean getAllergenStatus() {
        return allergenStatus;
    }

}
