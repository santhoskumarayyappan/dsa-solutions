//22-04-2022
//https://leetcode.com/problems/min-stack


class MinStack {

    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        valueStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        valueStack.push(val);
        if (minStack.isEmpty() || getMin() >= val ) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = valueStack.pop();
        if (val == getMin()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return valueStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
