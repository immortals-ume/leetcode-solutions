class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
 int n = colors.length;
        int count = 0;
        int validWindows = 0;
        
        // Initial check for the first window of size k
        boolean isValid = true;
        for (int i = 0; i < k - 1; i++) {
            if (colors[i] == colors[i + 1]) {
                isValid = false;
                break;
            }
        }
        if (isValid) validWindows++;

        // Sliding window check for the rest
        for (int i = 1; i < n; i++) {
            // Remove the previous first element, add the new one
            int prevIndex = (i - 1) % n;
            int newIndex = (i + k - 1) % n;
            
            // Check the transition at the front
            if (colors[prevIndex] == colors[(prevIndex + 1) % n]) {
                isValid = false;
            }
            
            // Check the transition at the new back
            if (colors[(newIndex - 1 + n) % n] == colors[newIndex]) {
                isValid = false;
            }
            
            // If the window was valid before and this change didn't break it
            if (isValid) validWindows++;
            else {
                // Recalculate the whole window if needed
                isValid = true;
                for (int j = i; j < i + k - 1; j++) {
                    if (colors[j % n] == colors[(j + 1) % n]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) validWindows++;
            }
        }

        return validWindows;
    }
}