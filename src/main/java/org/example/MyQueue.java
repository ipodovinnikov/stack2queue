package org.example;

import java.util.Stack;

@SuppressWarnings("all")
class MyQueue {

    private Stack<Integer> stack1 = new Stack();
    private Stack<Integer> stack2 = new Stack();

    private boolean returnsFirst;
    private boolean pushToFirst;


    public void push(int i) {
        stack1.push(i);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return 0;
        }
        freeFirst();
        int first = stack1.pop();
        tossBack();
        return first;
    }

    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return 0;
        }
        freeFirst();
        int first = stack1.peek();
        tossBack();
        return first;
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void freeFirst() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
    }

    public void tossBack() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
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
