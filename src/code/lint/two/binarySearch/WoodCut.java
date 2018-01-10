package code.lint.two.binarySearch;


/*
*
 Given n pieces of wood with length L[i] (integer array).
 Cut them into small pieces to guarantee you could have equal or more than k pieces
 with the same length. What is the longest length you can get from the n pieces of wood?
 Given L & k, return the maximum length of the small pieces.

 Notice

You couldn't cut wood into float length.

If you couldn't get >= k pieces, return 0.

Have you met this question in a real interview? Yes
Example
For L=[232, 124, 456], k=7, return 114.

Challenge
O(n log Len), where Len is the longest length of the wood.




有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。
当然，我们希望得到的小段越长越好，你需要计算能够得到的小段木头的最大长度。

*
* */

import java.util.Arrays;

public class WoodCut {

    /*
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here

        if(L == null || L.length == 0){
            return 0;
        }

        int max = 0;

        for(int i = 0; i < L.length; i++){
            if(L[i] > max){
                max = L[i];
            }
        }

        if(L.length >= k){
            return L[0];
        }


        int start = 1;
        int end = max;

        while(start + 1 < end){

            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k){
                start = mid;
            }else {
                end = mid;
            }
        }

        if(count(L, end ) >= k){
            return end;
        }

        if(count(L, start) >= k){
            return start;
        }

        return 0;

    }

    public int count(int[] L, int length){

        int count = 0;

        for(int i = 0; i < L.length; i++){
            count += L[i] / length;
        }

        return count;

    }

    // Jiu Zhang's Answer

    /*
    *
    * public int woodCut(int[] L, int k) {
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }

        // find the largest length that can cut more than k pieces of wood.
        int start = 1, end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (count(L, end) >= k) {
            return end;
        }
        if (count(L, start) >= k) {
            return start;
        }
        return 0;
    }

    private int count(int[] L, int length) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / length;
        }
        return sum;
    }
    *
    * */


    // Shuo Chang's Answer
    /*
    *
    *  public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0 || k < 0){
            return 0;
        }

        int start = 0;
        int end = findMax(L);
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (check(mid, L) < k){
                end = mid;
            } else if (check(mid, L) > k){
                start = mid;
            } else {
                start = mid;
            }
        }

        if (check(end, L) >= k){
            return end;
        }
        return start;
    }

    public int findMax(int[] L){
        int max = -1;
        for (int i = 0; i < L.length; i++){
            max = Math.max(max, L[i]);
        }
        return max;
    }

    public int check(int mid, int[] L){
        int result = 0;
        for (int l : L){
            result += l / mid;
        }
        return result;
    }
    *
    * */

}
