package com.lpcoder.graph.traversal;

import com.lpcoder.graph.Graph;
import com.lpcoder.graph.Vertex;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liurenpeng
 * @date Created in 19-5-7
 */
public class DFSTraversal {

    public static void main(String[] args) {
        dfsTraversal(Graph.INSTANCE);
    }

    private static final Map<String, Boolean> VISITED_MAP = new HashMap<>();

    private static void dfsTraversal(Graph graph) {
        // 初始化visitedMap
        for (String vertexKey : graph.map.keySet()) {
            VISITED_MAP.put(vertexKey, false);
        }

        for (String vertexKey : graph.map.keySet()) {
            if (!VISITED_MAP.get(vertexKey)) {
                dfs(graph, "", vertexKey);
            }
        }
    }

    private static void dfs(Graph graph, String preVertexKey, String vertexKey) {
        Vertex currVertex = graph.map.get(vertexKey);
        System.out.print(currVertex.data);
        VISITED_MAP.put(vertexKey, true);

        Vertex next = graph.map.get(currVertex.firstEdge.vertexKey);
        if (preVertexKey.equals(next.data)) {
            next = graph.map.get(currVertex.firstEdge.next.vertexKey);
        }
        while (next != null) {
            if (!VISITED_MAP.get(next.data)) {
                dfs(graph, currVertex.data, next.data);
            }
            next = graph.map.get(next.firstEdge.vertexKey);
        }
    }
}
