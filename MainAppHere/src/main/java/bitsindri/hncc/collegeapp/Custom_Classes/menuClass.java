package bitsindri.hncc.collegeapp.Custom_Classes;

public class menuClass {
    String itemCategory;
    int imgResource;

    public menuClass(String itemCategory, int imgResource) {
        this.itemCategory = itemCategory;
        this.imgResource = imgResource;
    }


    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
