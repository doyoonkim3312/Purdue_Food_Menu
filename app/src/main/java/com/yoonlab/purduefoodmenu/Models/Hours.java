package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Hours")
public class Hours {

    @Element(name = "StartTime")
    private String startTime;

    @Element(name = "EndTime")
    private String endTime;

    public String[] getOperatingInfo() {
        return new String[]{startTime, endTime};
    }

}
