**Binary Search Tree**
- Properties
  - In addition to Binary Tree there are two additional properties
    - In left subtree the value of the node is less than or equal to its parent node's value
    - In right subtree the value of the node is greater than its parent node's value
    ```mermaid
      graph TD;
        40-->20;
        40-->50;
    ```
    
    - BST does not store index of is data, but because of its structure (as mentioned in above 2 points) **insertion and deletions are faster than BT**
    - Since we traverse half tree in BST hence the Time complexity is O(logN)
    ```mermaid
      graph TD;
        70-->50;
        70-->90;
        50-->30;
        50-->60;
        30-->20;
        30-->40;
        90-->80;
        90-->100;
        100-->95;
    ```
    - Insertion
      - Compare values and recursively call functions
    - Delete A Node
      - The Node to delete is a **Leaf Node**
        - Iterate to the node and delete it
      - the Node has **One Child**
        - Iterate to the node and replace the child not in its place.
      - The Node has **Two Child**
        - Find the successor of the Node.
          - Find the smallest Node in the Right sub tree
        - Replace the smallest Node with the target node
        - The child of the smallest node is now child of the parent of the smallest Node

**Complexity**

|                 | Time Complexity | Space Complexity |
|-----------------|-----------------|------------------|
 Create BST       | O(1)            | O(1)             |
 Insert Node   BST  | O(LogN)         | O(LogN)          |
 Traverse BST    | O(N)            | O(N)             |
 Search Node  BST    | O(logN)         | O(logN)          |
  Delet Node BST  | O(LogN)         | O(logN)          | 
 Delete BT       | O(1)            | O(1)             |