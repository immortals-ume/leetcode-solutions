class Solution {
    public int secondsToRemoveOccurrences(String s) {
         int zero = 0; 
        int ans = 0;  

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
            } else if (zero > 0) {
                ans = Math.max(ans + 1, zero);
            }
        }

        return ans;
    }
}