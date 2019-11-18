package com.lviv.iot.labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        final DirectedGraph graph = readGraphFromFile();

        GraphUtils.getGraphCycle(
                Objects.requireNonNull(graph)
        );

        System.out.println(System.lineSeparator());
    }

    private static DirectedGraph readGraphFromFile() {
        try {
            Scanner scanner = new Scanner(new File("/Users/admin/Documents/studying/scala/part3lab3/src/main/java/com/lviv/iot/labs/input.txt"));

            final int edgesCount = scanner.nextInt();
            final DirectedGraph graph = new DirectedGraph(edgesCount);

            for(int i = 0; i < edgesCount; i++) {
                graph.addEdge(scanner.nextInt(), scanner.nextInt());
            }

            return graph;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
