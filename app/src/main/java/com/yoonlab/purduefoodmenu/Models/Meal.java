package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Meal")
public class Meal {

    @Element(name = "ID")
    private String mealId;

    @Element (name = "Name")
    private String mealName;

    @Element (name = "Order")
    private int order;

    @Element (name = "Status")
    private String status;

    @Element (name = "Type")
    private String mealType;

    @Element (name = "Hours", required = false)
    private Hours hours;

    @Element (name = "Stations", required = false)
    private Stations stations;

    public Hours getHours() {
        return hours;
    }

    public String getMealType() {
        return mealType;
    }

    public Stations getStations() {
        return stations;
    }
}
