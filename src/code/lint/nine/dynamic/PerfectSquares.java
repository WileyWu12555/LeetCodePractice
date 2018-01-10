package code.lint.nine.dynamic;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

/*
*
* Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Have you met this question in a real interview? Yes
Example
Given n = 12, return 3 because 12 = 4 + 4 + 4
Given n = 13, return 2 because 13 = 4 + 9
*
* */
public class PerfectSquares {

    public static void main(String[] args){

        int[] dp = new int[17];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= 16; ++i) {
            dp[i * i] = 1;
            System.out.println("dp[i * i] --> " +
                    "dp[" + i + "*" + i + "] --> "
                    + "dp[" + i*i + "]= " + " 1");
        }

        System.out.println("-----First loop End ----");

        for (int i = 0; i <= 16; ++i) {
            System.out.println("i = " + i);
            for (int j = 1; j * j <= i; ++j) {
                System.out.println("---- j = " + j + " ----");
                System.out.println("First dp[i] --> " +
                        "dp[" + i + "] = " + dp[i]);
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);

                System.out.println("dp[i - j * j] --> " +
                        "dp[" + i + " - " + j + " * " +j +"] --> " +
                        "dp[" + (i - j * j) + "] = " + dp[i - j * j] );

                System.out.println("Second dp[i] --> " +
                        "dp[" + i + "] = " + dp[i]);

                System.out.println("-----------");

            }
        }

        System.out.println("dp[16] = " + dp[16]);
    }

    /*
   * @param n: a positive integer
   * @return: An integer
   */
    public int numSquares(int n) {
        // write your code here

        while(n % 4 == 0){
            n = n / 4;
        }
        if(n % 8 == 7){
            return 4;
        }

        for(int i = 0; i * i <=n; ++i){
            int j = (int)Math.sqrt(n * 1.0 - i * i);
            if(i * i + j * j == n){
                int res = 0;

                if(i > 0){
                    res++;
                }
                if(j > 0){
                    res++;
                }

                return res;
            }
        }

        return 3;
    }


    // Jiu Zhang's Answer

    // Method 1
    /*
    *
    * public int numSquares(int n) {
    *
    * // Arrays.fill example:
    * //  int ar[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
      // Fill from index 1 to index 4.
      //  Arrays.fill(ar, 1, 5, 10);
      //  System.out.println(Arrays.toString(ar));
      // Result: [2, 10, 10, 10, 10, 2, 2, 2, 2]
    *
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i) {
            dp[i * i] = 1;
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
    *
    * */

    // Method 2
    /*
    *
    *   public int numSquares(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i)
            dp[i * i] = 1;

        for (int i = 0; i <= n; ++i)
            for (int j = 0; i + j * j <= n; ++j)
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);

        return dp[n];
    }
    *
    * */

    // Method 3

    /*
    *
    *  public int numSquares(int n) {
        // Write your code here
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        for (int i = 0; i * i <= n; ++i) {
            int j = (int)Math.sqrt(n * 1.0 - i * i);
            if (i * i + j * j == n) {
                int res = 0;
                if (i > 0)
                    res += 1;
                if (j > 0)
                    res += 1;
                return res;
            }
        }
        return 3;
    }
    *
    * */

    // Shuo Chang's Answer
    /*
    *
    *  public int numSquares(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i) {
            dp[i * i] = 1;
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
    *
    * */

}
