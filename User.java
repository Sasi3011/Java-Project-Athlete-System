public abstract class User {
    protected String name;

    public User(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public String getName() { return name; }
}