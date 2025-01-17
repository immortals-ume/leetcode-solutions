class Solution {
    public boolean doesValidArrayExist(int[] derived) {
         int n = derived.length;
        
       
        
        // Check both possibilities for original[0]: 0 and 1
        return isValid(0,n,derived) || isValid(1,n,derived);
    }
     // Helper function to validate the circular XOR condition
        boolean isValid(int start,int n,int[] derived) {
            int[] original = new int[n];
            original[0] = start;
            
            // Generate the rest of the original array
            for (int i = 1; i < n; i++) {
                original[i] = original[i - 1] ^ derived[i - 1];
            }
            
            // Check the circular condition
            return (original[n - 1] ^ original[0]) == derived[n - 1];
        }
}