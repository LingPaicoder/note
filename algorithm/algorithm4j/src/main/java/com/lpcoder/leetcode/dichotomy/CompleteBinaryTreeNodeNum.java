package com.lpcoder.leetcode.dichotomy;

import java.util.LinkedList;
import java.util.function.Function;

/**
 * 完全二叉树节点数量
 *
 * @author liurenpeng
 * @date Created in 19-5-28
 */
public class CompleteBinaryTreeNodeNum {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        System.out.println(countNodes(node1));
    }

    public static int countNodes(TreeNode root) {
        int leftH = getLeftHeight(root);
        int rightH = getRightHeight(root);

        // 满二叉树
        if (leftH == rightH) {
            return (1 << leftH) - 1;
        }

        // 最底层最大节点数
        int lowestMaxNodeNum = 1 << (leftH - 1);
        // 非底层节点数
        int notLowestNodeNum = lowestMaxNodeNum - 1;
        // 最底层节点数
        int lowestNodeNum = binarySearchBorder(root, leftH - 1, lowestMaxNodeNum);
        return notLowestNodeNum + lowestNodeNum;
    }

    /**
     * 二分法查找边界
     */
    private static int binarySearchBorder(TreeNode root, int pathH, int right) {
        int left = 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            boolean haveNode = haveNode(root, pathH, biForm(pathH, mid));
            if (!haveNode) {
                if (haveNode(root, pathH, biForm(pathH, mid - 1))) {
                    return mid - 1;
                }
            } else {
                if (!haveNode(root, pathH, biForm(pathH, mid + 1))) {
                    return mid;
                }
            }
            if (haveNode) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static char[] biForm(int arrLen, int num) {
        char[] arr = Integer.toBinaryString(num - 1).toCharArray();
        if (arrLen == arr.length) {
            return arr;
        }
        char[] rst = new char[arrLen];
        int diff = arrLen - arr.length;
        // 前补0
        for (int i = 0; i < diff; i++) {
            rst[i] = '0';
        }
        System.arraycopy(arr, 0, rst, diff, arr.length);
        return rst;
    }

    private static boolean haveNode(TreeNode root, int pathH, char[] biCharArr) {
        TreeNode target = root;
        for (char c : biCharArr) {
            target = c == '0' ? target.left : target.right;
        }
        return null != target;
    }

    private static int getLeftHeight(TreeNode root) {
        return getHeightHelper(root, node -> node.left);
    }

    private static int getRightHeight(TreeNode root) {
        return getHeightHelper(root, node -> node.right);
    }

    private static int getHeightHelper(TreeNode root, Function<TreeNode, TreeNode> function) {
        int height = 0;
        while (root != null) {
            height++;
            root = function.apply(root);
        }
        return height;
    }

    public static class TreeNode {
        final int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
