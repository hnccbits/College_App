package bitsindri.hncc.collegeapp.Custom_Classes;

public class EmptyClass {
    private  int mImageResource;
    private String content;     // for name of authority



    public EmptyClass(String content) {
        this.content = content;
    }

    public EmptyClass(int mImageResource, String content) {
        this.mImageResource = mImageResource;
        this.content = content;

    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }
    public int getmImageResource() {
        return mImageResource;
    }

    public String getUsername() {
        return content;
    }

    public void setUsername(String username) {
        this.content = username;
    }





}
