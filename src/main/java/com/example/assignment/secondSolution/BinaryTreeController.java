package com.example.assignment.secondSolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class BinaryTreeController {

    @Autowired
    BinaryTreeService binaryTreeService;


    @GetMapping(value="/createFlow")
    ResponseEntity<String> createCollectionGroup(@RequestBody String nodes) {
       String binaryTree =  binaryTreeService.startFlow(nodes);
       if(binaryTree!=null){
           return new ResponseEntity<>(binaryTree+" node already exists", HttpStatus.BAD_REQUEST);
       } else{
           return new ResponseEntity<>("BinaryTree , check application logs to see the flow of the tree", HttpStatus.OK) ;
       }
    }

    @GetMapping(value="/binaryTree/search")
    ResponseEntity<String> searchByNodeName(@RequestParam String nodeName) {
        String nodeExists =  binaryTreeService.containsNode(nodeName);
        if(nodeExists!=null){
            return new ResponseEntity<>(nodeExists, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(nodeName+" not available in any connection group", HttpStatus.OK) ;
        }
    }
}
