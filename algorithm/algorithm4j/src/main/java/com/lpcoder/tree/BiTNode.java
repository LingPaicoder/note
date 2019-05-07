package com.lpcoder.tree;

import lombok.Data;

/**
 * @author liurenpeng
 * @date Created in 19-5-6
 */
@Data
public class BiTNode<E> {
    public final E ele;
    public BiTNode left;
    public BiTNode right;

    public BiTNode(E ele) {
        this.ele = ele;
    }
}
