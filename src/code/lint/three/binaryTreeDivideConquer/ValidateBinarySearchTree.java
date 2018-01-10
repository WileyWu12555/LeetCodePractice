package code.lint.three.binaryTreeDivideConquer;


/*
*
* Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Have you met this question in a real interview? Yes
Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
*
* 给定一个二叉树，判断它是否是合法的二叉查找树(BST)

一棵BST定义为：

节点的左子树中的值要严格小于该节点的值。
节点的右子树中的值要严格大于该节点的值。
左右子树也必须是二叉查找树。
一个节点的树也是二叉查找树。
* */

class ResultType1{
    boolean isValid;
    int min;
    int max;

    public ResultType1(boolean isValid, int max, int min){
        this.min = min;
        this.max = max;
        this.isValid = isValid;
    }

}

public class ValidateBinarySearchTree {

    /*
    * @param root: The root of binary tree.
    * @return: True if the binary tree is BST, or false
    */
    public boolean isValidBST(TreeNode root) {
        // write your code here

        ResultType1 rt = isValidBSTHelper(root);
        return rt.isValid;
    }


    public ResultType1 isValidBSTHelper(TreeNode root){

        if(root == null){
            return new ResultType1(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ResultType1 left = isValidBSTHelper(root.left);
        ResultType1 right = isValidBSTHelper(root.right);

        if(!left.isValid || !right.isValid){
            return new ResultType1(false, 0, 0);
        }

        if((root.left != null && left.max >= root.val) ||
                (root.right != null && right.min <= root.val)){
            return new ResultType1(false, 0, 0);
        }

        return new ResultType1(true, Math.max(right.max, root.val), Math.min(left.min, root.val));

    }

    // Jiu Zhang's Answer

    /*

    // version 1 Traverse

     private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    // version 2  Divide and Conquer

    class ResultType {
    boolean is_bst;
    int maxValue, minValue;

    ResultType(boolean is_bst, int maxValue, int minValue) {
        this.is_bst = is_bst;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

     public boolean isValidBST(TreeNode root) {
        ResultType r = validateHelper(root);
        return r.is_bst;
    }

    private ResultType validateHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ResultType left = validateHelper(root.left);
        ResultType right = validateHelper(root.right);

        if (!left.is_bst || !right.is_bst) {
            // if is_bst is false then minValue and maxValue are useless
            return new ResultType(false, 0, 0);
        }

        if (root.left != null && left.maxValue >= root.val ||
              root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }

        return new ResultType(true,
                              Math.max(root.val, right.maxValue),
                              Math.min(root.val, left.minValue));
    }

    // version 3  Divide and Conquer

    public boolean isValidBST(TreeNode root) {
        // write your code here
        return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean divConq(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return divConq(root.left, min, Math.min(max, root.val)) &&
                divConq(root.right, Math.max(min, root.val), max);
    }

    * */


    // Shuo Chang's Answer
    /*
    *
    * class ResultType{
    boolean isBST;
    int min;
    int max;
    public ResultType(boolean isBST, int min, int max){
        this.isBST = isBST;
        this.min = min;
        this.max = max;
    }
}

public boolean isValidBST(TreeNode root) {

        return helper(root).isBST;
    }

    public ResultType helper(TreeNode root){
        if (root == null){
            return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        if (!left.isBST || !right.isBST){
            return new ResultType(false, 0, 0);
        }

        if (root.left != null && left.max >= root.val ||  root.right != null && right.min <= root.val){
            return new ResultType (false, 0, 0);
        }


        int min_value = Math.min(root.val, left.min);
        int max_value = Math.max(root.val, right.max);
        return new ResultType(true, min_value, max_value);
    }
    *
    * */

}
