package com.lviv.iot.labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class GraphUtils {
    static void DFS(DirectedGraph graph, Integer vertex)
    {
        graph.getVertices()[vertex].setVisited(true);

        for (int nextVertex : graph.getVertices()[vertex].getConnectedVertices()) {
            if (!graph.getVertices()[nextVertex].isVisited())
                DFS(graph, nextVertex);
        }
    }

    private static ArrayList<Integer> DFSCycleDetect(DirectedGraph graph, Integer vertex, ArrayList<Integer> visitedVertexes) {

        graph.getVertices()[vertex].setVisited(true);

        visitedVertexes.add(vertex);

        for (int nextVertex : graph.getVertices()[vertex].getConnectedVertices()) {
            if(!graph.getVertices()[nextVertex].isVisited()) {
                visitedVertexes = DFSCycleDetect(graph, nextVertex, visitedVertexes);

                if (!visitedVertexes.isEmpty()) {
                    return visitedVertexes;
                }
            } else {
                if (visitedVertexes.contains(nextVertex)) {
                    return visitedVertexes;
                }
            }
        }
        return new ArrayList<>();
    }

    public static void getGraphCycle(DirectedGraph graph) {
        ArrayList<Integer> cycle = new ArrayList<>();
        for (int i = 0; i < graph.getVertices().length; i++) {
            ArrayList<Integer> vertices = DFSCycleDetect(graph, i, new ArrayList<>());
            if (vertices.size() > 0) {
                cycle = (vertices);
                break;
            }
        }

        if (cycle.isEmpty()) {
            System.out.println("Graph doesn't contains a cycle");
        } else {
            System.out.println(cycle);
        }
    }
}
