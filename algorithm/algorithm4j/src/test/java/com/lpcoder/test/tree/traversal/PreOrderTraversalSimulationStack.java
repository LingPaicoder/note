package com.lpcoder.test.tree.traversal;

import com.lpcoder.test.tree.BiTNode;
import com.lpcoder.test.tree.BiTree;

import java.util.Stack;

/**
 * @author liurenpeng
 * @date Created in 19-5-7
 */
public class PreOrderTraversalSimulationStack {

    public static void main(String[] args) {
        solution(BiTree.S_INSTANCE.root);
        System.out.println("---");
        test(BiTree.S_INSTANCE.root);
    }

    /*void PreorderNonRecursive(Bitree root){
        stack stk;
        stk.push(root);
        while(!stk.empty()){
            p = stk.top();
            visit(p);
            stk.pop();
            if(p.rchild) stk.push(stk.rchild);
            if(p.lchild) stk.push(stk.lchild);
        }
    }*/

    private static void test(BiTNode root) {
        Stack<BiTNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BiTNode node = stack.peek();
            System.out.print(node.ele);
            stack.pop();
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
    }

    private static void solution(BiTNode root) {
        if (null == root) {
            return;
        }
        Stack<Frame> stack = new Stack<>();
        stack.push(new Frame(root, FrameStatus.UN_HANDLE));
        while (!stack.isEmpty()) {
            Frame frame = stack.peek();
            switch (frame.status) {
                case UN_HANDLE:
                    System.out.print(frame.node.ele);
                    frame.status = FrameStatus.HANDLED;
                    break;
                case HANDLED:
                    if (null != frame.node.left) {
                        stack.push(new Frame(frame.node.left, FrameStatus.UN_HANDLE));
                    }
                    frame.status = FrameStatus.LEFT_HANDLED;
                    break;
                case LEFT_HANDLED:
                    if (null != frame.node.right) {
                        stack.push(new Frame(frame.node.right, FrameStatus.UN_HANDLE));
                    }
                    frame.status = FrameStatus.RIGHT_HANDLED;
                    break;
                case RIGHT_HANDLED:
                    stack.pop();
                    break;
            }
        }
    }

    /**
     * 栈帧
     */
    private static class Frame {
        BiTNode node;
        FrameStatus status;

        Frame(BiTNode node, FrameStatus status) {
            this.node = node;
            this.status = status;
        }
    }

    /**
     * 栈帧状态 辅助判断执行路径
     */
    private enum FrameStatus {
        UN_HANDLE, HANDLED, LEFT_HANDLED, RIGHT_HANDLED
    }


}
