package bitsindri.hncc.collegeapp.GetterAndSetter;

import com.google.gson.annotations.SerializedName;

public class marketplace {
//    String itemCategory;
//    int itemPrice;


    @SerializedName("name")
    private String name;

    @SerializedName("batch")
    private String batch;


    @SerializedName("price")
    private String price;

    @SerializedName("category")
    private String category;

    @SerializedName("description")
    private String description;

    @SerializedName("img_url")
    private String img_url;

    public String getName() {
        return name;
    }

    public String getBatch() {
        return batch;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImg_url() {
        return img_url;
    }
//
//    public marketplace(String itemCategory, int itemPrice) {
//        this.itemCategory = itemCategory;
//        this.itemPrice = itemPrice;
//    }
//
//    public String getItemCategory() {
//        return itemCategory;
//    }
//
//    public void setItemCategory(String itemCategory) {
//        this.itemCategory = itemCategory;
//    }
//
//    public int getItemPrice() {
//        return itemPrice;
//    }
//
//    public void setItemPrice(int itemPrice) {
//        this.itemPrice = itemPrice;
//    }
}
