package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Hours")
public class Hours {

    @Element(name = "StartTime")
    private String startTime;

    @Element(name = "EndTime")
    private String endTime;

    public int[] getOperatingInfo() {
        int startTimeInt = Integer.parseInt(startTime.replace(":",""));
        int endTimeInt = Integer.parseInt(endTime.replace(":", ""));
        return new int[]{startTimeInt, endTimeInt};
    }

}
