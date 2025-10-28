// Log.java
import java.util.Date;

public class Log {
    private String note;
    private Date date;

    public Log(String note, Date date) {
        this.note = note;
        this.date = date;
    }

    // Getters
    public String getNote() {
        return note;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Log{" +
                "note='" + note + '\'' +
                ", date=" + date +
                '}';
    }
}