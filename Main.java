import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Link Shortener ---");
            System.out.println("1. Shorten a URL");
            System.out.println("2. Expand a Short URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL: ");
                    String longURL = scanner.nextLine();
                    String shortURL = urlShortener.shortenURL(longURL);
                    System.out.println("Shortened URL: " + shortURL);
                    break;
                case 2:
                    System.out.print("Enter the short URL: ");
                    String shortInput = scanner.nextLine();
                    System.out.println("Original URL: " + urlShortener.expandURL(shortInput));
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
