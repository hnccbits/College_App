package bitsindri.hncc.collegeapp.GetterAndSetter;

public class comment {
    String commentUserName, commentDateAndTime, commentText;

    public comment(String commentUserName, String commentDateAndTime, String commentText) {
        this.commentUserName = commentUserName;
        this.commentDateAndTime = commentDateAndTime;
        this.commentText = commentText;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentDateAndTime() {
        return commentDateAndTime;
    }

    public void setCommentDateAndTime(String commentDateAndTime) {
        this.commentDateAndTime = commentDateAndTime;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
