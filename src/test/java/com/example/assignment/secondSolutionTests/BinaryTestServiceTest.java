package com.example.assignment.secondSolutionTests;

import com.example.assignment.secondSolution.BinaryTree;
import com.example.assignment.secondSolution.BinaryTreeService;
import com.example.assignment.secondSolution.Node;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BinaryTestServiceTest {

    @Autowired
    BinaryTreeService binaryTreeService ;

    @Test
    public void testStartFlow(){
        String nodes = "10,1,12,14,2,6,18";
        binaryTreeService.startFlow(nodes);
    }

    @Test
    public void testSearch(){
        Node root = new Node(10);
        Node firstLeft = new Node(9);
        Node firstRight = new Node(11);
        root.left = firstLeft ;
        root.right = firstRight ;
        BinaryTree binaryTree1 = new BinaryTree("binaryTree1");
        binaryTree1.root = root ;


        Node root1 = new Node(110);
        Node firstLeft1 = new Node(109);
        Node firstRight1 = new Node(111);
        root1.left = firstLeft1;
        root1.right = firstRight1 ;
        BinaryTree binaryTree2 = new BinaryTree("binaryTree2");
        binaryTree2.root = root1 ;



        List<BinaryTree> list = new ArrayList<>();
        list.add(binaryTree1);
        list.add(binaryTree2);
        BinaryTreeService.binaryTreeList = list ;

        assert binaryTreeService.containsNode("node9")!=null;
        assert binaryTreeService.containsNode("node111")!=null;
        assert binaryTreeService.containsNode("node1")==null;
    }
}
