package code.lint.three.binaryTreeDivideConquer;

/*
*
* Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to
any node in the tree along the parent-child connections.
The longest consecutive path need to be from parent to child (cannot be the reverse).

Have you met this question in a real interview? Yes
Example
For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

二叉树最长连续序列
给一棵二叉树，找到最长连续路径的长度。
这条路径是指 任何的节点序列中的起始节点到树中的任一节点都必须遵循 父-子 联系。
最长的连续路径必须是从父亲节点到孩子节点（不能逆序）。

* */
public class BinaryTreeLongestConsecutiveSequence {


    int paths = 0;

    /*
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here

        helper(root);
        return paths;
    }

    public int helper(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int count = 1;

        if(root.left != null && root.val + 1 == root.left.val ){
            count = Math.max(count, left + 1);
        }

        if(root.right != null && root.val + 1 == root.right.val){
            count = Math.max(count, right + 1);
        }

        paths = Math.max(count, paths);

        return count;
    }

    // Jiu Zhang's Answer

    /*
    * // version 1: Traverse + Divide Conquer

    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode parent, int lengthWithoutRoot) {
        if (root == null) {
            return 0;
        }

        int length = (parent != null && parent.val + 1 == root.val) ? lengthWithoutRoot + 1
            : 1;
        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);
        return Math.max(length, Math.max(left, right));
    }

    // version 2: Another Traverse + Divide Conquer

         private int longest;

     public int longestConsecutive(TreeNode root) {
         longest = 0;
         helper(root);
         return longest;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int subtreeLongest = 1; // at least we have root
        if (root.left != null && root.val + 1 == root.left.val) {
            subtreeLongest = Math.max(subtreeLongest, left + 1);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            subtreeLongest = Math.max(subtreeLongest, right + 1);
        }

        if (subtreeLongest > longest) {
            longest = subtreeLongest;
        }
        return subtreeLongest;
    }

    // version 3: Divide Conquer

    private class ResultType {
        int maxInSubtree;
        int maxFromRoot;
        public ResultType(int maxInSubtree, int maxFromRoot) {
            this.maxInSubtree = maxInSubtree;
            this.maxFromRoot = maxFromRoot;
        }
    }

    public int longestConsecutive(TreeNode root) {
        return helper(root).maxInSubtree;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // 1 is the root itself.
        ResultType result = new ResultType(0, 1);

        if (root.left != null && root.val + 1 == root.left.val) {
            result.maxFromRoot = Math.max(
                result.maxFromRoot,
                left.maxFromRoot + 1
            );
        }

        if (root.right != null && root.val + 1 == root.right.val) {
            result.maxFromRoot = Math.max(
                result.maxFromRoot,
                right.maxFromRoot + 1
            );
        }

        result.maxInSubtree = Math.max(
            result.maxFromRoot,
            Math.max(left.maxInSubtree, right.maxInSubtree)
        );

        return result;
    }
    *
    * */

    // Shuo Chang's Answer

    /*
    *
    * int longest = 1;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }

    public int helper(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
               int curt = 1;
          if (root.left != null && root.left.val - 1 == root.val){
            if (left >= right){
                curt = left + 1;
            }
        }

        if (root.right != null && root.right.val - 1 == root.val){
            if (right >= left){
                curt = right + 1;
            }
        }



        if (curt > longest){
            longest = curt;
        }
        return curt;
    }
    *
    * */
}
