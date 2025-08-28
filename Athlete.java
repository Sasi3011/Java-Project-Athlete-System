// Athlete.java
public class Athlete extends User {
    private int age;
    private String gender;
    private String sport;
    private String contact;
    private Performance performance;
    private boolean verified;

    public Athlete(String name, int age, String gender, String sport, String contact) {
        super(name);
        this.age = age;
        this.gender = gender;
        this.sport = sport;
        this.contact = contact;
        this.verified = false;
        // Convert sport to lowercase for case-insensitive comparison
        String sportLower = sport.toLowerCase();
        switch (sportLower) {
            case "sprinter":
                this.performance = new SprinterPerformance();
                this.sport = "Sprinter"; // Standardize sport name
                break;
            case "long jumper":
                this.performance = new LongJumperPerformance();
                this.sport = "Long Jumper";
                break;
            case "high jumper":
                this.performance = new HighJumperPerformance();
                this.sport = "High Jumper";
                break;
            case "swimmer":
                this.performance = new SwimmerPerformance();
                this.sport = "Swimmer";
                break;
            case "weightlifter":
                this.performance = new WeightlifterPerformance();
                this.sport = "Weightlifter";
                break;
            default:
                throw new IllegalArgumentException("Unknown sport: " + sport);
        }
    }

    // Getters and Setters
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getSport() { return sport; }
    public void setSport(String sport) { this.sport = sport; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public Performance getPerformance() { return performance; }
    public boolean isVerified() { return verified; }
    public void setVerified(boolean verified) { this.verified = verified; }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + getName() + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", sport='" + sport + '\'' +
                ", contact='" + contact + '\'' +
                ", verified=" + verified +
                '}';
    }
}