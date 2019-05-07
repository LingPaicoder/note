package com.lpcoder.tree;

import lombok.Data;

/**
 * @author liurenpeng
 * @date Created in 19-5-6
 */
@Data
public class BiTreeStrEle {

    public final BiTNode<String> root;

    public BiTreeStrEle(BiTNode<String> root) {
        this.root = root;
    }

    public static final BiTreeStrEle S_INSTANCE = getStandardInstance();

    private static BiTreeStrEle getStandardInstance() {
        BiTNode<String> root = new BiTNode<>("A");
        BiTNode<String> bNode = new BiTNode<>("B");
        BiTNode<String> cNode = new BiTNode<>("C");
        BiTNode<String> dNode = new BiTNode<>("D");
        BiTNode<String> eNode = new BiTNode<>("E");
        BiTNode<String> fNode = new BiTNode<>("F");
        BiTNode<String> gNode = new BiTNode<>("G");
        BiTNode<String> hNode = new BiTNode<>("H");
        BiTNode<String> iNode = new BiTNode<>("I");

        root.left = bNode;
        root.right = cNode;

        bNode.left = dNode;
        dNode.left = gNode;
        dNode.right = hNode;

        cNode.left = eNode;
        cNode.right = fNode;
        eNode.right = iNode;

        return new BiTreeStrEle(root);
    }
}
