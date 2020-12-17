package bitsindri.hncc.collegeapp.Custom_Classes;

import com.google.gson.annotations.SerializedName;

public class Data {
//    @SerializedName("ID")
//    private  String id;


//    @SerializedName("name")
//    private  String name;
//    @SerializedName("branch")
//    private  String branch;
//    @SerializedName("url")
//    private  String url;
//    @SerializedName("category")
//    private  String category;
//
//    public Data(String name, String branch, String category, String url) {
//        this.name = name;
//        this.branch = branch;
//        this.url = url;
//        this.category = category;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getBranch() {
//        return branch;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public String getCategory() {
//        return category;
//    }
        @SerializedName("branch")
    private  String branch;

    @SerializedName("sub")
    private  String sub;


    @SerializedName("sem")
    private  String sem;

    @SerializedName("url")
    private  String url;

    public String getBranch() {
        return branch;
    }

    public String getSub() {
        return sub;
    }

    public String getSem() {
        return sem;
    }

    public String getUrl() {
        return url;
    }

    public Data(String branch, String sub, String sem, String url) {
        this.branch = branch;
        this.sub = sub;
        this.sem = sem;
        this.url = url;
    }
}
