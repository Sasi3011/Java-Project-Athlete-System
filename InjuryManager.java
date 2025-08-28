// InjuryManager.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InjuryManager {
    private Map<Athlete, List<Injury>> injuries = new HashMap<>();

    public void logInjury(Athlete athlete, Injury injury) {
        injuries.computeIfAbsent(athlete, k -> new ArrayList<>()).add(injury);
        System.out.println("Injury logged for " + athlete.getName());
    }

    public List<Injury> getInjuries(Athlete athlete) {
        return injuries.getOrDefault(athlete, new ArrayList<>());
    }
}