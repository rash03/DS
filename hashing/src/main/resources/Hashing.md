**Hashing**
- It is a method of sorting and indexing data.
- Keys are created using formulas and data as its input
- why Hashing
    - It is time efficient in case of search operation
    -   | Data Structure | Time Complexity For Search |
                 |----------------|----------------------------|
        | Array          | O(logN)                    |
        |        Linked List    | O(N)                       |
        |        Tree           | O(logN)                    |
        |        Hashing        | O(1)/O(1)                      |
    - For best performance (which is O(1) the Hash Functions should have less collisions
    - Hash Function: maps data of arbitrary size into a different data of fixed size
        - Key : Inpuot data from user
        - hash Value : A value returned by hash Function
        - Hash Table - a data structure that maps keys to value
        - Collision : A collision occurs when two di different keys to a hash function results in same output value.
        - Mod Function
            - useful when input is a number.
            - take modulus (that is remainder) for number divided by number of cells
              mod(400,24) = 16
              mod(700,24) = 4
            - input is number
            - mod(400,24) => 16
           - ASCII - input is string
           - modASCII("ABC",24) => (65+66+67) mod 24 => 6
        - Properties of Hash Functions
          - Distributes the hash values uniformly across hash tables
          - It has to use all input data
          - Collision Resolution Technique
            - Direct Chaining
              - It has an array of references. it stores the reference of a link-list
              - hashTable is full
                - hashtable is never full as we keep on adding node.
            - Open Addressing 
              - Colliding elements are stored in other vacant buckets. These buckets are found by 'probing'
              - HashTable is full
                - Create 2X size of current hashTable and recall hashing for current keys
                - based on load factor, if it is greater than 0.75 then a new hashtable is created and items are moved to it.
              - Types of Probing
                - Liner Probing
                  - It places the key into the closest following empty cell.
                - Quadratic probing
                  - Adding arbitrary quadratic polynomial to the index until an empty cell is found 
                - Double hashing
                  - Interval between probe is computed using another hash Function
