// Achievement.java
public class Achievement {
    private String name;
    private String description;

    public Achievement(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Added getter methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}