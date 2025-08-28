import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProfileManager manager = new ProfileManager();
        Verifier verifier = new Verifier("Admin");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAthlete Digital Profile & Verification System");
            System.out.println("1. Add Athlete");
            System.out.println("2. Add Document");
            System.out.println("3. Verify Profile");
            System.out.println("4. Search Profiles");
            System.out.println("5. Sort by Age");
            System.out.println("6. Filter by Verification Status");
            System.out.println("7. Generate Report");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter gender: ");
                        String gender = scanner.nextLine();
                        System.out.print("Enter sport: ");
                        String sport = scanner.nextLine();
                        System.out.print("Enter contact: ");
                        String contact = scanner.nextLine();
                        Athlete athlete = new Athlete(name, age, gender, sport, contact);
                        manager.addProfile(athlete);
                        System.out.println("Athlete added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter athlete name: ");
                        String athleteName = scanner.nextLine();
                        Athlete targetAthlete = manager.searchProfile(athleteName).stream()
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("Athlete not found"));
                        System.out.print("Enter document type (ID/Certificate): ");
                        String docType = scanner.nextLine();
                        System.out.print("Enter document path: ");
                        String docPath = scanner.nextLine();
                        Document doc = new Document(docType, docPath);
                        manager.addDocument(targetAthlete, doc);
                        System.out.println("Document added successfully!");
                        break;

                    case 3:
                        System.out.print("Enter athlete name: ");
                        athleteName = scanner.nextLine();
                        targetAthlete = manager.searchProfile(athleteName).stream()
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException("Athlete not found"));
                        manager.verifyProfile(targetAthlete, verifier);
                        System.out.println("Profile verification status: " +
        (manager.filterByStatus(Verifier.VerificationStatus.VERIFIED).contains(targetAthlete)
                ? "Verified" : "Pending/Rejected"));
                        break;
                    case 4:
                        System.out.print("Enter search query (name or sport): ");
                        String query = scanner.nextLine();
                        List<Athlete> results = manager.searchProfile(query);
                        System.out.println("Search Results:");
                        results.forEach(System.out::println);
                        break;

                    case 5:
                        System.out.println("Sorted by Age:");
                        manager.sortByAge().forEach(System.out::println);
                        break;

                    case 6:
                        System.out.print("Enter status (VERIFIED/PENDING/REJECTED): ");
                        String statusStr = scanner.nextLine().toUpperCase();
                        Verifier.VerificationStatus status = Verifier.VerificationStatus.valueOf(statusStr);
                        System.out.println("Filtered by " + status + ":");
                        manager.filterByStatus(status).forEach(System.out::println);
                        break;

                    case 7:
                        System.out.println(manager.generateReport());
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}