package code.lint.eight.dataStructure;

import java.util.Arrays;
import java.util.PriorityQueue;


/*
*
* Find K-th largest element in an array. and N is much larger than k.

 Notice

You can swap elements in the array

Have you met this question in a real interview? Yes
Example
In array [9,3,2,4,8], the 3rd largest element is 4.

In array [1,2,3,4,5], the 1st largest element is 5,
2nd largest element is 4, 3rd largest element is 3 and etc.
*
* */

public class KthLargestElementII {

    public static void main(String[] args){

        int[] nums = {9,3,2,4,8};
        int result = kthLargestElement2(nums, 3);

        System.out.println("Result is: " + result);
    }

    public static int kthLargestElement2(int[] nums, int k) {
        // write your code here

        /*Arrays.sort(nums);

        return nums[nums.length - k];*/

        PriorityQueue<Integer> intq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){

            if(intq.size() < k){
               intq.add(nums[i]);
            }else{

                if(intq.peek() < nums[i]){
                    intq.poll();
                    intq.add(nums[i]);
                }
            }
        }

        return intq.peek();
    }



    // JIU ZHANG's answer
    //
    // @param nums an integer unsorted array
    // @param k an integer from 1 to n
    // @return the kth largest element
    /*
     public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            q.offer(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    */

    // Shuo Chang's Answer

    /*
    *
    *    public int kthLargestElement2(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i = 0; i < nums.length; i++){
            if (pq.size() < k){
                pq.offer(nums[i]);
                continue;
            }

            if (pq.peek() < nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }

        }

        int[] result = new int[k];
        while(!pq.isEmpty()){
            result[--k] = pq.poll();
        }
        return result[result.length - 1];
    }
    *
    * */
}
