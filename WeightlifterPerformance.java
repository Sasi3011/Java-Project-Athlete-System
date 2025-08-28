// WeightlifterPerformance.java
public class WeightlifterPerformance extends Performance {
    private double maxWeightLifted = 0.0;

    @Override
    public void updateMetric(double weight, double ignored) {
        if (weight > maxWeightLifted) maxWeightLifted = weight;
    }

    @Override
    public double getPrimaryMetric() {
        return maxWeightLifted; // Higher is better
    }

    @Override
    public String getDetails() {
        return "Weightlifter: Max Weight=" + maxWeightLifted + "kg";
    }
}