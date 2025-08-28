public class Verifier extends User {
    public enum VerificationStatus { VERIFIED, PENDING, REJECTED }

    public Verifier(String name) {
        super(name);
    }

    public VerificationStatus verifyProfile(Athlete athlete, Document document) {
        if (athlete.getAge() < 15) {
            return VerificationStatus.REJECTED;
        }
        if (document.getDocType().equalsIgnoreCase("ID") || document.getDocType().equalsIgnoreCase("Certificate")) {
            return VerificationStatus.VERIFIED;
        }
        return VerificationStatus.PENDING;
    }
}