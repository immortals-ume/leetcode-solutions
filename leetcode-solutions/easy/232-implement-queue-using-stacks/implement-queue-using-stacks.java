class MyQueue {

        private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Push element x to the back of the queue
    public void push(int x) {
        stack1.push(x);
    }
    
    // Removes the element from the front of the queue and returns it
    public int pop() {
        // Move elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Pop the front element from stack2
        return stack2.pop();
    }
    
    // Get the front element
    public int peek() {
        // Move elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // Peek the front element from stack2
        return stack2.peek();
    }
    
    // Return whether the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */