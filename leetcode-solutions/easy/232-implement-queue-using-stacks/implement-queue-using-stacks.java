class MyQueue {
private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // Push element x to the back of queue
    public void push(int x) {
        stackIn.push(x);  // Always O(1)
    }

    // Removes the element from the front of queue and returns that element
    public int pop() {
        // Transfer elements only when stackOut is empty
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop()); // O(n) transfer, but only done once
            }
        }
        return stackOut.pop();  // O(1)
    }

    // Get the front element
    public int peek() {
        // Transfer elements only when stackOut is empty
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());  // O(n) transfer, but only done once
            }
        }
        return stackOut.peek();  // O(1)
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
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