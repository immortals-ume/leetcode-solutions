class Solution {
    public String removeKdigits(String num, int k) {
        // Edge case: if k is equal to the length of num, return "0"
        if (k == num.length()) {
            return "0";
        }
        
        // Use a stack to keep track of digits
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each digit in num
        for (char digit : num.toCharArray()) {
            // Remove digits from the stack while k > 0 and top of stack is greater than the current digit
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            // Push the current digit onto the stack
            stack.push(digit);
        }
        
        // Remove remaining digits from the end if k > 0
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Construct the result string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        // Remove leading zeroes
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
}