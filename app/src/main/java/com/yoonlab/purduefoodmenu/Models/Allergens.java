package com.yoonlab.purduefoodmenu.Models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root (name = "Allergens")
public class Allergens {

    @ElementList(name = "Allergen", inline = true, required = false)
    private List<Allergen> allergenList;


    public List<Allergen> getAllergenList() {
        return allergenList;
    }
}
