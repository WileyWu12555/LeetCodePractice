package code.lint.one.strStrCodingStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* Given a list of numbers that may has duplicate numbers, return all possible subsets

 Notice

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview? Yes
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Challenge
Can you do it in both recursively and iteratively?
*
*
*给定一个可能具有重复数字的列表，返回其所有可能的子集
*
* */
public class SubsetsII {

    /*
    * @param nums: A set of numbers.
    * @return: A list of lists. All valid subsets.
    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here

        List<List<Integer>> results = new ArrayList<>();

        if(nums == null){
            return results;
        }

        if(nums.length == 0){
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);

        List<Integer> subSet = new ArrayList<>();
        helper(subSet, 0, results, nums);
        return results;
    }


        public void helper(List<Integer> subset, int startIndex, List<List<Integer>> results, int[] nums ){

            results.add(new ArrayList<>(subset));
            for(int i = startIndex; i < nums.length; i++){
                if( i != startIndex && nums[i] == nums[i - 1] ){
                    continue;
                }
                subset.add(nums[i]);
                helper(subset, i + 1, results, nums);
                subset.remove(subset.size() - 1);
            }

        }


    // Jiu Zhangs' Answer
    // Method 1

    /*
    *
    * public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) return results;

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<Integer>();
        helper(nums, 0, subset, results);

        return results;


    }
    public void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results){
        results.add(new ArrayList<Integer>(subset));
        for(int i=startIndex; i<nums.length; i++){
            if (i != startIndex && nums[i]==nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i+1, subset, results);
            subset.remove(subset.size()-1);
        }
    }
    *
    * */

    // Method 2
    /*
    *
    * public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null) return results;

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);

        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, results);

         return results;


    }
    public void helper(int[] nums, int startIndex, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> results){
        results.add(new ArrayList<Integer>(subset));
        for(int i=startIndex; i<nums.length; i++){
            if (i != startIndex && nums[i]==nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i+1, subset, results);
            subset.remove(subset.size()-1);
        }
    }
    *
    * */


    // Shuo Chang's Answer
    /*
    *
    *  public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        if (nums == null || nums.length == 0){
            result.add(subset);
            return result;
        }
        Arrays.sort(nums);
        dfsHelper(result, subset, 0, nums);
        return result;
    }

    public void dfsHelper(ArrayList<ArrayList<Integer>> result,
                          ArrayList<Integer> subset,
                          int start,
                          int[] nums){
        result.add(new ArrayList<Integer>(subset));
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i - 1]){
                continue;
            }
            subset.add(nums[i]);
            dfsHelper(result, subset, i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }
    *
    * */
}
