package com.example.assignment.secondSolution;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class BinaryTreeService {

    public static List<BinaryTree> binaryTreeList = new ArrayList<>();

    public String startFlow(String nodes){
        String binaryTreeName = UUID.randomUUID().toString();
        BinaryTree binaryTree = new BinaryTree(binaryTreeName);
        Stream<Integer> listNodes = Arrays.stream(nodes.split(",")).map(Integer::parseInt);

        // before creating a group , lets check if the node already exists in any available group
        String [] nod = nodes.split(",");
        System.out.println("Searching if the noe already exists in any another connection");
        for (String s : nod) {
            String nodeName = "node"+s;
            String value = containsNode(nodeName);
            if(value!=null){
                return value ;
            }
        }
        System.out.println("Given nodes don't belong to any available connection");
        System.out.println("Creating a new connection");
        listNodes.forEach(value->binaryTree.add(value));
        binaryTreeList.add(binaryTree);
        printBinaryTree(binaryTree);
        return null;
    }


    // checking if a node already exists in a tree
    private boolean containsNodeRecursive(Node current, int value, String nodeName) {
        if (current == null) {
            return false;
        }
        if (nodeName.equals(current.name)) {
            return true;
        }
        return value < current.data
                ? containsNodeRecursive(current.left, value, nodeName)
                : containsNodeRecursive(current.right, value, nodeName);
    }

    public String containsNode(String nodeName) {
        int data = Integer.parseInt(nodeName.substring(4));
        boolean check ;
        for (BinaryTree binaryTree : binaryTreeList) {
           check = containsNodeRecursive(binaryTree.root, data, nodeName);
           if(check){
               return nodeName+ " belongs to "+ binaryTree.name ;
           }
        }
        return null ;
    }

    void printBinaryTree(BinaryTree binaryTree){
        printLevelOrder(binaryTree.root);
    }

    void printLevelOrder(Node root)
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.print(System.lineSeparator());
        }
    }

    void printGivenLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.name + " ");
        }
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    int height(Node root)
    {
        if (root == null)
            return 0;
        else {
            /* compute height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
}
