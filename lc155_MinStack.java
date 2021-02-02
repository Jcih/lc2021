class MinStack {

    /** initialize your data structure here. */
    /*
    1. example
    2. data structure
    3. logic
    4. result
    5. analysis
    ==============
    -2, 0, -3
    
    -2 -3
    
    
    **/
    
    Stack<Integer> reg;
    Stack<Integer> min;
    
    
    public MinStack() {
        reg = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        reg.push(x);
        if (!min.isEmpty()) {
            if (x <= min.peek()) {
                min.push(x);
            }
        } else {
            min.push(x);
        }
        
    }
    
    public void pop() {
        if (!reg.isEmpty()) {
            int num = reg.pop();
            if (num == min.peek()) {
                min.pop();
            }
        }
    }
    
    public int top() {
        return reg.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */