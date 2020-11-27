package bitsindri.hncc.collegeapp.Custom_Classes;

public class PDFModel {

    private String pdfName;
    private String pdfUrl;
    private  String subject;

    public PDFModel(String pdfName, String subject, String semester, String branch,String pdfUrl) {
        this.pdfName = pdfName;
        this.pdfUrl = pdfUrl;
        this.subject = subject;
        this.semester = semester;
        this.branch = branch;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    private  String semester;
    private  String branch;

    public PDFModel(String pdfName, String pdfUrl) {
        this.pdfName = pdfName;
        this.pdfUrl = pdfUrl;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
