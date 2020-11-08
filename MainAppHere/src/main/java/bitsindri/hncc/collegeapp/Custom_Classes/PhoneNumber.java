package bitsindri.hncc.collegeapp.Custom_Classes;

public class PhoneNumber {
    private  int mImageResource;
    private String username;     // for name of authority

    public int getmImageResource() {
        return mImageResource;
    }

    public PhoneNumber(int mImageResource, String username, String phone_no) {
        this.mImageResource = mImageResource;
        this.username = username;
        this.phone_no = phone_no;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    private String phone_no;     // for number of authority in string.

}
