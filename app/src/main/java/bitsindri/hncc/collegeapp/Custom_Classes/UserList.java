package bitsindri.hncc.collegeapp.Custom_Classes;

import java.util.ArrayList;

import xute.storyview.StoryModel;

public class UserList {
    public ArrayList<ArrayList<StoryModel>> user=new ArrayList<ArrayList<StoryModel>>();
    public   String userName;
    public String time;

    public UserList(ArrayList<ArrayList<StoryModel>> user, String userName, String time) {
        this.user = user;
        this.userName = userName;
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<ArrayList<StoryModel>> getUser() {
        return user;
    }

    public void setUser(ArrayList<ArrayList<StoryModel>> user) {
        this.user = user;
    }
}
