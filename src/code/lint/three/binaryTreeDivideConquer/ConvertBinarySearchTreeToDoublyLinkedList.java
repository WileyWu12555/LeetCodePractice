package code.lint.three.binaryTreeDivideConquer;


/*
*
* Convert a binary search tree to doubly linked list with in-order traversal.

Have you met this question in a real interview? Yes
Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
return 1<->2<->3<->4<->5

// Definition of TreeNode:
 public class TreeNode {
     public int val;
     public TreeNode left, right;
     public TreeNode(int val) {
         this.val = val;
         this.left = this.right = null;
     }
 }

// Definition for Doubly-ListNode.
public class DoublyListNode {
     int val;
     DoublyListNode next, prev;
     DoublyListNode(int val) {
         this.val = val;
         this.next = this.prev = null;
     }
 }

* */

class ResultType2{

    DoublyListNode first;

    DoublyListNode last;

    public ResultType2(DoublyListNode first, DoublyListNode last) {
        this.first = first;
        this.last = last;
    }
}

public class ConvertBinarySearchTreeToDoublyLinkedList {

    /*
   * @param root: The root of tree
   * @return: the head of doubly list node
   */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if(root == null){
            return null;
        }

        ResultType2 resultType2 = helper(root);

        return resultType2.first;

    }

    public ResultType2 helper(TreeNode root){

        if(root == null){
            return null;
        }

        ResultType2 left = helper(root.left);
        ResultType2 right = helper(root.right);

        DoublyListNode node = new DoublyListNode(root.val);

        ResultType2 resultType2 = new ResultType2(null, null);

        if(root.left == null){
            resultType2.first = node;
        }else{
            resultType2.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }


        if(root.right == null){
            resultType2.last = node;
        }else{
            resultType2.last = right.last;
            right.first.prev = node;
            node.next = right.first;
        }

        return resultType2;
    }

    // Jiu Zhang's Answer
    /*

    class ResultType {
    DoublyListNode first, last;

    public ResultType(DoublyListNode first, DoublyListNode last) {
        this.first = first;
        this.last = last;
    }
}

 public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        ResultType result = helper(root);
        return result.first;
    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode node = new DoublyListNode(root.val);

        ResultType result = new ResultType(null, null);

        if (left == null) {
            result.first = node;
        } else {
            result.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }

        if (right == null) {
            result.last = node;
        } else {
            result.last = right.last;
            right.first.prev = node;
            node.next = right.first;
        }

        return result;
    }


    *
    * */

}
