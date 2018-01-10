package code.lint.three.binaryTreeDivideConquer;

/*

Your are given a binary tree in which each node contains a value.
Design an algorithm to get all paths which sum to a given value.
The path does not need to start or end at the root or a leaf,
but it must go in a straight line down.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

    1
   / \
  2   3
 /   /
4   2
for target = 6, return

[
  [2, 4],
  [1, 3, 2]
]

给一棵二叉树和一个目标值，设计一个算法找到二叉树上的和为该目标值的所有路径。
路径可以从任何节点出发和结束，但是需要是一条一直往下走的路线。
也就是说，路径上的节点的层级是逐个递增的。
*
* */


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumII {

    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> paths = new ArrayList<>();
        if(root == null){
            return result;
        }

        helper(result, paths, 0, root, target);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> paths, int level, TreeNode root, int target ){

        if(root == null){
            return;
        }

        int tmp = target;
        paths.add(root.val);

        for(int i = level; i >= 0; i--){
            tmp -= paths.get(i);
            if(tmp == 0){
                List<Integer> temp = new ArrayList<>();
                for(int j = i; j <= level; ++j){
                    temp.add(paths.get(j));
                }
                result.add(temp);
            }
        }

        helper(result, paths, level + 1, root.left, target);
        helper(result, paths, level + 1, root.right, target);

        paths.remove(paths.size() - 1);

    }

    // Jiu Zhang's Answer
    /*
    *
     public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        if (root == null)
            return results;
        findSum(root, target, buffer, 0, results);
        return results;
    }

    public void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level, List<List<Integer>> results) {
        if (head == null) return;
        int tmp = sum;
        buffer.add(head.val);
        for (int i = level;i >= 0; i--) {
            tmp -= buffer.get(i);
            if (tmp == 0) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int j = i; j <= level; ++j)
                    temp.add(buffer.get(j));
                results.add(temp);
            }
        }
        findSum(head.left, sum, buffer, level + 1, results);
        findSum(head.right, sum, buffer, level + 1, results);
        buffer.remove(buffer.size() - 1);
    }
    *
    * */

   // Shuo Chang's Answer
   /*
   *
   * List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, target, list);
        return result;

    }
    public void helper(TreeNode root, int target, List<Integer> list){
        if (root == null){
            return;
        }

        list.add(root.val);
        int sum = 0;

        for (int i = list.size() - 1; i >= 0; i--){
            sum += list.get(i);
            if (sum == target){
                List<Integer> temp = new ArrayList<Integer>();
                for (int j = i; j < list.size(); j++){
                    temp.add(list.get(j));
                }
                result.add(temp);
            }
        }

        helper(root.left, target, list);
        helper(root.right, target, list);
        list.remove(list.size() - 1);
    }
   *
   * */

}
