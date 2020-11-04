package bitsindri.hncc.collegeapp.GetterAndSetter;

public class feed {

    String profileName, postDateAndTime, postImageUrl, postMessage, postLikes;

    public feed(String profileName, String postDateAndTime, String postImageUrl, String postMessage, String postLikes) {
        this.profileName = profileName;
        this.postDateAndTime = postDateAndTime;
        this.postImageUrl = postImageUrl;
        this.postMessage = postMessage;
        this.postLikes = postLikes;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getPostDateAndTime() {
        return postDateAndTime;
    }

    public void setPostDateAndTime(String postDateAndTime) {
        this.postDateAndTime = postDateAndTime;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    public String getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(String postLikes) {
        this.postLikes = postLikes;
    }

}
