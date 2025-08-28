// Event.java
import java.util.Date;

public class Event {
    private String name;
    private Date date;

    public Event(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    // Getters
    public String getName() { return name; }
    public Date getDate() { return date; }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}