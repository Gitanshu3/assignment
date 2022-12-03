package com.example.assignment.secondSolution;

public class Node {
    String name;
    int data;
    public Node left;
    public Node right;

    public Node(int value){
        this.data=value;
        this.left=null;
        this.right=null;
        this.name="node"+value;
    }
}
