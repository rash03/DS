- DirectChaining
  - Hash Table never gets full
  - Huge Link list cause performance issues. Search can take upto O(N)

- OpenAddressing
  - Easy Implementation
  - When hastable is full rehash take O(N) time complexity. Search can take up to O(N)

- When the input size is known then use OpenAddressing
- If we perform deletion frequently then  use Direct  Chaining

- Use of hashing
  - Passwords are hashed and the hasvalue is stored in DB. This prevents password leak in case of breach
  - File System
    - File path is hashed and then the value tells the physical location of the sector in the hard disk
- Hashing VS Other DS
  - When hashfunction is good then isnertion / deletion/ searching/ operation takes O(1) time
  - When hashfunction is not good then it takes O(N)
  -  | Operation | Array | LinkList | Tree    | Hashing  |
     |-------|-------|----------|---------|----------|
      | Insertion | O(N)  | O(N)       | O(LogN) | O(1)/O(N) |
| Deletion | O(N)     | O(N)       | O(LogN)       |     O(1)/O(N)      |
     | Search | O(N)     | O(N)       | O(LogN)      | O(1)/O(N)        |