package code.lint.nine.dynamic;

public class ClimbingStairsII {
    /*
    *
    * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.

Have you met this question in a real interview? Yes
Example
n=3
1+1+1=2+1=1+2=3=3

return 4
    *
    * */

    public static void main(String[] args) {

        System.out.println("Needs " + climbStairs2(10));
    }


    /*
    * @param n: An integer
    * @return: An integer
    */
    public static int climbStairs2(int n) {
        // write your code here

        int[] f = new int[n+1];
        f[0] = 1;
        for(int i=0; i <=n; i++){
            for(int j = 1; j <= 3; j++){
                if(i >= j){
                    f[i] += f[i - j];
                }
            }
        }

        return f[n];
    }


    // Jiu Zhang's Answer

    /*
    *
    *  public int climbStairs2(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i = 0; i <= n; i++)
            for (int j = 1; j <= 3; j++) {
                if (i >= j) {
                    f[i] += f[i-j];
                }
            }
        return f[n];
    }
    *
    * */



    // Shuo Chang's Answer

    /*
    public int climbStairs2(int n) {
        if ( n <= 1){
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3 ; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    */

}
