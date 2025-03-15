import java.util.*;

public class URLShortener {
    private static final String BASE_URL = "short.ly/";
    private Map<String, String> shortToLongMap = new HashMap<>();
    private Map<String, String> longToShortMap = new HashMap<>();
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;
    private Random random = new Random();

    // Method to shorten a URL
    public String shortenURL(String longURL) {
        if (longToShortMap.containsKey(longURL)) {
            return BASE_URL + longToShortMap.get(longURL);  // Return existing short URL
        }

        String shortKey;
        do {
            shortKey = generateShortKey();
        } while (shortToLongMap.containsKey(shortKey)); // Ensure unique keys

        shortToLongMap.put(shortKey, longURL);
        longToShortMap.put(longURL, shortKey);

        return BASE_URL + shortKey;
    }

    // Method to expand a short URL
    public String expandURL(String shortURL) {
        String key = shortURL.replace(BASE_URL, "");
        return shortToLongMap.getOrDefault(key, "Invalid URL: Not found!");
    }

    // Generate a random 6-character short key
    private String generateShortKey() {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            key.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return key.toString();
    }
}
