// ProfileManager.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileManager {
    private List<Athlete> athletes = new ArrayList<>();
    private Map<Athlete, List<Document>> documents = new HashMap<>();
// Add to ProfileManager.java
public List<Document> getDocuments(Athlete athlete) {
    return documents.getOrDefault(athlete, new ArrayList<>());
}
    public void addProfile(Athlete athlete) {
        athletes.add(athlete);
        documents.put(athlete, new ArrayList<>());
    }

    public void addDocument(Athlete athlete, Document doc) {
        if (documents.containsKey(athlete)) {
            documents.get(athlete).add(doc);
        }
    }

    public void verifyProfile(Athlete athlete, Verifier verifier) {
        if (documents.containsKey(athlete) && !documents.get(athlete).isEmpty()) {
            for (Document doc : documents.get(athlete)) {
                verifier.verifyDocument(doc);
            }
            athlete.setVerified(true);
            System.out.println("Profile verified for " + athlete.getName());
        } else {
            throw new IllegalStateException("No documents to verify for " + athlete.getName());
        }
    }

    public Athlete searchProfile(String name) {
        for (Athlete a : athletes) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }
}