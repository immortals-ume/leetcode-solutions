import java.util.stream.Collectors;
class Solution {
    public boolean divideArray(int[] nums) {
        // Count occurrences using Streams
        Map<Integer, Long> freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        // Check if all frequencies are even
        return freqMap.values().stream().allMatch(count -> count % 2 == 0);
    }
}