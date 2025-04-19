19-04-2025
[Question](https://leetcode.com/problems/find-the-duplicate-number/)

# Explanation: Why Floyd’s Cycle Detection Works for Finding the Duplicate Number

## Model the Array as a Linked Structure

- Treat each **index** in the array as a **node**.
- The value at index `i`, i.e., `a[i]`, defines a **directed edge** from node `i` to node `a[i]`.

  Example:
  - If `a[0] = 3`, then there is a link: `0 → 3`.

---

## Array Properties

- The array contains **n + 1** elements.
  - So there are `n + 1` nodes labeled from `0` to `n`.

- Each value in the array lies in the range `[1, n]`.
  - So every node points to **another node** in the range `[1, n]`.

---

## Implication of the Structure

- Since there are `n + 1` nodes but only `n` possible target nodes,
- By the **pigeonhole principle**, **at least two nodes** must point to the **same target node**.

---

## Definition of the Duplicate

- The **duplicate number** is the **value** that appears more than once in the array.
- In the graph model:
  - It is the **node that is the target of multiple edges**.
  - In other words, **multiple nodes point to the same node**.
- This creates a **cycle** in the graph: two paths eventually converge and loop back.

---

## Why Floyd’s Cycle Detection Works

- The graph we’ve modeled from the array behaves like a **linked list with a cycle**.
- The **start of the cycle** (i.e., where the loop begins) corresponds to the **duplicate number**.

---

## Floyd’s Cycle Detection Algorithm

1. **Phase 1: Detect a meeting point inside the cycle**
   - Use two pointers:
     - `slow = a[0]`
     - `fast = a[0]`
   - Move them:
     - `slow = a[slow]`
     - `fast = a[a[fast]]`
   - They will eventually meet **inside the cycle**.

2. **Phase 2: Find the start of the cycle (duplicate)**
   - Reset one pointer to the start: `slow = a[0]`
   - Move both pointers one step at a time:
     - `slow = a[slow]`
     - `fast = a[fast]`
   - When they meet again, it is at the **cycle start**, which is the **duplicate number**.


  
```java
class Solution {
    public int findDuplicate(int[] a) {
        int slow = 0;
        int fast = 0;
        do {
            slow = a[slow];
            fast = a[a[fast]];
        } while (slow != fast);

        fast = 0;
        while (slow != fast) {
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }
}
```
