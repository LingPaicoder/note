package com.lpcoder.stackAndQueue;

import java.util.Stack;

/**
 * @author liurenpeng
 * @date Created in 19-1-25
 */
public class QueueBy2Stack {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static class MyQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void add(int data) {
            stack1.push(data);
        }

        public int poll() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            if (!stack2.isEmpty()) {
                return stack2.peek();
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

}
