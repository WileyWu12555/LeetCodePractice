package code.lint.three.binaryTreeDivideConquer;


/*
*
* It's follow up problem for Binary Tree Longest Consecutive Sequence II

Given a k-ary tree, find the length of the longest consecutive sequence path.
The path could be start and end at any node in the tree

Have you met this question in a real interview? Yes
Example
An example of test data: k-ary tree 5<6<7<>,5<>,8<>>,4<3<>,5<>,3<>>>, denote the following structure:


     5
   /   \
  6     4
 /|\   /|\
7 5 8 3 5 3

Return 5, // 3-4-5-6-7

这题是 二叉树的最长连续子序列II 的后续。
给出一棵 k叉树，找到最长连续序列路径的长度.
路径的开头跟结尾可以是树的任意节点。

*
* */

/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */

class ResultType4{

    int max_up;
    int max_down;
    int max_len;
    public ResultType4(int max_up, int max_down, int max_len) {
        this.max_up = max_up;
        this.max_down = max_down;
        this.max_len = max_len;
    }
}


public class BinaryTreeLongestConsecutiveSequenceIII {

    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here

        return helper(root).max_len;
    }

    public ResultType4 helper(MultiTreeNode root){

        if(root == null){
            return new ResultType4(0, 0, 0);
        }

        int up = 0;
        int down = 0;
        int len = 1;

        for (MultiTreeNode node : root.children) {

            ResultType4 result = helper(node);

            if(node.val + 1 == root.val){
                down = Math.max(down, result.max_down + 1);
            }

            if(node.val - 1 == root.val){
                up = Math.max(up , result.max_up + 1);
            }

            len = Math.max(len, result.max_len);
        }

        len = Math.max(down + up + 1, len);

        return new ResultType4(up, down, len);

    }


    // Jiu Zhang's Answer

    /*
    *

    class ResultType {
    public int max_len, max_down, max_up;
    ResultType(int len, int down, int up) {
        max_len = len;
        max_down = down;
        max_up = up;
     }
    }

    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        return helper(root).max_len;
    }

    ResultType helper(MultiTreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }

        int down = 0, up = 0, max_len = 1;
        for (MultiTreeNode node : root.children) {
            ResultType type = helper(node);
            if (node.val + 1 == root.val)
                down = Math.max(down, type.max_down + 1);
            if (node.val - 1 == root.val)
                up = Math.max(up, type.max_up + 1);
            max_len = Math.max(max_len, type.max_len);
        }

        max_len = Math.max(down + 1 + up, max_len);
        return new ResultType(max_len, down, up);
    }

    *
    *
    * */



    // Shuo Chang's Answer

    /*
    *
    * class ResultType4 {
    int up;
    int down;
    int len;
    public ResultType4(int up, int down, int len){
        this.up = up;
        this.down = down;
        this.len = len;
    }
}

public int longestConsecutive3(MultiTreeNode root) {
        return helper( root).len;
    }

    public ResultType helper(MultiTreeNode root){
        if (root == null){
            return new ResultType(0, 0, 0);
        }

        int up = 0;
        int down = 0;
        int len = 1;
        for (MultiTreeNode child : root.children){
            ResultType node = helper(child);

            if (child != null && child.val + 1 == root.val){
                up = Math.max(up, node.up + 1);
            }

            if (child != null && child.val - 1 == root.val){
                down = Math.max(down, node.down + 1);
            }
            len = Math.max(len, node.len);
        }
        len = Math.max(len, up + down + 1);
        return new ResultType (up, down, len);
    }

    *
    * */

}
