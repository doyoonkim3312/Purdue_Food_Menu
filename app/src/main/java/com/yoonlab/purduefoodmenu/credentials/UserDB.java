package com.yoonlab.purduefoodmenu.credentials;

import java.util.ArrayList;

public class UserDB
{
    private ArrayList<User> userArrayList = new ArrayList<>();

    //Empty Constructor
    public UserDB()
    {
        //Empty Constructor
    }


    //1. method that adds User to UserDB arraylist.
    userArrayList.add(new User.userID);

    //2. method that returns certain user from UserDB arraylist.
    public User getSpecificUser(String uid)
    {
        for (int i = 0; i < userArrayList.size(); i++) //https://codereview.stackexchange.com/questions/57726/efficient-way-to-iterate-over-elements-of-array-for-matching-contents-of-another/57730
        {
            if (userArrayList[i].getUID() == uid) //since getUID is a method, make sure you add the () at the end of it when calling it.
            {
                return userArrayList[i]; //Since I'm looking for a specific person BY USING THE uid, we want to return the element withing index "i" in the Array "users".
            }
        }
        return(getSpecificUser);
    }

    //3. method that returns UserDB arrayList.




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


    //Setters
    public void setUserArrayList(ArrayList<User> userArrayList)
    {
        this.userArrayList = userArrayList;
    }
}
