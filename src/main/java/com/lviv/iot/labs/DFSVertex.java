package com.lviv.iot.labs;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DFSVertex {
    private List<Integer> connectedVertices = new LinkedList<>();
    private boolean visited = false;

    public DFSVertex(){
    }

    @Override
    public String toString() {
        return connectedVertices.stream().map(Object::toString).collect(Collectors.joining(" -> "));
    }
}
