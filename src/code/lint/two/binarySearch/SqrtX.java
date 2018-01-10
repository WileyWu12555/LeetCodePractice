package code.lint.two.binarySearch;

/*
*
* Implement int sqrt(int x).

Compute and return the square root of x.

Have you met this question in a real interview? Yes
Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Challenge
O(log(x))

x的平方根
实现 int sqrt(int x) 函数，计算并返回 x 的平方根。
*
* */

public class SqrtX {

    /*
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here

        long start = 1;
        long end = x;

        while(start + 1 < end){
            long mid = start + (end - start) / 2;
            if(mid * mid <= x){
                start = mid;
            }else{
                end = mid;
            }
        }

        if(end * end <= x){
            return (int)end;
        }

        return (int)start;
    }


    // Jiu Zhang's Answer
    /*

    public int sqrt(int x) {
        // find the last number which square of it <= x
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }


    * */


    // Shuo Chang's Answer
    /*

    public int sqrt(int x) {
               // write your code here
        if ( x <= 0){
            return 0;
        }
        long start = 1;
        long end = x;
        while (start + 1 < end){
            long mid = start + (end - start) / 2;
            if (mid * mid < x){
                start = mid;
            } else if (mid * mid > x){
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end * end <= x){
            return (int)end;
        }
        return (int)start;
    }

    * */
}
