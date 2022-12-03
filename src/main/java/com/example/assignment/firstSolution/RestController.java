package com.example.assignment.firstSolution;

import com.example.assignment.firstSolution.CollectionGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    CollectionGroupService collectionGroupService;

    @GetMapping(value="/create/connectionGroup1")
    ResponseEntity<String> createCollectionGroup1(@RequestParam String node1, @RequestParam String node2, @RequestParam String node3, @RequestParam String node4){
        String val = collectionGroupService.createCollectionGroup1(node1, node2, node3, node4);
        if(val != null){
            return new ResponseEntity<>(val+" already exists in some other connection group", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Connection group 1 is created with given nodes , to test use the search endpoint to check which node belongs to which connection", HttpStatus.OK);
    }

    @GetMapping(value="/create/connectionGroup2")
    ResponseEntity<String> createCollectionGroup2(@RequestParam String node5, @RequestParam String node6, @RequestParam String node7){
        String val = collectionGroupService.createCollectionGroup2(node5, node6, node7);
        if(val != null){
            return new ResponseEntity<>(val+" already exists in some other connection group", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Connection group 2 is created with given nodes , to test use the search endpoint to check which node belongs to which connection", HttpStatus.OK);
    }

    @GetMapping(value="/search")
    ResponseEntity<String> searchByName(@RequestParam String nodeName)  {
        String collectionGroupName = collectionGroupService.searchByNodeName(nodeName);

        if(collectionGroupName == null){
            return new ResponseEntity<>(nodeName+" not available in any group", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(collectionGroupName, HttpStatus.OK);
    }
}
