package LU.practice.InvoicerApp.Utils.Enums;

public enum FileTypes {
    PDF("pdf"),
    XML("xml"),
    HTML("html");

    public String small;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    FileTypes(String small) {
        this.small=small;
    }
}
