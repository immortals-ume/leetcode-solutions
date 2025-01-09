class MyHashSet {
    private static final int SIZE = 1000; // Size of the array
    private List<Integer>[] data; // Array of lists (buckets)

    // Constructor
    public MyHashSet() {
        data = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            data[i] = new ArrayList<>();
        }
    }
    
    // Hash function to get the index
    private int hash(int key) {
        return key % SIZE;
    }

    // Add key to the hash set
    public void add(int key) {
        int index = hash(key);
        List<Integer> bucket = data[index];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    // Check if the key is in the hash set
    public boolean contains(int key) {
        int index = hash(key);
        List<Integer> bucket = data[index];
        return bucket.contains(key);
    }

    // Remove the key from the hash set
    public void remove(int key) {
        int index = hash(key);
        List<Integer> bucket = data[index];
        bucket.remove(Integer.valueOf(key));
    }
}
