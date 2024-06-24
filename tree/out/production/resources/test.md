**Binary Tree**

- Full Binary Tree
  - A node will always have 2 child or 0 child.
- Perfect Binary Tree
  - a binary tree in which all interior nodes have two children
            and all leaves have the same depth or same level
- Complete Binary Tree
  - a binary tree in which every level, except possibly the last,
            is completely filled, and all nodes in the last level are as far
            left as possible. It can have between 1 and 2h nodes at the last level h.
            A perfect tree is therefore always complete but a complete tree is not always perfect.
- Balanced Binary Tree
  - All Leaf nodes are located at same distance from root node.
  - OR
    - difference between the left and the right subtree for any node is not more than one
    - the left subtree is balanced
    - the right subtree is balanced
- Implementation
  - linked List (Doubly LL)
    - Doubly LL
    - left pointer point to left child
    - right pointer points to right child
  - Array
    - Start saving Data from index 1
    - Left Child  = cell[2x]
    - Right child = cell[2x+1]
    - | X |Drinks | Hot | Cold | Tea | Coffee | Non Alcoholic | Alcoholic|
  - Operation
    - Creation
    - deletion of anode
    - search for a value
    - traverse all nodes
    - deletion of tree
    - Traversal
      - Depth First search
        - PreOrder Traversal
          - Root Node-> Left Sub Tree - > Right Sub Tree
            <pre>
                                            N1
                                N2                      N3
                        N4              N5        N6            N7
                    N8     N9
            </pre>
            N1->N2->N4->N8->N9->N5->N3->N6->N7

        - InOrder Traversal
          - Left Sub Tree -> Root -> Right Sub Tree
            <pre>
                                            N1
                                N2                      N3
                        N4              N5        N6            N7
                    N8     N9
            </pre>
            N8 -> N4 -> N9 -> N2 -> N5 -> N1 -> N6 -> N3 -> N7

        - PostOrder Traversal
          - Left Sub Tree -> Right Sub Tree -> Root
            <pre>
                                            N1
                                N2                      N3
                        N4              N5        N6            N7
                    N8     N9
            </pre>
            N8 -> N9 -> N4 -> N5 -> N2 -> N6 -> N7 -> N3 -> N1

      - Breadth First Search
        - Level Order Traversal
            <pre>
                                        N1
                                N2                      N3
                        N4              N5        N6            N7
                    N8     N9
            </pre>
            N1 -> N2 -> N3 -> N4 -> N5 -> N6 -> N7 -> N8 -> N9
    - Insert
      - A root Node is null
      - Tree exist-> look for first empty space.
      - Do a level order traversal and then insert the element at vacant place.