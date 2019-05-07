package com.lpcoder.test.graph;

/**
 * @author liurenpeng
 * @date Created in 19-5-7
 */
public class AdjVertex {

    public String vertexKey;
    public AdjVertex next;

    public AdjVertex(String vertexKey, AdjVertex next) {
        this.vertexKey = vertexKey;
        this.next = next;
    }
}
