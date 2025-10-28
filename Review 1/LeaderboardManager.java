// LeaderboardManager.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaderboardManager {
    private Map<Athlete, List<Achievement>> achievements = new HashMap<>();

    public void addAchievement(Athlete athlete, Achievement achievement) {
        achievements.computeIfAbsent(athlete, k -> new ArrayList<>()).add(achievement);
        System.out.println("Achievement added for " + athlete.getName());
    }

    public List<Athlete> generateLeaderboard(List<Athlete> athletes, String sport) {
        List<Athlete> filtered = new ArrayList<>();
        for (Athlete a : athletes) {
            if (a.getSport().equalsIgnoreCase(sport)) {
                filtered.add(a);
            }
        }
        // Sort based on primary metric; assume for times lower better, distances higher better
        // For simplicity, if sport has "Time" assume lower better, else higher
        Comparator<Athlete> comparator;
        if (sport.equals("Sprinter") || sport.equals("Swimmer")) {
            comparator = Comparator.comparingDouble(a -> a.getPerformance().getPrimaryMetric());
        } else {
            comparator = (a1, a2) -> Double.compare(a2.getPerformance().getPrimaryMetric(), a1.getPerformance().getPrimaryMetric());
        }
        filtered.sort(comparator);
        return filtered;
    }

    public List<Achievement> getAchievements(Athlete athlete) {
        return achievements.getOrDefault(athlete, new ArrayList<>());
    }
}