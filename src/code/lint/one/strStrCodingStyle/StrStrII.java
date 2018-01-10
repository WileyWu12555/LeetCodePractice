package code.lint.one.strStrCodingStyle;


/*
* 594. strStr II

 Description
Implement strStr function in O(n + m) time.

strStr return the first index of the target string in a source string.
The length of the target string is m and the length of the source string is n.
If target does not exist in source, just return -1.

Have you met this question in a real interview? Yes
Example
Given source = abcdef, target = bcd, return 1.

实现时间复杂度为 O(n + m)的方法 strStr。
strStr 返回目标字串在源字串中第一次出现的第一个字符的位置.
目标字串的长度为 m , 源字串的长度为 n . 如果目标字串不在源字串中则返回 -1。
*
* */
public class StrStrII {

    /*
    * @param source: A source string
    * @param target: A target string
    * @return: An integer as index
    */
    public int strStr2(String source, String target) {
        // write your code here

        if(target == null){
            return -1;
        }

        if(source == null){
            return -1;
        }

        if(target.length() == 0 && source != null ){
            return 0;
        }

        if(source.length() == 0 ){
            return -1;
        }



        int mod = Integer.MAX_VALUE / 33;
        int m = target.length();
        int hash_target = 0;

        for(int i = 0; i < m; i++){
            hash_target = (hash_target * 33 + target.charAt(i) - 'a') % mod;

            if(hash_target < 0){
                hash_target = hash_target + mod;
            }
        }

        int m33 = 1;

        for(int i = 0; i < m - 1; ++i ){
            m33 = m33 * 33 % mod;
        }

        int value = 0;
        int n = source.length();
        for(int i = 0; i < n; ++ i ) {
            if (i >= m) {
                value = (value - m33 * (source.charAt(i - m) - 'a')) % mod;
            }

            value = (value * 33 + source.charAt(i) - 'a') % mod;

            if(value < 0){
                value = value + mod;
            }

            if(i >= m -1 && value == hash_target) {

                if (target.equals(source.substring(i - m + 1, i + 1))) {
                    return i - m + 1;
                }
            }
        }

        return -1;
    }

    // Jiu Zhang's Answer

    /*
    *
    * public int strStr2(String source, String target) {
        if(target == null) {
            return -1;
        }
        int m = target.length();
        if(m == 0 && source != null) {
            return 0;
        }

        if(source == null) {
            return -1;
        }
        int n = source.length();
        if(n == 0) {
            return -1;
        }

        // mod could be any big integer
        // just make sure mod * 33 wont exceed max value of int.
        int mod = Integer.MAX_VALUE / 33;
        int hash_target = 0;

        // 33 could be something else like 26 or whatever you want
        for (int i = 0; i < m; ++i) {
            hash_target = (hash_target * 33 + target.charAt(i) - 'a') % mod;
            if (hash_target < 0) {
                hash_target += mod;
            }
        }

        int m33 = 1;
        for (int i = 0; i < m - 1; ++i) {
            m33 = m33 * 33 % mod;
        }

        int value = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= m) {
                value = (value - m33 * (source.charAt(i - m) - 'a')) % mod;
            }

            value = (value * 33 + source.charAt(i) - 'a') % mod;
            if (value < 0) {
                value += mod;
            }

            if (i >= m - 1 && value == hash_target) {
                // you have to double check by directly compare the string
                if (target.equals(source.substring(i - m + 1, i + 1))) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
    *
    * */



    // Shuo Chang's Answer

    /*
    *
    *  public int strStr2(String source, String target) {
        if (source == null || target == null){
            return -1;
        }
        if (target.length() == 0){
            return 0;
        }
        if (target.length() > source.length()){
            return -1;
        }

        int capacity = 100000;
        int targetCode = 0;
        for (int i = 0; i < target.length(); i++){
            targetCode = (targetCode * 33 % capacity + target.charAt(i) % capacity) % capacity;
        }

        int power = 1;
        for (int i = 0; i < target.length(); i++){
            power = power * 33 % capacity;
        }

        int sourceCode = 0;
        for (int i = 0; i < source.length(); i++){
            sourceCode = (sourceCode * 33 % capacity + source.charAt(i) % capacity) % capacity;

            if (i < target.length() - 1){
                continue;
            }

            if (i >= target.length()){
                sourceCode = (sourceCode - source.charAt(i - target.length()) * power) % capacity;
                if (sourceCode < 0){
                    sourceCode += capacity;
                }
            }

            if (sourceCode == targetCode){
                if (source.substring(i - target.length() + 1, i + 1).equals(target)){
                    return i - target.length() + 1;
                }
            }

        }
        return -1;


    }
    *
    * */
}
