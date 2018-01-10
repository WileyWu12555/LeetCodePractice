package code.lint.three.binaryTreeDivideConquer;


import java.util.ArrayList;
import java.util.List;

/*

Given a binary tree, find all paths that sum of the nodes in the
 path equals to a given number target.

A valid path is from root node to any of the leaf nodes.

Have you met this question in a real interview? Yes
Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]

给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。

一个有效的路径，指的是从根节点到叶节点的路径。
 */
public class BinaryTreePathSum {

    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here

        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        helper(root, target, root.val, temp, results);
        return results;
    }

    public void helper(TreeNode root, int target, int sum, List<Integer> temp,  List<List<Integer>> results){

        if(root.left == null && root.right == null){
            if(sum == target){
                results.add(temp);
                return;
            }
        }

        if(root.left != null){
            temp.add(root.left.val);
            helper(root.left, target, sum + root.left.val, temp, results);
            temp.remove(temp.size() - 1);
        }

        if(root.right != null){
            temp.add(root.right.val);
            helper(root.right, target, sum + root.right.val, temp, results);
            temp.remove(temp.size() - 1);
        }

    }

    // Jiu Zhang's Answer
    /*

     public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Algorithm: Traverse
        // Use recursion to traverse the tree in preorder, pass with a parameter
        // `sum` as the sum of each node from root to current node.
        // Put the whole path into result if the leaf has a sum equal to target.

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root, path, root.val, target, result);
        return result;
    }

    private void helper(TreeNode root,
                        ArrayList<Integer> path,
                        int sum,
                        int target,
                        List<List<Integer>> result) {

        // meet leaf
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }

        // go left
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, sum + root.left.val, target, result);
            path.remove(path.size() - 1);
        }

        // go right
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, sum + root.right.val, target, result);
            path.remove(path.size() - 1);
        }
    }

    * */


    // Shuo Chang's Answer
    /*

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<Integer> list = new ArrayList<Integer>();
        helper(list, target, root);
        return result;
    }

    public void helper(List<Integer> list, int target, TreeNode root){
        if (root == null){
            return ;
        }
        list.add(root.val);

        target = target - root.val;

        helper(list,  target , root.left);
        helper(list,  target , root.right);

        if (root.left == null && root.right == null){
            if (target == 0){
                result.add(new ArrayList<Integer>(list));
            }
        }
        list.remove(list.size() - 1);

    }
    *
    * */
}
