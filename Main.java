// Main.java
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProfileManager profileManager = new ProfileManager();
        TrainingManager trainingManager = new TrainingManager();
        InjuryManager injuryManager = new InjuryManager();
        SponsorshipManager sponsorshipManager = new SponsorshipManager();
        EventManager eventManager = new EventManager();
        LeaderboardManager leaderboardManager = new LeaderboardManager();
        InventoryManager inventoryManager = new InventoryManager();
        MentorshipManager mentorshipManager = new MentorshipManager();
        SearchReportManager searchReportManager = new SearchReportManager(profileManager, injuryManager, sponsorshipManager, eventManager, leaderboardManager, mentorshipManager);
        Verifier verifier = new Verifier("AdminVerifier");

        boolean running = true;
        while (running) {
            System.out.println("\nAthlete Management System Menu:");
            System.out.println("1. Add Athlete Profile");
            System.out.println("2. Add Document and Verify Profile");
            System.out.println("3. Update Training Progress");
            System.out.println("4. Log Injury");
            System.out.println("5. Add Sponsor");
            System.out.println("6. Create Event and Register Athlete");
            System.out.println("7. Add Achievement");
            System.out.println("8. Generate Leaderboard");
            System.out.println("9. Manage Inventory");
            System.out.println("10. Add Mentorship Log");
            System.out.println("11. Search and Generate Report");
            System.out.println("12. View Athlete Details");
            System.out.println("13. Exit");
            System.out.print("Choose option: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Gender: ");
                        String gender = scanner.nextLine();
                        System.out.print("Sport (Sprinter/Long Jumper/High Jumper/Swimmer/Weightlifter): ");
                        String sport = scanner.nextLine();
                        System.out.print("Contact: ");
                        String contact = scanner.nextLine();
                        Athlete newAthlete = new Athlete(name, age, gender, sport, contact);
                        profileManager.addProfile(newAthlete);
                        System.out.println("Athlete " + name + " added successfully!");
                        break;
                    case 2:
                        System.out.print("Athlete Name: ");
                        String athName = scanner.nextLine();
                        Athlete ath = profileManager.searchProfile(athName);
                        if (ath != null) {
                            System.out.print("Doc Type: ");
                            String docType = scanner.nextLine();
                            System.out.print("Doc Path: ");
                            String docPath = scanner.nextLine();
                            profileManager.addDocument(ath, new Document(docType, docPath));
                            profileManager.verifyProfile(ath, verifier);
                        } else {
                            System.out.println("Error: Athlete '" + athName + "' not found. Please add the athlete first.");
                        }
                        break;
                    case 3:
                        System.out.print("Athlete Name: ");
                        athName = scanner.nextLine();
                        ath = profileManager.searchProfile(athName);
                        if (ath != null) {
                            trainingManager.assignTraining(ath);
                            System.out.print("Value1 (e.g., time/distance): ");
                            double v1 = scanner.nextDouble();
                            System.out.print("Value2 (if applicable, else 0): ");
                            double v2 = scanner.nextDouble();
                            trainingManager.updateProgress(ath, v1, v2);
                            trainingManager.generateReport(ath);
                        } else {
                            System.out.println("Error: Athlete '" + athName + "' not found. Please add the athlete first.");
                        }
                        break;
                    case 4:
                        System.out.print("Athlete Name: ");
                        athName = scanner.nextLine();
                        ath = profileManager.searchProfile(athName);
                        if (ath != null) {
                            System.out.print("Injury Type: ");
                            String type = scanner.nextLine();
                            System.out.print("Recovery Timeline: ");
                            String timeline = scanner.nextLine();
                            injuryManager.logInjury(ath, new Injury(type, new Date(), timeline));
                            System.out.println("Injury logged for " + athName);
                        } else {
                            System.out.println("Error: Athlete '" + athName + "' not found. Please add the athlete first.");
                        }
                        break;
                    case 5:
                        System.out.print("Athlete Name: ");
                        athName = scanner.nextLine();
                        ath = profileManager.searchProfile(athName);
                        if (ath != null) {
                            System.out.print("Sponsor Name: ");
                            String sName = scanner.nextLine();
                            System.out.print("Funds: ");
                            double funds = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            sponsorshipManager.addSponsor(ath, new Sponsor(sName, funds));
                            System.out.println("Sponsor added for " + athName);
                        } else {
                            System.out.println("Error: Athlete '" + athName + "' not found. Please add the athlete first.");
                        }
                        break;
                    case 6:
                        System.out.print("Event Name: ");
                        String eName = scanner.nextLine();
                        Event newEvent = new Event(eName, new Date());
                        eventManager.createEvent(newEvent);
                        System.out.print("Athlete Name to Register: ");
                        athName = scanner.nextLine();
                        ath = profileManager.searchProfile(athName);
                        if (ath != null) {
                            eventManager.registerAthlete(ath, newEvent);
                        } else {
                            System.out.println("Error: Athlete '" + athName + "' not found. Please add the athlete first.");
                        }
                        break;
                    case 7:
                        System.out.print("Athlete Name: ");
                        athName = scanner.nextLine();
                        ath = profileManager.searchProfile(athName);
                        if (ath != null) {
                            System.out.print("Achievement Name: ");
                            String achName = scanner.nextLine();
                            System.out.print("Description: ");
                            String desc = scanner.nextLine();
                            leaderboardManager.addAchievement(ath, new Achievement(achName, desc));
                            System.out.println("Achievement added for " + athName);
                        } else {
                            System.out.println("Error: Athlete '" + athName + "' not found. Please add the athlete first.");
                        }
                        break;
                    case 8:
                        System.out.print("Sport for Leaderboard: ");
                        String lbSport = scanner.nextLine();
                        List<Athlete> leaderboard = leaderboardManager.generateLeaderboard(profileManager.getAthletes(), lbSport);
                        System.out.println("Leaderboard for " + lbSport + ":");
                        if (leaderboard.isEmpty()) {
                            System.out.println("No athletes found for sport: " + lbSport);
                        } else {
                            for (int i = 0; i < leaderboard.size(); i++) {
                                System.out.println((i + 1) + ". " + leaderboard.get(i).getName() + " - " + leaderboard.get(i).getPerformance().getPrimaryMetric());
                            }
                        }
                        break;
                    case 9:
                        System.out.print("Item Name: ");
                        String iName = scanner.nextLine();
                        System.out.print("Initial Stock: ");
                        int stock = scanner.nextInt();
                        inventoryManager.addItem(new Item(iName, stock));
                        System.out.print("Update Stock Change: ");
                        int change = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        inventoryManager.updateStock(iName, change);
                        System.out.println("Inventory updated for " + iName);
                        break;
                    case 10:
                        System.out.print("Athlete Name: ");
                        athName = scanner.nextLine();
                        ath = profileManager.searchProfile(athName);
                        if (ath != null) {
                            System.out.print("Note: ");
                            String note = scanner.nextLine();
                            mentorshipManager.addLog(ath, new Log(note, new Date()));
                            System.out.println("Mentorship log added for " + athName);
                        } else {
                            System.out.println("Error: Athlete '" + athName + "' not found. Please add the athlete first.");
                        }
                        break;
                    case 11:
                        System.out.print("Search by Sport (or leave blank for all): ");
                        String searchSport = scanner.nextLine();
                        List<Athlete> results;
                        if (searchSport.isEmpty()) {
                            results = profileManager.getAthletes();
                        } else {
                            results = searchReportManager.searchBySport(profileManager.getAthletes(), searchSport);
                        }
                        System.out.print("Sort by name? (y/n): ");
                        String sortChoice = scanner.nextLine();
                        if (sortChoice.equalsIgnoreCase("y")) {
                            results = searchReportManager.sortByName(results);
                        }
                        searchReportManager.generateReport(results);
                        break;
                    case 12:
                        System.out.print("Enter Athlete Name to view details: ");
                        String viewName = scanner.nextLine();
                        Athlete viewAth = profileManager.searchProfile(viewName);
                        if (viewAth != null) {
                            System.out.println("\n--- Athlete Details ---");
                            System.out.println("Name: " + viewAth.getName());
                            System.out.println("Age: " + viewAth.getAge());
                            System.out.println("Gender: " + viewAth.getGender());
                            System.out.println("Sport: " + viewAth.getSport());
                            System.out.println("Contact: " + viewAth.getContact());
                            System.out.println("Verification Status: " + (viewAth.isVerified() ? "Verified" : "Not Verified"));

                            // Performance Metrics
                            if (viewAth.getPerformance() != null) {
                                System.out.println("\nPerformance Metrics: " + viewAth.getPerformance().getDetails());
                            }

                            // Documents
                            List<Document> documents = profileManager.getDocuments(viewAth);
                            System.out.println("\nDocuments: " + (documents.isEmpty() ? "None" : documents));

                            // Injuries
                            List<Injury> injuries = injuryManager.getInjuries(viewAth);
                            System.out.println("\nInjury History: " + (injuries.isEmpty() ? "None" : ""));
                            for (Injury injury : injuries) {
                                System.out.println("- " + injury.getType() + " (Recovery: " + injury.getRecoveryTimeline() + ")");
                            }

                            // Sponsors
                            List<Sponsor> sponsors = sponsorshipManager.getSponsors(viewAth);
                            System.out.println("\nSponsors: " + (sponsors.isEmpty() ? "None" : ""));
                            for (Sponsor sponsor : sponsors) {
                                System.out.println("- " + sponsor.getName() + " (Funds: " + sponsor.getAllocatedFunds() + ")");
                            }

                            // Events
                            List<Event> events = eventManager.getEventsForAthlete(viewAth);
                            System.out.println("\nEvents: " + (events.isEmpty() ? "None" : ""));
                            for (Event event : events) {
                                System.out.println("- " + event.getName() + " (Date: " + event.getDate() + ")");
                            }

                            // Achievements
                            List<Achievement> achievements = leaderboardManager.getAchievements(viewAth);
                            System.out.println("\nAchievements: " + (achievements.isEmpty() ? "None" : ""));
                            for (Achievement achievement : achievements) {
                                System.out.println("- " + achievement.getName() + ": " + achievement.getDescription());
                            }

                            // Mentorship Logs
                            List<Log> logs = mentorshipManager.getLogs(viewAth);
                            System.out.println("\nMentorship Logs: " + (logs.isEmpty() ? "None" : ""));
                            for (Log log : logs) {
                                System.out.println("- " + log.getNote() + " (Date: " + log.getDate() + ")");
                            }
                        } else {
                            System.out.println("Error: Athlete '" + viewName + "' not found. Please add the athlete first.");
                        }
                        System.out.println("\nPress Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 13:
                        running = false;
                        System.out.println("Exiting Athlete Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Error: Invalid option. Please choose a number between 1 and 13.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}