// HighJumperPerformance.java
public class HighJumperPerformance extends Performance {
    private double maxJumpHeight = 0.0;

    @Override
    public void updateMetric(double height, double ignored) {
        if (height > maxJumpHeight) maxJumpHeight = height;
    }

    @Override
    public double getPrimaryMetric() {
        return maxJumpHeight; // Higher is better
    }

    @Override
    public String getDetails() {
        return "High Jumper: Height=" + maxJumpHeight + "m";
    }
}