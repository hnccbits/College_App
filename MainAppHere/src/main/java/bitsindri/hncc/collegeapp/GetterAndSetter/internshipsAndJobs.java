package bitsindri.hncc.collegeapp.GetterAndSetter;

public class internshipsAndJobs {
    String id, title, url;

    public internshipsAndJobs(String id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
