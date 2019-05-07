package com.lpcoder.guide.stackAndQueue;

import java.util.Stack;

/**
 * 由两个栈组成的队列
 * 要求：用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 * 要点：栈（先进后出），队列（先进先出）。**负负得正**。
 *  1. 栈1数据导入栈2时必须是全量导入
 *  2. 栈2从栈1导数据时必须自身为空
 *
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
