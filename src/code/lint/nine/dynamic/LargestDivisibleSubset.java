package code.lint.nine.dynamic;

/*
*
* Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 Notice

If there are multiple solutions, return any subset is fine.

Have you met this question in a real interview? Yes
Example
Given nums = [1,2,3], return [1,2] or [1,3]

Given nums = [1,2,4,8], return [1,2,4,8]
*
* */

import java.util.*;

public class LargestDivisibleSubset {


    public static void main(String[] args){

        int[] f = new int[10];
        int[] pre = new int[10];
        for (int i = 0; i < 10; i++) {
            f[i] = 1;
            pre[i] = i;

            System.out.println("f[i] -> f[" + i + "] --- initial --- " + f[i]);
            System.out.println("pre[i] -> pre[" + i + "] --- initial --- " + pre[i]);
            System.out.println();

            for (int j = 0; j < i; j++) {
                int add = f[j] + 1;
                System.out.println("f[j] + 1 -> f[" + j + "] +1 = " + add);
                System.out.println();
                if (f[i] < f[j] + 1) {
                    System.out.println("f[i] -> f[" + i + "] --- first --- " + f[i]);
                    System.out.println("f[j] -> f[" + j + "] --- first --- " + f[j]);
                    System.out.println();
                    f[i] = f[j] + 1;
                    System.out.println("f[i] -> f[" + i + "]  --- second --- " + f[i]);
                    System.out.println();
                    pre[i] = j;
                    System.out.println("pre[i] -> pre[" + i + "]  : " + pre[i]);
                    System.out.println("--- inner loop end ---");
                    System.out.println();
                }
            }
            System.out.println("--- outer loop end ---");
            System.out.println();
        }

    }

    /*
    * @param nums: a set of distinct positive integers
    * @return: the largest subset
    */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here

        Arrays.sort(nums);
        int[] indexArray = new int[nums.length];
        int[] preIndex = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            indexArray[i] = 1;
            preIndex[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && indexArray[i] < indexArray[j] + 1) {
                    indexArray[i] = indexArray[j] + 1;
                    preIndex[i] = j;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }

        int max = 0;
        int max_index = 0;
        for(int i = 0; i < nums.length; i++){
            if(indexArray[i] > max){
                max = indexArray[i];
                max_index = i;
            }
        }

        ans.add(nums[max_index]);

        while(max_index != preIndex[max_index]){
            max_index = preIndex[max_index];
            ans.add(nums[max_index]);
        }

        Collections.reverse(ans);

        return ans;
    }

    // JIU Zhang's answer

    /*
    *
    *public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] f = new int[nums.length];
        int[] pre = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                    pre[i] = j;
                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        if (nums.length == 0) {
            return ans;
        }
        int max = 0;
        int max_i = 0;
        for (int i = 0; i < nums.length; i++) {
            if (f[i] > max) {
                max = f[i];
                max_i = i;
            }
        }
        ans.add(nums[max_i]);
        while (max_i != pre[max_i]) {
            max_i = pre[max_i];
            ans.add(nums[max_i]);
        }
        Collections.reverse(ans);
        return ans;
    }
    *
    * */


    // Shuo Chang's Answer
    /*
    *
    * public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            dp[i] = 1;
            pre[i] = -1;
        }

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }

        int max = 0;
        int preIndex = 0;
        for (int i = 0; i < nums.length; i++){
            if (max < dp[i]){
                max = dp[i];
                preIndex = i;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        result.add(nums[preIndex]);
        while (pre[preIndex] != -1){
                                    preIndex = pre[preIndex];

            result.add(nums[preIndex]);

        }

        //Collections.reverse(result);
        return result;
    }
    *
    * */
}
