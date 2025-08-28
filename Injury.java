// Injury.java
import java.util.Date;

public class Injury {
    private String type;
    private Date date;
    private String recoveryTimeline;

    public Injury(String type, Date date, String recoveryTimeline) {
        this.type = type;
        this.date = date;
        this.recoveryTimeline = recoveryTimeline;
    }

    // Getters
    public String getType() { return type; }
    public Date getDate() { return date; }
    public String getRecoveryTimeline() { return recoveryTimeline; }

    @Override
    public String toString() {
        return "Injury{" +
                "type='" + type + '\'' +
                ", date=" + date +
                ", recoveryTimeline='" + recoveryTimeline + '\'' +
                '}';
    }
}