class Solution {
    public String smallestNumber(String pattern) {
          StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through pattern and push numbers accordingly
        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1); // Push 1-based index
            
            // If 'I' is found or at the end, pop all stack values to result
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString();
    }
}