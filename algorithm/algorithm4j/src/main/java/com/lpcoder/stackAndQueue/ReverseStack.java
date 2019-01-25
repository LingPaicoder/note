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
        reverseStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static void reverseStack(Stack<Integer> stack) {
        /*if (stack.isEmpty()) {
            return;
        }
        Integer data = stack.pop();
        reverseStack(stack);
        stack.push(data);*/
    }

}
