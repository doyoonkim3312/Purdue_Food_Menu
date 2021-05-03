package com.yoonlab.purduefoodmenu.credentials;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class UserDB implements Serializable
{
    private ArrayList<User> userArrayList = new ArrayList<>();

    //Empty Constructor
    public UserDB()
    {
        //Empty Constructor
    }


    //1. method that adds User to UserDB arraylist.
    public void adduNewUser(User user) {
        userArrayList.add(user);
    }

    //2. method that returns certain user from UserDB arraylist.
    public User getSpecificUser(UUID uid)
    {
        User returnUser = new User("1234", "guest", "");
        for (User user: userArrayList) {
            if (user.getUID() == uid) {
                returnUser = user;
            } else {
                continue;
            }
        }
        return returnUser;
    }

    //4. method that copies arrayList from input parameter.
    public void setUpdatedUserArrayList(ArrayList<User> userArrayList)
    {
        for (int index = 0; index < userArrayList.size(); index++)
        {
            this.userArrayList.set(index, userArrayList.get(index));
        }
    }


    //Getters
    public ArrayList<User> getUserArrayList()
    {
        return userArrayList;
    }
}
