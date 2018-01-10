package code.lint.three.binaryTreeDivideConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 505007855 on 9/19/2017.
 */



/*
*
* Given a binary tree, return all root-to-leaf paths.

Have you met this question in a real interview? Yes
Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]
*
* */

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode_String root) {

        List<String> paths = new ArrayList<>();

        if(root == null){
            return paths;
        }

        List<String> leftList = binaryTreePaths(root.left);
        List<String> rightList = binaryTreePaths(root.right);

        for(String leftPath : leftList){
            paths.add(root + "->" + leftPath);
        }

        for(String rightPath : rightList){
            paths.add(root + "->" + rightPath);
        }

        if(paths.size() == 0){
            paths.add(root.val);
        }

        return paths;

    }


    // JIU Zhang's Answer
    /*
    *
    * // version 1: Divide Conquer
    *
    public class Solution {
    // @param root the root of the binary tree
     //@return all root-to-leaf paths

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }

        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }

        return paths;
    }
}
    *
    * */



    //Shuo Chang's Answer

    /*
    *
    * public class Solution {

     // @param root the root of the binary tree
    //  @return all root-to-leaf paths

    public List<String> binaryTreePaths(TreeNode root) {
        return helper(root);
    }

    public List<String> helper(TreeNode root){
        List<String> list = new ArrayList<String>();
        if (root == null){
            return list;
        }

        List<String> left = helper(root.left);
        List<String> right = helper(root.right);

        for (String ele : left){
            list.add(root.val + "->"  + ele);
        }

        for (String ele : right){
            list.add(root.val + "->" + ele);
        }

        if (list.size() == 0){
            list.add(root.val + "");
        }
        return list;
    }
}

    * */

}
