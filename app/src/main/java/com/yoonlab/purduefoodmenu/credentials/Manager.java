package com.yoonlab.purduefoodmenu.credentials;

import java.util.UUID;

public class Manager extends User
{
    private UserType userType;
    private String department;
    private UUID emID;
    private UserType UserType = userType.MANAGER;

    public Manager(String password, String firstName, String lastName, String department)
    {
        super(firstName, lastName, password);
        this.department = department;
        this.emID = UUID.randomUUID();
    }

    //Getter
    public UserType getUserType() {
        return userType;
    }

    public String getDepartment() {
        return department;
    }

    //Setter
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}