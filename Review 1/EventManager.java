// EventManager.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<Athlete, List<Event>> events = new HashMap<>();
    private List<Event> allEvents = new ArrayList<>();

    public void createEvent(Event event) {
        allEvents.add(event);
        System.out.println("Event created: " + event.getName());
    }

    public void registerAthlete(Athlete athlete, Event event) {
        if (athlete.isVerified()) {
            events.computeIfAbsent(athlete, k -> new ArrayList<>()).add(event);
            System.out.println(athlete.getName() + " registered for " + event.getName());
        } else {
            throw new IllegalStateException("Athlete not verified");
        }
    }

    public List<Event> getEventsForAthlete(Athlete athlete) {
        return events.getOrDefault(athlete, new ArrayList<>());
    }
}