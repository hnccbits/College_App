package bitsindri.hncc.collegeapp.Custom_Classes;

public class menuClass {
    String itemCategory;
    int imgResource;
    String Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public menuClass(String itemCategory, String Description, int imgResource) {
        this.itemCategory = itemCategory;
        this.imgResource = imgResource;
        this.Description = Description;
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
