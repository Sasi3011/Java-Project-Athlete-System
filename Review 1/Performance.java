// Performance.java (Abstract for Polymorphism)
public abstract class Performance {
    public abstract void updateMetric(double value1, double value2); // Adjust based on sport
    public abstract double getPrimaryMetric(); // For ranking, e.g., best time or max distance
    public abstract String getDetails();

    // Common method
    public void updateProgress() {
        System.out.println("Progress updated for " + this.getClass().getSimpleName());
    }
}