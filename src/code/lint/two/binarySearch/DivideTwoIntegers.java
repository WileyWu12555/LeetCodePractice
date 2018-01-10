package code.lint.two.binarySearch;

/*
*
* Divide two integers without using multiplication, division and mod operator.

If it is overflow, return 2147483647

Have you met this question in a real interview? Yes
Example
Given dividend = 100 and divisor = 9, return 11.

将两个整数相除，要求不使用乘法、除法和 mod 运算符。
*
* */

public class DivideTwoIntegers {

    // 2147483647

    /*
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */

    public static void main(String[] args) {
        System.out.println("result is: " + divide(5, 2));
    }

    public static int divide(int dividend, int divisor) {
        // write your code here

        if(divisor == 0){
            if(dividend >= 0){
                return Integer.MAX_VALUE;
            }else {
                return Integer.MIN_VALUE;
            }
        }

        if(dividend == 0){
            return 0;
        }

        if(dividend == Integer.MAX_VALUE && divisor == 1){
            return Integer.MAX_VALUE;
        }

        if(dividend == Integer.MAX_VALUE && divisor == -1){
            return Integer.MIN_VALUE;
        }

        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        if(dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }

        if(dividend == divisor){
            return 1;
        }


        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        long start = Math.abs((long) divisor);
        long current = start;
        long end = Math.abs((long) dividend);

        if(start == end && isNegative){
            return -1;
        }

        if(end < start){
            return 0;
        }

        int count = 0;

        while(current <= end ){
            current = current + start;
            count = count + 1;
        }

        return isNegative? -count : count;

    }

    // Jiu Zhang's Answer
    /*
    *
    *public int divide(int dividend, int divisor) {
        if (divisor == 0) {
             return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) ||
                             (dividend > 0 && divisor < 0);

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative? -result: result;
    }
    *
    * */


    // Shuo Chang's Answer
    /*
    *
    *     public int divide(int dividend, int divisor) {
        if (divisor == 0) {
             return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) ||
                             (dividend > 0 && divisor < 0);

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while(a >= b){
            int shift = 0;
            while(a >= (b << shift)){
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative? -result: result;
    }
    *
    * */

}
