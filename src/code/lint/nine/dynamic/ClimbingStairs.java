package code.lint.nine.dynamic;

/*
*
* You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Have you met this question in a real interview? Yes
Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3
*
* */

public class ClimbingStairs {

    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here

        if(n <= 1){
            return n;
        }

        int[] step = new int[n+1];

        step[0] = 1;
        step[1] = 1;

        for(int i = 2; i <= n; i++){
            step[i] = step[i - 1] + step[i - 2];
        }

        return step[n];

    }


    // JIU Zhang's answer
    /*

    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }

    * */


    // Shuo Chang's Answer

    /*
    *   public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n >= 0  && n < 2 ){
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n ; i++){
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
    *
    * */

}
