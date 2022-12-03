package com.example.assignment.firstSolution;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public Node(String name){
        this.name = name ;
    }

    private String name;
    private List<Node> nodes = new ArrayList<>() ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
