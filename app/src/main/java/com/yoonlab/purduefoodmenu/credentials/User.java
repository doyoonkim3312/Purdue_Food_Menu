package com.yoonlab.purduefoodmenu.credentials;

import java.util.UUID;

public class User {

    private String passwd;
    private String fName;
    private String lName;
    private UUID UID;


    public User( String firstName, String lastName, String password)
    {
        passwd = password;
        fName = firstName;
        lName = lastName;
        UID = UUID.randomUUID();
    }


    //GETTERS
    public String getPassword() {
        return passwd;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public UUID getUID() {
        return UID;
    }


    //SETTERS
    public void setPassword(String passwd) {
        this.passwd = passwd;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
