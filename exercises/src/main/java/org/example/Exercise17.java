package org.example;

import java.util.Stack;

public class Exercise17 {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    Exercise17() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    void push(int val) {
        mainStack.push(val);
        if (minStack.empty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    void pop() {
        Integer val = mainStack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    int top() {
        return mainStack.peek();
    }

    int getMin() {
        return minStack.peek();
    }
}
