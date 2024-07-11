**Sorting**

- Space Used
    - in place
        - Does not require any extra space for sorting. Example bubble sort
    - out of place
        - Requires extra space for sorting. Example Merge Sort
- Stability
    - Stable
        - After sorting, the sequence of similar contents, in which they appear prior to sorting, is not changed.
          For example if there is a green40 and a red40 in an array of numbers, in that sequence, then after sorting the
          numbers, the sequence is still green40 and then red40 => sequence of identical numbers has not changed
    - Unstable
        - After sorting, the sequence of similar contents, in which they appear prior to sorting, is changed.
          For example if there is a green40 and a red40 in an array of numbers, in that sequence, then after sorting the
          numbers, the sequence is changed to red40 and green40 => sequence of identical numbers has changed
    - Example for stable and unstable sort
        - An object which has NAME and AGE.
        - In DB queries where groupBy is used
    - Terminology
        - Increasing Order
            - Successive element (the one that comes after) is greater than previous one
                - 1,3,5,7,9,11
        - Decreasing Order
            - Successive element (the one that comes after) is less than previous one
                - 11,9,7,5,3,1
        - Non Increasing Order
            - Successive element (the one that comes after) is less than or equal to previous one
              => decreasing order with duplicate elements
                - 11,9,7,5,5,3,1 => when set of elements contains duplicate elements
        - Non Decreasing Order
            - Successive element (the one that comes after) is greater than or equal to previous one
              => Increasing order with duplicate elements
            - 1,3,5,7,7,9,11 => when set of elements contain duplicate elements.
- Sorting Algorithm
    - Bubble Sort
      - compare two cells and swap them based on who is greater. 
      Repeat outer loop 0 = i< n-1 and inner loop 0 = i < n-i-1 times
      - Use
        - When input is almost sorted
        - Space is concern
      - Time Complexity
        - O(N^2)
    - Selection Sort
      - Divide the array in two parts
      Repeatedly find minimum element in array and swap it with first element of unsorted array.
      Thus unsorted array will always be 1 element less in each iteration.
      - Use
        - When we have insufficient memory
      - Time Complexity
        - O(N^2)
    - Insertion Sort
      - Divide the array in two parts. 
      find the first element from unsorted array and find its correct position in sorted array.
      Repeat until unsorted array is empty
      - Use
        - When we have insufficient memory
        - When we have continuous inflow of elements and we want to keep them sorted
      - Time Complexity
          - O(N^2)
    - Bucket Sort
    - Merge Sort
    - Quick Sort
    - Heap Sort
- Which one to select
    - Stability
    - Space efficient
    - Time efficient