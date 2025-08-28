public class Athlete extends User {
    private String name;
    private int age;
    private String gender;
    private String sport;
    private String contact;

    public Athlete(String name, int age, String gender, String sport, String contact) {
        super(name);
        if (age <= 0) throw new IllegalArgumentException("Age must be positive");
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sport = sport;
        this.contact = contact;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Age must be positive");
        this.age = age;
    }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getSport() { return sport; }
    public void setSport(String sport) { this.sport = sport; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    @Override
    public String toString() {
        return "Athlete: " + name + ", Age: " + age + ", Gender: " + gender + ", Sport: " + sport + ", Contact: " + contact;
    }
}