package bitsindri.hncc.collegeapp.models;

public class DynamicRVModel {

    String name;
    int image;

    public DynamicRVModel(String name, int image){
        this.image = image;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }
}
