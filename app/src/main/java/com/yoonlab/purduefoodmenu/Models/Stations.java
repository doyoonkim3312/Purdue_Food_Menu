package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root (name = "Stations")
public class Stations {

    @ElementList(name = "Station", inline = true, required = false)
    private List<Station> stationList;

    public List<Station> getStationList() {
        return stationList;
    }

}
