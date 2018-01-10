package code.lint.one.strStrCodingStyle;

import java.util.*;


/*
* Given a list of numbers, return all possible permutations.

 Notice

You can assume that there is no duplicate numbers in the list.

Have you met this question in a real interview? Yes
Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge
Do it without recursion.
* */
public class Permutations {

    /*
    * @param nums: A list of integers.
    * @return: A list of permutations.
    */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();

        if(nums == null){
            return result;
        }

        if(nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> subList = new ArrayList<>();
        Set<Integer> subSet = new HashSet<>();

        helper(result, subList, subSet, nums);
        return result;

    }

    public void helper(List<List<Integer>> result, List<Integer> subList, Set<Integer> subset, int[] nums){

        if(subList.size() == nums.length){
            result.add(new ArrayList<>(subList));
            return;
        }

        for(int i=0; i < nums.length; i++){

            if(subset.contains(nums[i])){
                continue;
            }

            subList.add(nums[i]);
            subset.add(nums[i]);
            helper(result, subList, subset, nums);
            subList.remove(subList.size() - 1);
            subset.remove(nums[i]);

        }

    }


    // Jiu Zhangs' Answer

    /*
    // Recursion
    *  public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> results = new ArrayList<>();
         if (nums == null) {
             return results;
         }

         if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
         }

         List<Integer> permutation = new ArrayList<Integer>();
         Set<Integer> set = new HashSet<>();
         helper(nums, permutation, set, results);

         return results;
    }

    // 1. 找到所有以permutation 开头的排列
    public void helper(int[] nums,
                       List<Integer> permutation,
                       Set<Integer> set,
                       List<List<Integer>> results) {
        // 3. 递归的出口
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }


        // [3] => [3,1], [3,2], [3,4] ...
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            permutation.add(nums[i]);
            set.add(nums[i]);
            helper(nums, permutation, set, results);
            set.remove(nums[i]);
            permutation.remove(permutation.size() - 1);
        }

    }
    *
    * */

    /*
    *
    // Non-Recursion
     public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> permutations
             = new ArrayList<List<Integer>>();
        if (nums == null) {

            return permutations;
        }

        if (nums.length == 0) {
            permutations.add(new ArrayList<Integer>());
            return permutations;
        }

        int n = nums.length;
        ArrayList<Integer> stack = new ArrayList<Integer>();

        stack.add(-1);
        while (stack.size() != 0) {
            Integer last = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);

            // increase the last number
            int next = -1;
            for (int i = last + 1; i < n; i++) {
                if (!stack.contains(i)) {
                    next = i;
                    break;
                }
            }
            if (next == -1) {
                continue;
            }

            // generate the next permutation
            stack.add(next);
            for (int i = 0; i < n; i++) {
                if (!stack.contains(i)) {
                    stack.add(i);
                }
            }

            // copy to permutations set
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                permutation.add(nums[stack.get(i)]);
            }
            permutations.add(permutation);
        }

        return permutations;
    }

    * */


    // Shuo Zhang's Answer

    /*
    *public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> permutation = new ArrayList<Integer>();

        if (nums == null || nums.length == 0){
            result.add(permutation);
            return result;
        }

        dfsHelper(nums, result, permutation);
        return result;
    }

    public void dfsHelper(int[] nums, List<List<Integer>> result, List<Integer> permutation){
        if (permutation.size() == nums.length){
            result.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (permutation.contains(nums[i])){
                continue;
            }
            permutation.add(nums[i]);
            dfsHelper(nums, result, permutation);
            permutation.remove(permutation.size() - 1);
        }
    }

    * */

}
