package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Meals")
public class Meals {
    @ElementList(name = "Meal", inline = true)
    private List<Meal> mealList;

    public List<Meal> getMealList() {
        return mealList;
    }
}
