// Verifier.java (Extends User for verification role)
public class Verifier extends User {
    public Verifier(String name) {
        super(name);
    }

    public void verifyDocument(Document doc) {
        System.out.println("Document " + doc.getDocType() + " verified by " + getName());
    }
}