package code.lint.three.binaryTreeDivideConquer;

/*
*
* Give a binary tree, and a target number,
* find all path that the sum of nodes equal to target,
* the path could be start and end at any node in the tree.

Have you met this question in a real interview? Yes
Example
Given binary tree:

    1
   / \
  2   3
 /
4
and target = 6. Return :

[
  [2, 4],
  [2, 1, 3],
  [3, 1, 2],
  [4, 2]
]

给一棵二叉树和一个目标值，找到二叉树上所有的和为该目标值的路径。路径可以从二叉树的任意节点出发，任意节点结束。
*
* */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePathSumIII {

    /*
    * @param root: the root of binary tree
    * @param target: An integer
    * @return: all valid paths
    */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // write your code here
       List<List<Integer>> result = new ArrayList<>();
       dfsHelper(result, root, target);
       return result;
    }

    public void dfsHelper(List<List<Integer>> result, ParentTreeNode root, int target ){
        if(root == null){
            return;
        }

        List<Integer> paths = new ArrayList<>();

        findSum(root, null, target, paths, result);
        dfsHelper(result, root.left, target);
        dfsHelper(result, root.right, target);
    }

    public void findSum(ParentTreeNode root, ParentTreeNode farther, int target, List<Integer> paths, List<List<Integer>> result){

        paths.add(root.val);
        target -= root.val;

        if(target == 0){
            ArrayList<Integer> tmp = new ArrayList<>();
            Collections.addAll(tmp, new Integer[paths.size()]);
            Collections.copy(tmp, paths);
            result.add(tmp);
        }

        if(root.parent != null && root.parent != farther){
            findSum(root.parent, root, target, paths, result);
        }

        if(root.left != null && root.left != farther){
            findSum(root.left, root, target, paths, result);
        }

        if(root.right != null && root.right != farther){
            findSum(root.right, root, target, paths, result);
        }

        paths.remove(paths.size() - 1);

    }

    // Jiu Zhang's Answer

    /*
    *
    * public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        dfs(root, target, results);
        return results;
    }

    public void dfs(ParentTreeNode root, int target, List<List<Integer>> results) {
        if (root == null)
            return;

        List<Integer> path = new ArrayList<Integer>();
        findSum(root, null, target, path, results);

        dfs(root.left, target, results);
        dfs(root.right, target, results);
    }

    public void findSum(ParentTreeNode root, ParentTreeNode father, int target,
                 List<Integer> path, List<List<Integer>> results) {
        path.add(root.val);
        target -= root.val;

        if (target == 0) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            Collections.addAll(tmp,  new  Integer[path.size()]);
            Collections.copy(tmp, path);
            results.add(tmp);
        }

        if (root.parent != null && root.parent != father)
            findSum(root.parent, root, target, path, results);

        if (root.left != null && root.left  != father)
            findSum(root.left, root, target, path, results);

        if (root.right != null && root.right != father)
            findSum(root.right, root, target, path, results);

        path.remove(path.size() - 1);
    }
    *
    * */


    // Shuo Chang's Answer

    /*
    *
    * List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        helper(root, target);
        return result;
    }

    public void helper(ParentTreeNode root, int target){
        if (root == null){
            return;
        }
        List<Integer> path = new ArrayList<Integer>();
        findPath(root, target, path, null);

        helper(root.left, target);
        helper(root.right, target);
    }

    public void findPath(ParentTreeNode root, int target, List<Integer> path, ParentTreeNode from ){
        if (root == null){
            return ;
        }

        path.add(root.val);
        target = target - root.val;
        if (target == 0){
            result.add(new ArrayList<Integer>(path));
        }
        if (root.parent != null && root.parent != from){
            findPath(root.parent, target, path, root);
        }

        if (root.left != null && root.left != from){
            findPath(root.left, target, path, root);
        }

        if (root.right != null && root.right != from){
            findPath(root.right, target, path, root);
        }
        path.remove(path.size() - 1);
    }
    *
    * */

}
