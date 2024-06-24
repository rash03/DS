**AVL TREE**
  - It is a **self balancing BST**
  - It has one additional Property when compared with BST
    - Difference between heights of the left and right subtrees cannot be more than 1 for all nodes
  - If above property is not true for any subtree then rebalncing is done (=> rotation)
![image info](/img/rebalancing.png)
  - Why AVL tree is used
    - To reduce searching time of an element. Example if we insert 10,20,30,40,50,60, 70 and then if we want to search 60
    It will take 6 iterations to reach node with value 60. If it would have a balanced tree then we would have end up with one iteration to reach node with value 60
      ![image info](/img/unbalanced.png) 