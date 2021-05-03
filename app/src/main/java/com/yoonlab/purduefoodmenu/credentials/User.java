package com.yoonlab.purduefoodmenu.credentials;

public class User {

    private String passwd;
    private String fName;
    private String lName;
    private String UID;


    public User(String password, String firstName, String lastName, String userID)
    {
        passwd = password;
        fName = firstName;
        lName = lastName;
        UID = userID;
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

    public String getUID() {
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

    public void setUID(String UID) {
        this.UID = UID;
    }
}
