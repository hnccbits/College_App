package bitsindri.hncc.collegeapp.GetterAndSetter;

public class marketplace {
    String itemCategory;
    int itemPrice;

    public marketplace(String itemCategory, int itemPrice) {
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
