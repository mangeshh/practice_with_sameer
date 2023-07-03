package stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/description/
 */
public class MinStack {

    final Stack<Integer> stack;
    final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }

    }

    public void pop() {
        if(!stack.isEmpty() && !minStack.isEmpty() && stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return 0;

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
