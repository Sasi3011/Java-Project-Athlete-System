// SponsorshipManager.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SponsorshipManager {
    private Map<Athlete, List<Sponsor>> sponsors = new HashMap<>();

    public void addSponsor(Athlete athlete, Sponsor sponsor) {
        sponsors.computeIfAbsent(athlete, k -> new ArrayList<>()).add(sponsor);
        System.out.println("Sponsor added for " + athlete.getName());
    }

    public List<Sponsor> getSponsors(Athlete athlete) {
        return sponsors.getOrDefault(athlete, new ArrayList<>());
    }
}