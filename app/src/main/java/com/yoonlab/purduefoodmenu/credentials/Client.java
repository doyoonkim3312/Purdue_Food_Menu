package com.yoonlab.purduefoodmenu.credentials;

public class Client extends User
{
    private UserType userType = UserType.CLIENT;

    public Client(String password, String firstName, String lastName, String userID)
    {
        super(password, firstName, lastName, userID);
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
