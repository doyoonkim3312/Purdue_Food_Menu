package com.yoonlab.purduefoodmenu.credentials;

public class Client extends User
{
    private UserType userType = UserType.CLIENT;

    public Client(String firstName, String lastName, String password)
    {
        super(firstName, lastName, password);
        userType = UserType.CLIENT;
    }


    //Getter
    public UserType getUserType() {
        return userType;
    }


    //setter
    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
