class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack to hold indices of temperatures

        for (int i = 0; i < n; i++) {
            // Process all indices that have a lower temperature than the current temperature
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return answer;
    }
}