// Sponsor.java
public class Sponsor {
    private String name;
    private double allocatedFunds;

    public Sponsor(String name, double allocatedFunds) {
        this.name = name;
        this.allocatedFunds = allocatedFunds;
    }

    // Getters
    public String getName() { return name; }
    public double getAllocatedFunds() { return allocatedFunds; }

    @Override
    public String toString() {
        return "Sponsor{" +
                "name='" + name + '\'' +
                ", allocatedFunds=" + allocatedFunds +
                '}';
    }
}