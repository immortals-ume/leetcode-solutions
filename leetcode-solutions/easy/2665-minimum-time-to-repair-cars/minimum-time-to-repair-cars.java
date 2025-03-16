class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long) ranks[0] * cars * cars;
        
        Arrays.sort(ranks); // Sorting helps optimize search
        
        while (left < right) {
            long mid = (left + right) / 2;
            if (canRepairInTime(ranks, cars, mid)) {
                right = mid; // Try a smaller time
            } else {
                left = mid + 1; // Increase the time
            }
        }
        return left;
    }
    
    private static boolean canRepairInTime(int[] ranks, int cars, long time) {
        long totalCars = 0;
        for (int rank : ranks) {
            totalCars += (long) Math.sqrt(time / rank); // Max cars a mechanic can repair in given time
            if (totalCars >= cars) return true; // Early exit if already enough cars are repaired
        }
        return false;
    }

}