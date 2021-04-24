package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Menu")
public class Menu {
    public Menu() {}

    @Element(name = "Location")
    private String location;

    @Element (name = "Date")
    private String date;

    @Element (name = "Notes", required = false)
    private String note;

    @Element (name = "Meals")
    private Meals meals;

    public String getLocation() {
        return location;
    }

    public Meals getMeals() {
        return meals;
    }
}
