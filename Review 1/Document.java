// Document.java
public class Document {
    private String docType;
    private String docPath; // Simulated path or details

    public Document(String docType, String docPath) {
        this.docType = docType;
        this.docPath = docPath;
    }

    // Getters and Setters
    public String getDocType() { return docType; }
    public void setDocType(String docType) { this.docType = docType; }
    public String getDocPath() { return docPath; }
    public void setDocPath(String docPath) { this.docPath = docPath; }

    @Override
    public String toString() {
        return "Document{" +
                "docType='" + docType + '\'' +
                ", docPath='" + docPath + '\'' +
                '}';
    }
}