package com.yoonlab.purduefoodmenu.credentials;

public class Manager extends User
{
    private UserType userType;
    private String department;
    private String UID;



    private UserType UserType = userType.MANAGER;

    public Manager(String password, String firstName, String lastName, String department, String userID)
    {
        super(password, firstName, lastName, userID);
        this.department = department;
        this.UID = userID;

    }


    //Getter
    public com.yoonlab.purduefoodmenu.credentials.UserType getUserType() {
        return userType;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String getUID() {
        return UID;
    }


    //Setter
    public void setUserType(com.yoonlab.purduefoodmenu.credentials.UserType userType) {
        this.userType = userType;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void setUID(String UID) {
        this.UID = UID;
    }
}