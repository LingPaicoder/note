package com.lpcoder.tree;

import lombok.Data;

/**
 * @author liurenpeng
 * @date Created in 19-5-6
 */
@Data
public class BiTree {

    public final BiTNode root;

    public BiTree(BiTNode root) {
        this.root = root;
    }

    public static final BiTree S_INSTANCE = getStandardInstance();

    private static BiTree getStandardInstance() {
        BiTNode root = new BiTNode("A");
        BiTNode bNode = new BiTNode("B");
        BiTNode cNode = new BiTNode("C");
        BiTNode dNode = new BiTNode("D");
        BiTNode eNode = new BiTNode("E");
        BiTNode fNode = new BiTNode("F");
        BiTNode gNode = new BiTNode("G");
        BiTNode hNode = new BiTNode("H");
        BiTNode iNode = new BiTNode("I");

        root.left = bNode;
        root.right = cNode;

        bNode.left = dNode;
        dNode.left = gNode;
        dNode.right = hNode;

        cNode.left = eNode;
        cNode.right = fNode;
        eNode.right = iNode;

        return new BiTree(root);
    }
}
