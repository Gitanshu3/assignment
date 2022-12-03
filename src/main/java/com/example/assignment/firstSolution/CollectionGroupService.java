package com.example.assignment.firstSolution;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CollectionGroupService {

    static List<CollectionGroup> collectionGroupList = new ArrayList<>();

    // function to create a new Node
    Node newNode(String name)
    {
        return new Node(name);
    }

    // function to check if node already exist in some other collectionGroup
    String checkExistence(List<String> nodes) {
        for (String name : nodes) {
            if(searchByNodeName(name)!=null){ // meaning a node already belongs to a connection group
                try {
                    throw new Exception(name+" already exists in another connection group");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return name; // returning the name of the node that already exists in the connection group
                }
            }
        }
        return null ;
    }

    // function to check the child Nodes
    String checkChildren(List<Node> nodes, String name){
        for(Node child : nodes){
            if(child.getName().equals(name)){
                return name;
            }

           String val= checkChildren(child.getNodes(), name);
            if(val!=null){
                return val;
            }
        }
        return null;
    }

    // function to return the collection name to which the node belongs to
    String searchByNodeName(String name){
        for (CollectionGroup collectionGroup : collectionGroupList) {

            Node parentNode = collectionGroup.getNode() ;

            // checking the parent node
            if(parentNode.getName().equals(name)){
                return name+" belongs to "+collectionGroup.getName();
            }

            String val = checkChildren(parentNode.getNodes(), name);
            if(val!=null){
                return val+" belongs to "+collectionGroup.getName();
            }
        }
        return null;
    }

    String createCollectionGroup1(String node1, String node2, String node3, String node4){

        String val = checkExistence(Arrays.asList(node1, node2, node3, node4)) ;
        if(val!=null){
            return val ; // cannot create the connection group as val already exists in some other connection group , returning the node name
        }

        CollectionGroup collectionGroup1 = new CollectionGroup() ;
        collectionGroup1.setName("CollectionGroup1");

        Node n1 = newNode(node1) ;
        collectionGroup1.setNode(n1);

        Node n2 = newNode(node2);
        n2.getNodes().add(newNode(node3));
        n2.getNodes().add(newNode(node4));

        n1.getNodes().add(n2) ;

        collectionGroupList.add(collectionGroup1);

        return null;
    }

    String createCollectionGroup2(String node1, String node2, String node3){

        String val = checkExistence(Arrays.asList(node1, node2, node3)) ;
        if(val!=null){
            return val ; // cannot create the connection group as val already exists in some other connection group , returning the node name
        }

        CollectionGroup collectionGroup2 = new CollectionGroup() ;
        collectionGroup2.setName("CollectionGroup2");

        Node n1 = newNode(node1);
        Node n2 = newNode(node2);
        Node n3 = newNode(node3);

        n1.getNodes().add(n2);
        n2.getNodes().add(n3);

        collectionGroup2.setNode(n1);

        collectionGroupList.add(collectionGroup2);
        return null ;
    }
}
