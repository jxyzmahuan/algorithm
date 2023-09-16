package org.pegasus.algorithm.class03;

import java.util.Stack;

//最小栈
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minStack;

    public MinStack() {
        data = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int num) {
        if (minStack.isEmpty() || num <  this.getMin()) {
            minStack.push(num);
        } else {
            minStack.push(minStack.peek());
        }
        data.push(num);
    }

    public int pop() {
        if(data.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        minStack.pop();
        return data.pop();
    }

    public int getMin() {
        if(minStack.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return minStack.peek();
    }
}
