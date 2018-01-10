package code.lint.one.strStrCodingStyle;


/*
* Given a set of distinct integers, return all possible subsets.

 Notice

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Challenge
Can you do it in both recursively and iteratively?
*
* 给定一个含不同整数的集合，返回其所有的子集
*
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();

        if(nums == null ){
            return result;
        }

        if(nums.length == 0){
            result.add(new ArrayList<Integer>());

            return result;
        }

        Arrays.sort(nums);

        ArrayList<Integer> subset = new ArrayList<>();

        helper(result, subset, 0, nums);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();

        helper(result, subset, 0, nums);

        System.out.println("Final result = " + result);
    }

    public static void helper(List<List<Integer>> result, List<Integer> subset, int startIndex, int[] nums){

        result.add(new ArrayList<>(subset));

        System.out.println("result = " + result);

        for(int i = startIndex; i < nums.length; i++){

            System.out.println("nums" + "["+ i +"] = " + nums[i]);

            System.out.println("Before add subset: " + subset);
            subset.add(nums[i]);

            System.out.println("After add subset: " + subset);
            helper(result, subset, i+1, nums);
            subset.remove(subset.size()-1);

            System.out.println("After remove size-1 from subset = " + subset);
        }
    }


    // Jiu Zhangs' Answer

    /*
    *
    *  public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }


    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private void helper(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> results) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(subset, nums, i + 1, results);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }

        // 3. 递归的出口
        // return;
    }
    *
    * */


    // Shuo Chang's Answer

    /*
    *
    * public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        if (nums == null || nums.length == 0){
            result.add(subset);
            return result;
        }
        Arrays.sort(nums);
        dfsHelper(result, subset, nums, 0);
        return result;

    }
    public void dfsHelper(ArrayList<ArrayList<Integer>> result,
                          ArrayList<Integer> subset,
                          int[] nums,
                          int start){
        result.add(new ArrayList<Integer>(subset));
        for (int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            dfsHelper(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
    *
    * */

}
