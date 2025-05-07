public class Codec {

// Map to store the mapping between tiny URL and original URL
    private Map<String, String> map;
    // Base URL for tiny URL
    private static final String BASE_URL = "http://tinyurl.com/";

    // A set of characters to use for generating the short URL
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // Length of the random string for the tiny URL
    private static final int SHORT_URL_LENGTH = 6;
    // Random object for generating the random string
    private Random random;

    // Constructor to initialize the system
    public Codec() {
        map = new HashMap<>();
        random = new Random();
    }

    // Helper function to generate a random string of fixed length
    private String generateRandomString() {
        StringBuilder sb = new StringBuilder(SHORT_URL_LENGTH);
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    // Encode method to return a tiny URL for the given long URL
    public String encode(String longUrl) {
        // Generate a random short URL
        String shortUrl = generateRandomString();
        // Ensure the generated URL is unique
        while (map.containsKey(BASE_URL + shortUrl)) {
            shortUrl = generateRandomString();
        }
        // Store the mapping between short URL and long URL
        map.put(BASE_URL + shortUrl, longUrl);
        return BASE_URL + shortUrl;
    }

    // Decode method to return the original long URL from a given short URL
    public String decode(String shortUrl) {
        return map.get(shortUrl); // Retrieve the original long URL from the map
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));