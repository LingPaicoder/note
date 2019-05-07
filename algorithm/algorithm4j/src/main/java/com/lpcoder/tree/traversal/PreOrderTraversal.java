package com.lpcoder.tree.traversal;

import com.lpcoder.tree.BiTNode;
import com.lpcoder.tree.BiTreeStrEle;

/**
 * 前序遍历 根左右
 *
 * @author liurenpeng
 * @date Created in 19-5-6
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        preOrderTraversal(BiTreeStrEle.S_INSTANCE.root);
    }

    private static void preOrderTraversal(BiTNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.ele);
        if (root.left != null) {
            preOrderTraversal(root.left);
        }
        if (root.right != null) {
            preOrderTraversal(root.right);
        }
    }

}
