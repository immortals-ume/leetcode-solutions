class CustomStack {

private int maxSize;  // Maximum size of the stack
    private int[] stack;  // Stack to hold the elements
    private int[] increment;  // Array to track increments for each element
    
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];  // Stack initialization
        this.increment = new int[maxSize];  // Increment array initialization
    }
    
    // Pushes the element to the stack if it's not full
    public void push(int x) {
        if (getSize() < maxSize) {
            stack[getSize()] = x;
        }
    }
    
    // Pops and returns the top element from the stack or -1 if the stack is empty
    public int pop() {
        if (getSize() == 0) {
            return -1;  // If the stack is empty, return -1
        }
        
        int topIndex = getSize() - 1;
        int value = stack[topIndex] + increment[topIndex];  // Add the increment value
        if (topIndex > 0) {
            increment[topIndex - 1] += increment[topIndex];  // Propagate the increment to the next element
        }
        increment[topIndex] = 0;  // Reset the increment for the current element
        stack[topIndex] = 0;  // Clear the top element
        return value;
    }
    
    // Increments the bottom k elements of the stack by val
    public void increment(int k, int val) {
        int limit = Math.min(k, getSize());  // Limit the increment to the current stack size
        if (limit > 0) {
            increment[limit - 1] += val;  // Apply the increment to the (k-1)th index
        }
    }
    
    // Helper method to get the current size of the stack
    private int getSize() {
        int size = 0;
        while (size < maxSize && stack[size] != 0) {
            size++;
        }
        return size;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */