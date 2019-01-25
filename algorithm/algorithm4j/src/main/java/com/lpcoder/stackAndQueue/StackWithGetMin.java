package com.lpcoder.stackAndQueue;

import java.util.Stack;

/**
 * @author liurenpeng
 * @date Created in 19-1-25
 */
public class StackWithGetMin {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(2);
        myStack.push(5);
        myStack.push(1);
        myStack.push(4);
        System.out.println(myStack.getMin());

        MyStack2 myStack2 = new MyStack2();
        myStack2.push(3);
        myStack2.push(2);
        myStack2.push(5);
        myStack2.push(1);
        myStack2.push(4);
        System.out.println(myStack2.getMin());
    }

    public static class MyStack2 {
        private Stack<Integer> stackData = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int data) {
            stackData.push(data);
            if (stackMin.isEmpty() || getMin() >= data) {
                stackMin.push(data);
            }
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            int data = stackData.pop();
            if (data == getMin()) {
                stackMin.pop();
            }
            return data;
        }


        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return stackMin.peek();
        }
    }

    public static class MyStack {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int data) {
            stackData.push(data);
            if (stackMin.isEmpty()) {
                stackMin.push(data);
                return;
            }
            int currMin = getMin();
            stackMin.push(currMin <= data ? currMin : data);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return stackMin.peek();
        }
    }
}
