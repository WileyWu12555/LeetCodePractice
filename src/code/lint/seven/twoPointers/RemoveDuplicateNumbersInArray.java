package code.lint.seven.twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicateNumbersInArray {

    /*
    *
    * Given an array of integers, remove the duplicate numbers in it.

You should:
1. Do it in place in the array.
2. Move the unique numbers to the front of the array.
3. Return the total number of the unique numbers.

 Notice

You don't need to keep the original order of the integers.

Have you met this question in a real interview? Yes
Example
Given nums = [1,3,1,4,4,2], you should:

Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
Return the number of unique integers in nums => 4.
Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.
    *
    * */

        Map<Integer, Integer> map = null;
        List<Integer> list = null;

        /*
         * @param nums: an array of integers
         * @return: the number of unique integers
         */
        public int deduplication(int[] nums) {
            // write your code here

            if (nums == null) {
                return 0;
            }

            map = new HashMap<>();
            list = new ArrayList<>();

            int count = 0;

            for (int i = 0; i < nums.length; i++) {

                if (!map.containsKey(nums[i])) {
                    count = count + 1;
                    map.put(nums[i], count);
                    list.add(nums[i]);
                }
            }

            int index = 0;
            for (int j : list) {
                nums[index] = j;
                index++;
            }

            return count;
        }
}


    // JIU ZHANG's Answer

    /*
    *
    * // O(n) time, O(n) space
    public class Solution {
   //
   // @param nums an array of integers
   // @return the number of unique integers
   //
    public int deduplication(int[] nums) {
        // Write your code here
        HashMap<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; ++i)
            mp.put(nums[i], true);

        int result = 0;
        for (Map.Entry<Integer, Boolean> entry : mp.entrySet())
            nums[result++] = entry.getKey();
        return result;
    }
}

// O(nlogn) time, O(1) extra space
public class Solution {
   //
   // @param nums an array of integers
   // @return the number of unique integers
   //
    public int deduplication(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }
}


    * */


    // Shuo Chang's Answer

    //nlog(n)
    // public int deduplication(int[] nums) {
    //     if(nums == null || nums.length == 0){
    //         return 0;
    //     }
    //     Arrays.sort(nums);
    //     int index = 0;
    //     for (int i =1; i < nums.length; i++){
    //         if(nums[i] != nums[i -1])
    //         nums[++index] = nums[i];
    //     }
    //     return index + 1;
    // }

    //O(n)

    /*
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            hashSet.add(nums[i]);
        }

        int i = 0;
        for (Integer element : hashSet){
            nums[i++] = element;
        }
        return i;
    }
 */

