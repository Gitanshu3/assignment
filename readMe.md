# Read Me First

FirstSolution

* The first solution covers the question word by word as per the 2 examples shown in the file .
* ConnectionGroup1 is designed to support example 1 and have its own endpoint.
* ConnectionGroup2 is designed to support example 2 and have its own endpoint.
* ConnectionGroup1 accepts 4 requestParams node1, node2, node3, node4 as per the example1.
* ConnectionGroup2 accepts 3 requestParams node5, node6, node7 as per the example2.
* Once the connection is created , user will receive the string that connection is created .
* To test the connection , use the /search endpoint , it accepts a requestParam , nodeName .
* If the nodeName doesn't belong to any connectionGroup , error is thrown.
* If user tries to create a connection with a nodeName that already belongs to connection , an error is thrown.


SecondSolution

* The second solution is more generic which uses the concept of binary tree(as there is no particular form of hierarchy given in the question) , a tree here is a connectionGroup .
* The create endpoint expects a string in "1,2,3,4,5,6" format .
* Now a binary tree is created with nodeNames like , node1, node2, node3 and so on .
* Each binary tree is saved in a list , so that when a search happens , a node is searched through all the available trees.
* The print function also prints the nodes level wise . Left side contains the left side of the tree and right side shows right side of the tree.

# Note:- the solution can be made more generic , like a user can also give what kind of hierarchy he wants , which would different kind of trees , like Binary , AVL , RED-BLACK etc.
