class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Step 1: Sort the array of people based on their weights
        Arrays.sort(people);

        // Define two pointers, one at the beginning and one at the end
        int left = 0;   // Pointer to the lightest person
        int right = people.length - 1; // Pointer to the heaviest person

        int boats = 0;  // Variable to count the number of boats required

        // Step 2 and Step 3: Use the two-pointer approach to find optimal pairings
        while (left <= right) {
            // If the lightest and heaviest person together are within the limit
            if (people[left] + people[right] <= limit) {
                left++; // Move to the next lightest person
            }
            // The heaviest person always gets a boat
            right--; // Move to the next heaviest person
            boats++; // Increment the boat count
        }

        // Step 4: Return the total number of boats required
        return boats;
    }
}