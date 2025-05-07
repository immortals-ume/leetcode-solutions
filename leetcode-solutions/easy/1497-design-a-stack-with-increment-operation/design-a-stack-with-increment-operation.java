class CustomStack {

 int[] arr;
    int top;
    public CustomStack(int maxSize) {
        arr=new int[maxSize];
        top=-1;
    }
    
    public void push(int x) {
        if(top<arr.length-1) arr[++top]=x;
    }
    
    public int pop() {
        if(top>-1) return arr[top--];
        return -1;
    }
    
    public void increment(int k, int val) {
        int min=Math.min(k,arr.length);
        for(int i=0;i<min;i++){
            arr[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */