
07-06-2022
[Question](https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1/)
```
class Solution
{
    Node prev;
    Node head;
    Node bToDLL(Node root) {	
        prev = null;
        head = null;
        helper(root);
        return head;
    }
    void helper(Node root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (head == null) {
            head = root;
        }
        if (prev != null) {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        helper(root.right);
    }
}
```
