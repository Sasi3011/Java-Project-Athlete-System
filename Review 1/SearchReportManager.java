// SearchReportManager.java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchReportManager {
    private ProfileManager profileManager;
    private InjuryManager injuryManager;
    private SponsorshipManager sponsorshipManager;
    private EventManager eventManager;
    private LeaderboardManager leaderboardManager;
    private MentorshipManager mentorshipManager;

    // Constructor to inject dependencies
    public SearchReportManager(ProfileManager profileManager, InjuryManager injuryManager,
                              SponsorshipManager sponsorshipManager, EventManager eventManager,
                              LeaderboardManager leaderboardManager, MentorshipManager mentorshipManager) {
        this.profileManager = profileManager;
        this.injuryManager = injuryManager;
        this.sponsorshipManager = sponsorshipManager;
        this.eventManager = eventManager;
        this.leaderboardManager = leaderboardManager;
        this.mentorshipManager = mentorshipManager;
    }

    public List<Athlete> searchBySport(List<Athlete> athletes, String sport) {
        List<Athlete> result = new ArrayList<>();
        for (Athlete a : athletes) {
            if (a.getSport().equalsIgnoreCase(sport)) {
                result.add(a);
            }
        }
        return result;
    }

    public List<Athlete> searchByStatus(List<Athlete> athletes, boolean verified) {
        List<Athlete> result = new ArrayList<>();
        for (Athlete a : athletes) {
            if (a.isVerified() == verified) {
                result.add(a);
            }
        }
        return result;
    }

    public void generateReport(List<Athlete> athletes) {
        System.out.println("Generating detailed report for " + athletes.size() + " athletes:");
        for (Athlete a : athletes) {
            System.out.println("\n=== Athlete Details ===");
            System.out.println(a);
            System.out.println("Performance: " + a.getPerformance().getDetails());

            // Documents
            List<Document> documents = profileManager.getDocuments(a);
            System.out.println("Documents: " + (documents.isEmpty() ? "None" : documents));

            // Injuries
            List<Injury> injuries = injuryManager.getInjuries(a);
            System.out.println("Injuries: " + (injuries.isEmpty() ? "None" : injuries));

            // Sponsors
            List<Sponsor> sponsors = sponsorshipManager.getSponsors(a);
            System.out.println("Sponsors: " + (sponsors.isEmpty() ? "None" : sponsors));

            // Events
            List<Event> events = eventManager.getEventsForAthlete(a);
            System.out.println("Events: " + (events.isEmpty() ? "None" : events));

            // Achievements
            List<Achievement> achievements = leaderboardManager.getAchievements(a);
            System.out.println("Achievements: " + (achievements.isEmpty() ? "None" : achievements));

            // Mentorship Logs
            List<Log> logs = mentorshipManager.getLogs(a);
            System.out.println("Mentorship Logs: " + (logs.isEmpty() ? "None" : logs));
        }
    }

    public List<Athlete> sortByName(List<Athlete> athletes) {
        List<Athlete> sorted = new ArrayList<>(athletes);
        sorted.sort(Comparator.comparing(Athlete::getName));
        return sorted;
    }
}