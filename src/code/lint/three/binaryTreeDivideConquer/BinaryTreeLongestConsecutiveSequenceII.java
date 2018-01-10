package code.lint.three.binaryTreeDivideConquer;


/*
*
* Given a binary tree, find the length of the longest consecutive sequence path.
The path could be start and end at any node in the tree

Have you met this question in a real interview? Yes
Example
    1
   / \
  2   0
 /
3
Return 4 // 0-1-2-3

给定一棵二叉树，找到最长连续序列路径的长度。
路径起点跟终点可以为二叉树的任意节点。
*
* */

class ResultType3{

    int max_length;
    int max_up;
    int max_down;

    public ResultType3(int max_length, int max_up, int max_down) {
        this.max_length = max_length;
        this.max_up = max_up;
        this.max_down = max_down;
    }

}
public class BinaryTreeLongestConsecutiveSequenceII {

    /*
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        // write your code here

        return helper(root).max_length;
    }


    public ResultType3 helper(TreeNode root){
        if(root == null){
            return new ResultType3(0,0,0);
        }

        ResultType3 left = helper(root.left);
        ResultType3 right = helper(root.right);

        int down = 0;
        int up = 0;

        if(root.left != null && root.left.val + 1 == root.val){
            down = Math.max(down, left.max_down + 1);
        }

        if(root.left != null && root.left.val - 1 == root.val){
            up = Math.max(up, left.max_up + 1);
        }

        if(root.right != null && root.right.val + 1 == root.val){
            down = Math.max(down, right.max_down + 1);
        }

        if(root.right != null && root.right.val - 1 == root.val){
            up = Math.max(up, right.max_up + 1);
        }

        int length = down + 1 + up;

        length = Math.max(length, Math.max(left.max_length, right.max_length));

        return new ResultType3(length,up, down);
    }

    // Jiu Zhang's Answer

    /*

    class ResultType {
    public int max_length, max_down, max_up;
    ResultType(int len, int down, int up) {
        max_length = len;
        max_down = down;
        max_up = up;
     }
    }

     public int longestConsecutive2(TreeNode root) {
        // Write your code here
        return helper(root).max_length;
    }

    ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int down = 0, up = 0;
        if (root.left != null && root.left.val + 1 == root.val)
            down = Math.max(down, left.max_down + 1);

        if (root.left != null && root.left.val - 1 == root.val)
            up = Math.max(up, left.max_up + 1);

        if (root.right != null && root.right.val + 1 == root.val)
            down = Math.max(down, right.max_down + 1);

        if (root.right != null && root.right.val - 1 == root.val)
            up = Math.max(up, right.max_up + 1);

        int len = down + 1 + up;
        len = Math.max(len, Math.max(left.max_length, right.max_length));

        return new ResultType(len, down, up);
    }


    * */


    // Shuo Chang's Answer

    /*
    *
   class ResultType{
    int up;
    int down;
    int len;

    public ResultType(int up, int down, int len){
        this.up = up;
        this.down = down;
        this.len = len;
    }
    }

    public class Solution {
    int length;
    public int longestConsecutive2(TreeNode root) {
        return helper(root).len;

    }
    public ResultType  helper(TreeNode root){
        if (root == null) {
            return new ResultType(0,0,0);
        }
        int up = 0;
        int down = 0;
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //left up
        if (root.left != null && root.left.val + 1 == root.val){
            up = Math.max(up, left.up + 1);
        }
        //left down
        if (root.left != null && root.left.val - 1 == root.val ){
            down = Math.max(down, left.down + 1);
        }

       if (root.right != null && root.right.val + 1 == root.val){
            up = Math.max(up, right.up + 1);
       }

       if (root.right != null && root.right.val - 1 == root.val){
           down = Math.max(down, right.down + 1);
       }

       int len = up + down + 1;
       len = Math.max(len, Math.max(left.len, right.len));
       return new ResultType(up, down, len);
    }

    }

    *
    *
    * */



}
