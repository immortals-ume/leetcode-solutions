class MyHashSet {
    private boolean[] data;

    // Constructor
    public MyHashSet() {
        data = new boolean[1000001]; // Size of array is 10^6 + 1
    }

    // Add key to the hash set
    public void add(int key) {
        data[key] = true;
    }

    // Check if the key is in the hash set
    public boolean contains(int key) {
        return data[key];
    }

    // Remove the key from the hash set
    public void remove(int key) {
        data[key] = false;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */