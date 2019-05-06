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
    }

    private static void solution(BiTNode root) {
        if (null == root) {
            return;
        }
        STACK.push(new Frame(root, FrameStatus.UN_HANDLE));
        while (!STACK.isEmpty()) {
            Frame frame = STACK.peek();
            switch (frame.status) {
                case UN_HANDLE:
                    System.out.print(frame.node.ele);
                    frame.status = FrameStatus.HANDLED;
                    break;
                case HANDLED:
                    if (null != frame.node.left) {
                        STACK.push(new Frame(frame.node.left, FrameStatus.UN_HANDLE));
                    }
                    frame.status = FrameStatus.LEFT_HANDLED;
                    break;
                case LEFT_HANDLED:
                    if (null != frame.node.right) {
                        STACK.push(new Frame(frame.node.right, FrameStatus.UN_HANDLE));
                    }
                    frame.status = FrameStatus.RIGHT_HANDLED;
                    break;
                case RIGHT_HANDLED:
                    STACK.pop();
                    break;
            }
        }
    }

    private static final Stack<Frame> STACK = new Stack<>();

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
