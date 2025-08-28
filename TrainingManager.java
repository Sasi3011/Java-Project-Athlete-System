// TrainingManager.java
import java.util.HashMap;
import java.util.Map;

public class TrainingManager {
    private Map<Athlete, Performance> performanceData = new HashMap<>();

    public void assignTraining(Athlete athlete) {
        performanceData.put(athlete, athlete.getPerformance());
        System.out.println("Training assigned to " + athlete.getName());
    }

    public void updateProgress(Athlete athlete, double value1, double value2) {
        if (performanceData.containsKey(athlete)) {
            performanceData.get(athlete).updateMetric(value1, value2);
            System.out.println("Progress updated for " + athlete.getName());
        }
    }

    public void generateReport(Athlete athlete) {
        if (performanceData.containsKey(athlete)) {
            System.out.println("Report for " + athlete.getName() + ": " + performanceData.get(athlete).getDetails());
        }
    }
}