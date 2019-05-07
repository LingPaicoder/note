package com.lpcoder.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liurenpeng
 * @date Created in 19-5-7
 */
public class Graph {

    public Map<String, Vertex> map = new HashMap<>();

    public static final Graph INSTANCE = getInstance();

    private static Graph getInstance() {
        Graph graph = new Graph();
        Vertex aVertex = new Vertex("A");
        Vertex bVertex = new Vertex("B");
        Vertex cVertex = new Vertex("C");
        Vertex dVertex = new Vertex("D");
        Vertex eVertex = new Vertex("E");
        Vertex fVertex = new Vertex("F");
        Vertex gVertex = new Vertex("G");
        Vertex hVertex = new Vertex("H");
        Vertex iVertex = new Vertex("I");

        aVertex.firstEdge = new AdjVertex("B",
                new AdjVertex("F", null));
        bVertex.firstEdge = new AdjVertex("A",
                new AdjVertex("C",
                        new AdjVertex("G",
                                new AdjVertex("I", null))));
        cVertex.firstEdge = new AdjVertex("B",
                new AdjVertex("D",
                        new AdjVertex("I", null)));
        dVertex.firstEdge = new AdjVertex("C",
                new AdjVertex("E",
                        new AdjVertex("G",
                                new AdjVertex("H",
                                        new AdjVertex("I", null)))));
        eVertex.firstEdge = new AdjVertex("D",
                new AdjVertex("F",
                        new AdjVertex("H", null)));
        fVertex.firstEdge = new AdjVertex("A",
                new AdjVertex("E",
                        new AdjVertex("G", null)));
        gVertex.firstEdge = new AdjVertex("B",
                new AdjVertex("D",
                        new AdjVertex("F",
                                new AdjVertex("H", null))));
        hVertex.firstEdge = new AdjVertex("D",
                new AdjVertex("E",
                        new AdjVertex("G", null)));
        iVertex.firstEdge = new AdjVertex("B",
                new AdjVertex("C",
                        new AdjVertex("D", null)));

        graph.map.put("A", aVertex);
        graph.map.put("B", bVertex);
        graph.map.put("C", cVertex);
        graph.map.put("D", dVertex);
        graph.map.put("E", eVertex);
        graph.map.put("F", fVertex);
        graph.map.put("G", gVertex);
        graph.map.put("H", hVertex);
        graph.map.put("I", iVertex);

        return graph;
    }

}
