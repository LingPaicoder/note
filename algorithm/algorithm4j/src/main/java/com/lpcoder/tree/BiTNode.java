package com.lpcoder.tree;

import lombok.Data;

/**
 * @author liurenpeng
 * @date Created in 19-5-6
 */
@Data
public class BiTNode {
    public final String ele;
    public BiTNode left;
    public BiTNode right;

    public BiTNode(String ele) {
        this.ele = ele;
    }
}
