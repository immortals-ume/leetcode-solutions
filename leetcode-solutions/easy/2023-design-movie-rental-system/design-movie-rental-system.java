import java.util.*;

class MovieRentingSystem {
   static class Entry {
        int shop, movie, price;
        Entry(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        // Used in TreeSets for ordering
        public boolean equals(Object o) {
            if (!(o instanceof Entry)) return false;
            Entry e = (Entry) o;
            return shop == e.shop && movie == e.movie;
        }

        public int hashCode() {
            return Objects.hash(shop, movie);
        }
    }

    // Sort for available movies (by movie): price -> shop
    Map<Integer, TreeSet<Entry>> available = new HashMap<>();

    // Rented movies: globally sorted
    TreeSet<Entry> rented = new TreeSet<>(
        (a, b) -> a.price != b.price ? a.price - b.price :
                 a.shop != b.shop ? a.shop - b.shop :
                 a.movie - b.movie
    );

    // For quick price lookup: (shop, movie) -> price
    Map<String, Integer> priceMap = new HashMap<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Entry entry = new Entry(shop, movie, price);

            available.putIfAbsent(movie, new TreeSet<>(
                (a, b) -> a.price != b.price ? a.price - b.price :
                         a.shop - b.shop
            ));
            available.get(movie).add(entry);

            priceMap.put(key(shop, movie), price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;

        TreeSet<Entry> set = available.get(movie);
        int count = 0;
        for (Entry e : set) {
            result.add(e.shop);
            if (++count == 5) break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        Entry entry = new Entry(shop, movie, price);

        available.get(movie).remove(entry); // Remove from available
        rented.add(entry);                  // Add to rented
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(key(shop, movie));
        Entry entry = new Entry(shop, movie, price);

        rented.remove(entry);              // Remove from rented
        available.get(movie).add(entry);   // Add back to available
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (Entry e : rented) {
            result.add(Arrays.asList(e.shop, e.movie));
            if (++count == 5) break;
        }
        return result;
    }

    private String key(int shop, int movie) {
        return shop + ":" + movie;
    }
}
/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */