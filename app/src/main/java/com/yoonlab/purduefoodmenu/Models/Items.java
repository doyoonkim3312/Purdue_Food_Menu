package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root (name = "Items")
public class Items {

    @ElementList(name = "Item", inline = true, required = false)
    private List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

}
