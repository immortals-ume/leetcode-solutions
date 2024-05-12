class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
         int n = quality.length;
        double[][] workers = new double[n][2];
        
        // Calculate the ratio of wage to quality for each worker
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        
        // Sort the workers based on their ratios
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        
        double minCost = Double.POSITIVE_INFINITY;
        double totalQuality = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (double[] worker : workers) {
            double ratio = worker[0];
            double qual = worker[1];
            
            totalQuality += qual;
            maxHeap.offer(qual);
            
            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, totalQuality * ratio);
            }
        }
        
        return minCost;
    }
}