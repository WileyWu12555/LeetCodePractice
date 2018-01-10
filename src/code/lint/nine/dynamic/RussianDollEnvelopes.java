package code.lint.nine.dynamic;


import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    /*
    *
    * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
    * One envelope can fit into another if and only if both the width and height of one envelope
    * is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Have you met this question in a real interview? Yes
Example
Given envelopes = [[5,4],[6,4],[6,7],[2,3]],
the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

给一定数量的信封，带有整数对 (w, h) 分别代表信封宽度和高度。
一个信封的宽高均大于另一个信封时可以放下另一个信封。
求最大的信封嵌套层数。

    *
    * */

    /*
   * @param envelopes: a number of envelopes with widths and heights
   * @return: the maximum number of envelopes
   */
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        if (envelopes == null || envelopes.length == 0 ||
                envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });

        int dp[] = new int[envelopes.length];
        int len = 0;

        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);

            if (index < 0) {
                index = -index - 1;
            }
            dp[index] = envelope[1];
            if (index == len) {
                len++;
            }
        }

        return len;
    }
}

    // Jiu Zhangs' Answer

    /*
    *
    * public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        if(envelopes == null || envelopes.length == 0
            || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
                if(index < 0)
                    index = -index - 1;
            dp[index] = envelope[1];
            if (index == len)
                len++;
        }
        return len;
    }
    *
    * */
