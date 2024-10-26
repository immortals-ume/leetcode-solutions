class StockSpanner {
       // Stack to store pairs of (price, span)
    private Stack<int[]> stack;

    // Constructor initializes the stack
    public StockSpanner() {
        stack = new Stack<>();
    }

    // The next function calculates the span for the given price
    public int next(int price) {
        int span = 1; // Start with a span of 1 for the current day itself

        // While the stack is not empty and the top element's price is <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Accumulate the span of previous days with lesser or equal price
            span += stack.pop()[1];
        }

        // Push the current price and its span to the stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */