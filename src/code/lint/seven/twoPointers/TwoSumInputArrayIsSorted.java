package code.lint.seven.twoPointers;

public class TwoSumInputArrayIsSorted {

    /*
   * @param nums: an array of Integer
   * @param target: target = nums[index1] + nums[index2]
   * @return: [index1 + 1, index2 + 1] (index1 < index2)
   */

   /*
   public int[] twoSum(int[] nums, int target) {
        // write your code here
    }
    */


    // JIUZHANG'S Answer

    /*
    *
    * public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                int[] pair = new int[2];
                pair[0] = start + 1;
                pair[1] = end + 1;
                return pair;
            }
            if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return null;
    }
    *
    * */


    // Shuo Chang's Answer

    /*
    *
    * public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0){
            return result;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            if (nums[i] + nums[j] == target){
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (nums[i] + nums[j] < target){
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
    *
    * */

}
