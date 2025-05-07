public class Codec {

 // Map to store the mapping between tiny URL and original URL
    private Map<String, String> map;
    // Base URL for tiny URL
    private static final String BASE_URL = "http://tinyurl.com/";

    // Counter for generating unique short URL
    private int counter;

    // Constructor to initialize the system
    public Codec() {
        map = new HashMap<>();
        counter = 0;
    }

    // Encode method to return a tiny URL for the given long URL
    public String encode(String longUrl) {
        counter++;
        String tinyUrl = BASE_URL + Integer.toString(counter);
        map.put(tinyUrl, longUrl); // Map tiny URL to long URL
        return tinyUrl;
    }

    // Decode method to return the original long URL from a given short URL
    public String decode(String shortUrl) {
        return map.get(shortUrl); // Retrieve the original long URL from the map
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));