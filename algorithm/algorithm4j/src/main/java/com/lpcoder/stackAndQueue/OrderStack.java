package com.lpcoder.stackAndQueue;

import java.util.Stack;

/**
 * @author liurenpeng
 * @date Created in 19-2-12
 */
public class OrderStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(1);
        System.out.println(stack);
        //orderStack(stack);
        sortStackByStack(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
    }

    public static void orderStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int max = getAndRemoveMaxElem(stack);
            tempStack.push(max);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    private static int getAndRemoveMaxElem(Stack<Integer> stack) {
        int elem = stack.pop();
        if (stack.isEmpty()) {
            return elem;
        }
        int max = getAndRemoveMaxElem(stack);
        if (max >= elem) {
            stack.push(elem);
            return max;
        } else {
            stack.push(max);
            return elem;
        }
    }

    /**
     * 另一种解法
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> helper = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (helper.isEmpty() || cur <= helper.peek()) {
                helper.push(cur);
                continue;
            }
            while (!helper.isEmpty() && helper.peek() < cur) {
                stack.push(helper.pop());
            }
            helper.push(cur);
        }
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
    }
}
