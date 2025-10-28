// SwimmerPerformance.java
public class SwimmerPerformance extends Performance {
    private double bestLapTime = Double.MAX_VALUE;

    @Override
    public void updateMetric(double time, double ignored) {
        if (time < bestLapTime) bestLapTime = time;
    }

    @Override
    public double getPrimaryMetric() {
        return bestLapTime; // Lower is better
    }

    @Override
    public String getDetails() {
        return "Swimmer: Lap Time=" + bestLapTime + "s";
    }
}