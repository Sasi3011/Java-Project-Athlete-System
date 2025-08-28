import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProfileManager {
    private List<Athlete> athletes;
    private Map<Athlete, List<Document>> documents;
    private Map<Athlete, Verifier.VerificationStatus> verificationStatus;

    public ProfileManager() {
        athletes = new ArrayList<>();
        documents = new HashMap<>();
        verificationStatus = new HashMap<>();
    }

    public void addProfile(Athlete athlete) {
        if (athletes.contains(athlete)) {
            throw new IllegalArgumentException("Athlete already exists");
        }
        athletes.add(athlete);
        documents.put(athlete, new ArrayList<>());
        verificationStatus.put(athlete, Verifier.VerificationStatus.PENDING);
    }

    public void addDocument(Athlete athlete, Document document) {
        if (!athletes.contains(athlete)) {
            throw new IllegalArgumentException("Athlete not found");
        }
        documents.get(athlete).add(document);
    }

    public void verifyProfile(Athlete athlete, Verifier verifier) {
        if (!athletes.contains(athlete)) {
            throw new IllegalArgumentException("Athlete not found");
        }
        List<Document> athleteDocs = documents.get(athlete);
        if (athleteDocs.isEmpty()) {
            verificationStatus.put(athlete, Verifier.VerificationStatus.PENDING);
            return;
        }
        Verifier.VerificationStatus status = verifier.verifyProfile(athlete, athleteDocs.get(0));
        verificationStatus.put(athlete, status);
    }

    public List<Athlete> searchProfile(String query) {
        return athletes.stream()
                .filter(a -> a.getName().toLowerCase().contains(query.toLowerCase()) ||
                        a.getSport().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Athlete> sortByAge() {
        return athletes.stream()
                .sorted((a1, a2) -> Integer.compare(a1.getAge(), a2.getAge()))
                .collect(Collectors.toList());
    }

    public List<Athlete> filterByStatus(Verifier.VerificationStatus status) {
        return athletes.stream()
                .filter(a -> verificationStatus.get(a) == status)
                .collect(Collectors.toList());
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Athlete Report:\n");
        report.append("Total Athletes: ").append(athletes.size()).append("\n");
        for (Athlete athlete : athletes) {
            report.append(athlete.toString())
                    .append(", Status: ").append(verificationStatus.get(athlete))
                    .append(", Documents: ").append(documents.get(athlete).size())
                    .append("\n");
        }
        return report.toString();
    }
}