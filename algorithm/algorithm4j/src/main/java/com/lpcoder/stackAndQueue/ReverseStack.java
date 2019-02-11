package com.lpcoder.stackAndQueue;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈 要求：只能有递归函数来实现，不能用其他数据结构
 *
 * @author liurenpeng
 * @date Created in 19-1-25
 */
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int last = getAndRemoveLastElement(stack);
        stack.push(result);
        return last;
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

}
