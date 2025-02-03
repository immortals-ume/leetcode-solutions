class Solution {
    public String findValidPair(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count the frequency of each digit
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Traverse the string and find the first valid adjacent pair
        for (int i = 0; i < s.length() - 1; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);

            if (first != second && freqMap.get(first) == Character.getNumericValue(first) 
                && freqMap.get(second) == Character.getNumericValue(second)) {
                return "" + first + second;
            }
        }

        return "";
    }
}