// SprinterPerformance.java
public class SprinterPerformance extends Performance {
    private double bestTime100m = Double.MAX_VALUE;
    private double bestTime200m = Double.MAX_VALUE;

    @Override
    public void updateMetric(double time100m, double time200m) {
        if (time100m < bestTime100m) bestTime100m = time100m;
        if (time200m < bestTime200m) bestTime200m = time200m;
    }

    @Override
    public double getPrimaryMetric() {
        return Math.min(bestTime100m, bestTime200m); // Lower is better
    }

    @Override
    public String getDetails() {
        return "Sprinter: 100m=" + bestTime100m + "s, 200m=" + bestTime200m + "s";
    }
}