package com.lpcoder.tree;

import lombok.Data;

/**
 * @author liurenpeng
 * @date Created in 19-5-6
 */
@Data
public class BiTreeIntEle {

    public final BiTNode<Integer> root;

    public BiTreeIntEle(BiTNode<Integer> root) {
        this.root = root;
    }

    public static final BiTreeIntEle S_INSTANCE = getStandardInstance();

    private static BiTreeIntEle getStandardInstance() {
        BiTNode<Integer> node62 = new BiTNode<>(62);
        BiTNode<Integer> node58 = new BiTNode<>(58);
        BiTNode<Integer> node88 = new BiTNode<>(88);
        BiTNode<Integer> node47 = new BiTNode<>(47);
        BiTNode<Integer> node73 = new BiTNode<>(73);
        BiTNode<Integer> node99 = new BiTNode<>(99);
        BiTNode<Integer> node35 = new BiTNode<>(35);
        BiTNode<Integer> node51 = new BiTNode<>(51);
        BiTNode<Integer> node93 = new BiTNode<>(93);
        BiTNode<Integer> node37 = new BiTNode<>(37);

        node62.left = node58;
        node62.right = node88;

        node58.left = node47;

        node47.left = node35;
        node47.right = node51;

        node35.right = node37;

        node88.left = node73;
        node88.right = node99;

        node99.left = node93;

        return new BiTreeIntEle(node62);
    }
}
