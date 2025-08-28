// LongJumperPerformance.java
public class LongJumperPerformance extends Performance {
    private double longestJumpDistance = 0.0;

    @Override
    public void updateMetric(double distance, double ignored) {
        if (distance > longestJumpDistance) longestJumpDistance = distance;
    }

    @Override
    public double getPrimaryMetric() {
        return longestJumpDistance; // Higher is better
    }

    @Override
    public String getDetails() {
        return "Long Jumper: Distance=" + longestJumpDistance + "m";
    }
}