class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == ')') {
                // Process the expression between the most recent '(' and ')'
                Set<Character> seen = new HashSet<>();
                
                // Pop elements until '(' is encountered
                while (stack.peek() != '(') {
                    seen.add(stack.pop());
                }
                
                // Remove '('
                stack.pop();
                
                // The operator before '(' determines how to process the set
                char operator = stack.pop();
                
                if (operator == '&') {
                    // AND: all elements must be 't' for result to be true
                    stack.push(seen.contains('f') ? 'f' : 't');
                } else if (operator == '|') {
                    // OR: at least one element must be 't' for result to be true
                    stack.push(seen.contains('t') ? 't' : 'f');
                } else if (operator == '!') {
                    // NOT: the set should only contain one element, either 't' or 'f'
                    stack.push(seen.contains('t') ? 'f' : 't');
                }
            } else if (c != ',') {
                // Push other valid characters into the stack
                stack.push(c);
            }
        }

        // The final result will be the only element left in the stack
        return stack.pop() == 't';
    }
}