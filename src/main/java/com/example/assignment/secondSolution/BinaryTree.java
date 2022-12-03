package com.example.assignment.secondSolution;

public class BinaryTree {
    public Node root=null;
    String name;

    public BinaryTree(String name){
        this.name=name;
    }

    public void add(int value) {
        root = createFlow(root, value);
    }

    Node createFlow(Node current, int value) {
        if(current==null){
            return new Node(value);
        } else if(current.data>value){
            if(current.left!=null){
                createFlow(current.left, value);
            } else {
                current.left= new Node(value);
            }
        } else if(current.data<value){
            if(current.right!=null){
                createFlow(current.right, value);
            } else{
                current.right = new Node(value);
            }
        } else{
            return current;
        }
        return current;
    }
}
