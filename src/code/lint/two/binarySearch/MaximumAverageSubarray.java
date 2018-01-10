package code.lint.two.binarySearch;

/*
Given an array with positive and negative numbers,
find the maximum average subarray which length should be greater or equal to given length k.

 Notice

It's guaranteed that the size of the array is greater or equal to k.

Have you met this question in a real interview? Yes
Example
Given nums = [1, 12, -5, -6, 50, 3], k = 3

Return 15.667 // (-6 + 50 + 3) / 3 = 15.667

给出一个整数数组，有正有负。找到这样一个子数组，他的长度大于等于 k，且平均值最大。


*
* */
public class MaximumAverageSubarray {

    /*
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here

        double minum = Integer.MAX_VALUE;
        double maxmum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > maxmum){
                maxmum = nums[i];
            }

            if(nums[i] < minum){
                minum = nums[i];
            }
        }

        while (maxmum - minum >= 1e-6){

            double mid = (maxmum + minum) / 2;

            if(checkValid(nums, mid, k)){
                minum = mid;
            }else {
                maxmum = mid;
            }
        }

        return minum;

    }

    boolean checkValid(int[] nums, double mid, int k){

        int len = nums.length;
        double pre_min = 0;

        double sum[] = new double[len + 1];

        sum[0] = 0;

        for(int i = 1; i <= len; ++i){
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if(i >= k && sum[i] - pre_min >= 0){
                return true;
            }

            if(i >= k){
                pre_min = Math.min(pre_min, sum[i - k + 1]);
            }
        }

        return false;
    }


    // Jiu Zhang's Answer

    /*
    *
    * public double maxAverage(int[] nums, int k) {
        // Write your code here
        double l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < l)
                l = nums[i];
            if (nums[i] > r)
                r = nums[i];
        }


        while (r - l >= 1e-6) {
            double mid = (l + r) / 2.0;

            if (check_valid(nums, mid, k)) {
                l = mid;
            }
            else {
                r = mid;
            }
        }

        return l;
    }

    private boolean check_valid(int nums[], double mid, int k) {
        int n = nums.length;
        double min_pre = 0;
        double[] sum = new double[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if (i >= k && sum[i] - min_pre >= 0) {
                return true;
            }
            if (i >= k)
                min_pre = Math.min(min_pre, sum[i - k + 1]);
        }
        return false;
    }

    *
    * */


    // Shuo Chang's Answer

    /*
    *
    *    public double maxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return -1;
        }
        double maxmum = nums[0];
        double minum = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (maxmum > nums[i]){
                maxmum = nums[i];
            }
            if (minum < nums[i]){
                minum = nums[i];
            }
        }

         while (minum - maxmum > 1e-6){
            double mid = maxmum + (minum - maxmum) / 2.0;
            if (valid(nums, mid, k)){
                maxmum = mid;
            } else {
                minum = mid;
            }
        }
        return maxmum;
    }

    public boolean valid (int[] nums, double mid, int k){
        double[] sum = new double[nums.length + 1];
        sum[0] = 0;
        double min = 0;
        for (int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if (i >= k && sum[i] - min >= 0){
                return true;
            }
            if (i >= k){
                min = Math.min(min, sum[i - k + 1]);
            }
        }
        return false;
    }

    public boolean valid2(int[] prefix, double mid, int k){
        double min = 0;
        int i = k;
        while (i < prefix.length){
                    System.out.println(min);

            double sum = prefix[i] - mid * i - min;
            if (sum >= 0){
                return true;
            }
            min = Math.min(min, prefix[i - k + 1] - mid *(i -k +1));
            i++;
        }
        return false;
    }
    *
    * */

}
