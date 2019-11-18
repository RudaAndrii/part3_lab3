package com.lviv.iot.labs;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class DirectedGraph {
    private Boolean[] visited;
    private DFSVertex[] vertices;
    private Integer edgesCount;

    DirectedGraph(int edgesCount)
    {
        this.edgesCount = edgesCount;
        visited = new Boolean[edgesCount];
        vertices = new DFSVertex[edgesCount];
        for (int i = 0; i < edgesCount; i++) {
          vertices[i] = new DFSVertex();
          visited[i] = false;
        }
    }

    void addEdge(int vertex, int connectedVertex) {
        vertices[vertex].getConnectedVertices().add(connectedVertex);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < vertices.length; i++) {
            builder.append("Head ")
                    .append(i)
                    .append(" -> ")
                    .append(vertices[i])
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
