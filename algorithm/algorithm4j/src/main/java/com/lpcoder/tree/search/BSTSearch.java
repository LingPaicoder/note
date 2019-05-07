package com.lpcoder.tree.search;

import com.lpcoder.tree.BiTNode;
import com.lpcoder.tree.BiTreeOfIntEle;

/**
 * 二叉排序树查找
 *
 * @author liurenpeng
 * @date Created in 19-5-7
 */
public class BSTSearch {

    public static void main(String[] args) {
        System.out.println(search(BiTreeOfIntEle.S_INSTANCE.root, 73));
    }

    @SuppressWarnings("unchecked")
    private static BiTNode<Integer> search(BiTNode<Integer> root, int key) {
        if (null == root) {
            return null;
        }
        if (key == root.ele) {
            return root;
        } else if (key < root.ele) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

}
