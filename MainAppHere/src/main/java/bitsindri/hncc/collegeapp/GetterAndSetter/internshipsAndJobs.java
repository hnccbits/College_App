package bitsindri.hncc.collegeapp.GetterAndSetter;

public class internshipsAndJobs {
    String title, description;

    public internshipsAndJobs(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
