package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root (name = "Station")
public class Station {

    @Element(name = "Name")
    private String stationName;

    @Element(name = "Items", required = false)
    private Items items;

    public String getStationName() {
        return stationName;
    }

    public Items getItems() {
        return items;
    }

}
