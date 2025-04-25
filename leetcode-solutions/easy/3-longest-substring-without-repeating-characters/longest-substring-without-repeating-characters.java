class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
        return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    int start = 0, max = -1;
    for (int i = 0; i < s.length(); i++) {
        if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
            start = map.get(s.charAt(i)) + 1;
        }
        map.put(s.charAt(i), i);
        max = Math.max(max,  i - start + 1);
    }

    return max;
    }

}