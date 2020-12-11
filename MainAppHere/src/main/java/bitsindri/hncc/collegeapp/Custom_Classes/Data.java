package bitsindri.hncc.collegeapp.Custom_Classes;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("ID")
    private  String id;


    @SerializedName("name")
    private  String name;


    @SerializedName("branch")
    private  String branch;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
