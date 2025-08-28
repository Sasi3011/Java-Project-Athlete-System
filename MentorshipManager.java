// MentorshipManager.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MentorshipManager {
    private Map<Athlete, List<Log>> logs = new HashMap<>();

    public void addLog(Athlete athlete, Log log) {
        logs.computeIfAbsent(athlete, k -> new ArrayList<>()).add(log);
        System.out.println("Log added for " + athlete.getName());
    }

    public List<Log> getLogs(Athlete athlete) {
        return logs.getOrDefault(athlete, new ArrayList<>());
    }
}